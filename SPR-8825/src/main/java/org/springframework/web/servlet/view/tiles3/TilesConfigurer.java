/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet.view.tiles3;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.el.ArrayELResolver;
import javax.el.BeanELResolver;
import javax.el.CompositeELResolver;
import javax.el.ELResolver;
import javax.el.ListELResolver;
import javax.el.MapELResolver;
import javax.el.ResourceBundleELResolver;
import javax.servlet.ServletContext;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.TilesException;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.definition.DefinitionsFactoryException;
import org.apache.tiles.definition.DefinitionsReader;
import org.apache.tiles.definition.dao.BaseLocaleUrlDefinitionDAO;
import org.apache.tiles.definition.dao.CachingLocaleUrlDefinitionDAO;
import org.apache.tiles.definition.digester.DigesterDefinitionsReader;
import org.apache.tiles.el.ELAttributeEvaluator;
import org.apache.tiles.el.JspExpressionFactoryFactory;
import org.apache.tiles.el.TilesContextBeanELResolver;
import org.apache.tiles.el.TilesContextELResolver;
import org.apache.tiles.evaluator.AttributeEvaluatorFactory;
import org.apache.tiles.evaluator.BasicAttributeEvaluatorFactory;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.impl.BasicTilesContainer;
import org.apache.tiles.impl.mgmt.CachingTilesContainer;
import org.apache.tiles.locale.LocaleResolver;
import org.apache.tiles.preparer.BasicPreparerFactory;
import org.apache.tiles.preparer.PreparerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.apache.tiles.request.servlet.ServletUtil;
import org.apache.tiles.request.util.ApplicationContextAware;
import org.apache.tiles.startup.DefaultTilesInitializer;
import org.apache.tiles.startup.TilesInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.tiles2.SpringLocaleResolver;

/**
 * Helper class to configure Tiles 3.x for the Spring Framework. See
 * <a href="http://tiles.apache.org">http://tiles.apache.org</a>
 * for more information about Tiles, which basically is a templating
 * mechanism for JSP-based web applications.
 *
 * <p>The TilesConfigurer simply configures a TilesContainer using a set of files
 * containing definitions, to be accessed by {@link TilesView} instances. This is a
 * Spring-based alternative (for usage in Spring configuration) to the Tiles-provided
 * {@link org.apache.tiles.web.startup.TilesListener} (for usage in <code>web.xml</code>).
 *
 * <p>TilesViews can be managed by any {@link org.springframework.web.servlet.ViewResolver}.
 * For simple convention-based view resolution, consider using {@link TilesViewResolver}.
 *
 * <p>A typical TilesConfigurer bean definition looks as follows:
 *
 * <pre>
 * &lt;bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
 *   &lt;property name="definitions">
 *     &lt;list>
 *       &lt;value>/WEB-INF/defs/general.xml&lt;/value>
 *       &lt;value>/WEB-INF/defs/widgets.xml&lt;/value>
 *       &lt;value>/WEB-INF/defs/administrator.xml&lt;/value>
 *       &lt;value>/WEB-INF/defs/customer.xml&lt;/value>
 *       &lt;value>/WEB-INF/defs/templates.xml&lt;/value>
 *     &lt;/list>
 *   &lt;/property>
 * &lt;/bean></pre>
 *
 * The values in the list are the actual Tiles XML files containing the definitions.
 *
 * @author mick semb wever
 * @see TilesView
 * @see TilesViewResolver
 */
public class TilesConfigurer implements ServletContextAware, InitializingBean, DisposableBean {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private TilesInitializer tilesInitializer;

	private boolean completeAutoload = false;

	private String[] definitions;

	private boolean checkRefresh = false;

	private boolean validateDefinitions = true;

	private Class<? extends DefinitionsFactory> definitionsFactoryClass;

	private Class<? extends PreparerFactory> preparerFactoryClass;

	private boolean useMutableTilesContainer = false;

	private final Map<String, String> tilesPropertyMap = new HashMap<String, String>();

	private ServletContext servletContext;


	public TilesConfigurer() {
	}

	/**
	 * Configure Tiles using a custom TilesInitializer, typically specified as an inner bean.
	 * <p>Default is a variant of {@link org.apache.tiles.startup.DefaultTilesInitializer},
	 * respecting the "definitions", "preparerFactoryClass" etc properties on this configurer.
	 * <p><b>NOTE: Specifying a custom TilesInitializer effectively disables all other bean
	 * properties on this configurer.</b> The entire initialization procedure is then left
	 * to the TilesInitializer as specified.
	 */
	public void setTilesInitializer(TilesInitializer tilesInitializer) {
		this.tilesInitializer = tilesInitializer;
	}

	/**
	 * Specify whether to apply Tiles 3.0's "complete-autoload" configuration.
	 * <p>See {@link org.apache.tiles.extras.complete.CompleteAutoloadTilesContainerFactory}
	 * for details on the complete-autoload mode.
	 * <p><b>NOTE: Specifying the complete-autoload mode effectively disables all other bean
	 * properties on this configurer.</b> The entire initialization procedure is then left
	 * to {@link org.apache.tiles.extras.complete.CompleteAutoloadTilesInitializer}.
	 * @see org.apache.tiles.extras.complete.CompleteAutoloadTilesContainerFactory
	 * @see org.apache.tiles.extras.complete.CompleteAutoloadTilesInitializer
	 */
	public void setCompleteAutoload(boolean completeAutoload) {
		if (completeAutoload) {
			try {
				Class clazz = getClass().getClassLoader().loadClass(
						"org.apache.tiles.extras.complete.CompleteAutoloadTilesInitializer");
				this.tilesInitializer = (TilesInitializer) clazz.newInstance();
			}
			catch (Exception ex) {
				throw new IllegalStateException("Tiles-Extras 3.0 not available", ex);
			}
		}
		else {
			this.tilesInitializer = null;
		}
	}

	/**
	 * Set the Tiles definitions, i.e. the list of files containing the definitions.
	 * Default is "/WEB-INF/tiles.xml".
	 */
	public void setDefinitions(String[] definitions) {
		this.definitions = definitions;
		if (definitions != null) {
			String defs = StringUtils.arrayToCommaDelimitedString(definitions);
			if (logger.isInfoEnabled()) {
				logger.info("TilesConfigurer: adding definitions [" + defs + "]");
			}
			this.tilesPropertyMap.put(DefinitionsFactory.DEFINITIONS_CONFIG, defs);
		}
		else {
			this.tilesPropertyMap.remove(DefinitionsFactory.DEFINITIONS_CONFIG);
		}
	}

	/**
	 * Set whether to check Tiles definition files for a refresh at runtime.
	 * Default is "false".
	 */
	public void setCheckRefresh(boolean checkRefresh) {
		this.checkRefresh = checkRefresh;
		this.tilesPropertyMap.put(CachingLocaleUrlDefinitionDAO.CHECK_REFRESH_INIT_PARAMETER,
				Boolean.toString(checkRefresh));
	}

	/**
	 * Set whether to validate the Tiles XML definitions. Default is "true".
	 */
	public void setValidateDefinitions(boolean validateDefinitions) {
		this.validateDefinitions = validateDefinitions;
		this.tilesPropertyMap.put(DigesterDefinitionsReader.PARSER_VALIDATE_PARAMETER_NAME,
				Boolean.toString(validateDefinitions));
	}

	/**
	 * Set the {@link org.apache.tiles.definition.DefinitionsFactory} implementation to use.
	 * Default is {@link org.apache.tiles.definition.UrlDefinitionsFactory},
	 * operating on definition resource URLs.
	 * <p>Specify a custom DefinitionsFactory, e.g. a UrlDefinitionsFactory subclass,
	 * to customize the creation of Tiles Definition objects. Note that such a
	 * DefinitionsFactory has to be able to handle {@link java.net.URL} source objects,
	 * unless you configure a different TilesContainerFactory.
	 */
	public void setDefinitionsFactoryClass(Class<? extends DefinitionsFactory> definitionsFactoryClass) {
		this.definitionsFactoryClass = definitionsFactoryClass;
	}

	/**
	 * Set the {@link org.apache.tiles.preparer.PreparerFactory} implementation to use.
	 * Default is {@link org.apache.tiles.preparer.BasicPreparerFactory}, creating
	 * shared instances for specified preparer classes.
	 * <p>Specify {@link SimpleSpringPreparerFactory} to autowire
	 * {@link org.apache.tiles.preparer.ViewPreparer} instances based on specified
	 * preparer classes, applying Spring's container callbacks as well as applying
	 * configured Spring BeanPostProcessors. If Spring's context-wide annotation-config
	 * has been activated, annotations in ViewPreparer classes will be automatically
	 * detected and applied.
	 * <p>Specify {@link SpringBeanPreparerFactory} to operate on specified preparer
	 * <i>names</i> instead of classes, obtaining the corresponding Spring bean from
	 * the DispatcherServlet's application context. The full bean creation process
	 * will be in the control of the Spring application context in this case,
	 * allowing for the use of scoped beans etc. Note that you need to define one
	 * Spring bean definition per preparer name (as used in your Tiles definitions).
	 * @see SimpleSpringPreparerFactory
	 * @see SpringBeanPreparerFactory
	 */
	public void setPreparerFactoryClass(Class<? extends PreparerFactory> preparerFactoryClass) {
		this.preparerFactoryClass = preparerFactoryClass;
	}

	/**
	 * Set whether to use a MutableTilesContainer (typically the CachingTilesContainer
	 * implementation) for this application. Default is "false".
	 * @see org.apache.tiles.mgmt.MutableTilesContainer
	 * @see org.apache.tiles.mgmt.CachingTilesContainer
	 */
	public void setUseMutableTilesContainer(boolean useMutableTilesContainer) {
		this.useMutableTilesContainer = useMutableTilesContainer;
	}


    @Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}


	/**
	 * Creates and exposes a TilesContainer for this web application,
	 * delegating to the TilesInitializer.
	 * @throws TilesException in case of setup failure
	 * @see #createTilesInitializer()
	 */
    @Override
	public void afterPropertiesSet() throws TilesException {

        ServletApplicationContext preliminaryContext = new ServletApplicationContext(servletContext);
 		if (this.tilesInitializer == null) {
			this.tilesInitializer = createTilesInitializer();
		}
 		this.tilesInitializer.initialize(preliminaryContext);

        BasicTilesContainer container = (BasicTilesContainer) TilesAccess
                .getContainer(ServletUtil.getApplicationContext(servletContext));

		if (this.completeAutoload) {
			// We need to do this after initialization simply because we're reusing the
			// original CompleteAutoloadTilesInitializer above. We cannot subclass
			// CompleteAutoloadTilesInitializer when compiling against Tiles 2.1...
			logger.debug("Registering Tiles 3.0 LocaleResolver for complete-autoload setup");
 			try {
				DefinitionsFactory definitionsFactory = container.getDefinitionsFactory();
				Method setter = definitionsFactory.getClass().getMethod("setLocaleResolver", LocaleResolver.class);
				setter.invoke(definitionsFactory, new SpringLocaleResolver());
			}
			catch (Exception ex) {
				throw new IllegalStateException("Cannot override LocaleResolver with SpringLocaleResolver", ex);
			}
		}
	}

	/**
	 * Creates a new instance of {@link org.apache.tiles.startup.DefaultTilesInitializer}.
	 * <p>Override it to use a different initializer.
	 * @see org.apache.tiles.web.startup.TilesListener#createTilesInitializer()
	 */
	protected TilesInitializer createTilesInitializer() {
		return new SpringTilesInitializer();
	}

	/**
	 * Removes the TilesContainer from this web application.
	 * @throws TilesException in case of cleanup failure
	 */
    @Override
	public void destroy() throws TilesException {
		tilesInitializer.destroy();
	}


	private class SpringTilesInitializer extends DefaultTilesInitializer {

		@Override
		protected AbstractTilesContainerFactory createContainerFactory(ApplicationContext context) {
			return new SpringTilesContainerFactory();
		}
	}


	private class SpringTilesContainerFactory extends BasicTilesContainerFactory {

        @Override
        public TilesContainer createContainer(ApplicationContext applicationContext) {
            TilesContainer container = super.createContainer(applicationContext);
			return (useMutableTilesContainer ? new CachingTilesContainer(container) : container);
        }

		@Override
		protected List<URL> getSourceURLs(ApplicationContext applicationContext) {
			if (definitions != null) {
				try {
					List<URL> result = new LinkedList<URL>();
					for (String definition : definitions) {
						result.addAll(applicationContext.getResources(definition));
					}
					return result;
				}
				catch (IOException ex) {
					throw new DefinitionsFactoryException("Cannot load definition URLs", ex);
				}
			}
			else {
				return super.getSourceURLs(applicationContext);
			}
		}

		@Override
		protected BaseLocaleUrlDefinitionDAO instantiateLocaleDefinitionDao(
                ApplicationContext applicationContext,
                LocaleResolver resolver) {
			BaseLocaleUrlDefinitionDAO dao = super.instantiateLocaleDefinitionDao(applicationContext, resolver);
			if (checkRefresh && dao instanceof CachingLocaleUrlDefinitionDAO) {
				((CachingLocaleUrlDefinitionDAO) dao).setCheckRefresh(checkRefresh);
			}
			return dao;
		}

		@Override
		protected DefinitionsReader createDefinitionsReader(ApplicationContext applicationContext) {
			DigesterDefinitionsReader reader = (DigesterDefinitionsReader) super.createDefinitionsReader(applicationContext);
            reader.setValidating(validateDefinitions);
			return reader;
		}

		@Override
		protected DefinitionsFactory createDefinitionsFactory(
                ApplicationContext applicationContext,
                LocaleResolver resolver) {

			if (definitionsFactoryClass != null) {
				DefinitionsFactory factory = BeanUtils.instantiate(definitionsFactoryClass);
 				if (factory instanceof ApplicationContextAware) {
					((ApplicationContextAware) factory).setApplicationContext(applicationContext);
				}
				BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(factory);
				if (bw.isWritableProperty("localeResolver")) {
					bw.setPropertyValue("localeResolver", resolver);
				}
				if (bw.isWritableProperty("definitionDAO")) {
					bw.setPropertyValue("definitionDAO",
							createLocaleDefinitionDao(applicationContext, resolver));
				}
				return factory;
			}else {
				return super.createDefinitionsFactory(applicationContext, resolver);
			}
		}

		@Override
		protected PreparerFactory createPreparerFactory(ApplicationContext applicationContext) {
			if (preparerFactoryClass != null) {
				return BeanUtils.instantiate(preparerFactoryClass);
			}else {
				return super.createPreparerFactory(applicationContext);
			}
		}

		@Override
		protected LocaleResolver createLocaleResolver(ApplicationContext applicationContext) {
			return new SpringLocaleResolver();
		}

        @Override
        protected AttributeEvaluatorFactory createAttributeEvaluatorFactory(ApplicationContext applicationContext, LocaleResolver resolver) {
            return new BasicAttributeEvaluatorFactory(createELEvaluator(applicationContext));
        }

        /**
         * Creates the EL evaluator.
         *
         * @param applicationContext The Tiles application context.
         * @return The EL evaluator.
         */
        private ELAttributeEvaluator createELEvaluator(final ApplicationContext applicationContext) {

            final ELAttributeEvaluator evaluator = new ELAttributeEvaluator();
            final JspExpressionFactoryFactory efFactory = new JspExpressionFactoryFactory();
            efFactory.setApplicationContext(applicationContext);
            evaluator.setExpressionFactory(efFactory.getExpressionFactory());
            final ELResolver elResolver = new CompositeELResolverImpl();
            evaluator.setResolver(elResolver);
            return evaluator;
        }
    }

    private static class CompositeELResolverImpl extends CompositeELResolver {

        public CompositeELResolverImpl(){
            TilesContextBeanELResolver resolver = new TilesContextBeanELResolver();
            add(new TilesContextELResolver(resolver));
            add(resolver);
            add(new ArrayELResolver(false));
            add(new ListELResolver(false));
            add(new MapELResolver(false));
            add(new ResourceBundleELResolver());
            add(new BeanELResolver(false));
        }
    }
}
