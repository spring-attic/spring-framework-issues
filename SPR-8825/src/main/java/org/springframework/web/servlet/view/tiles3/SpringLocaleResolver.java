package org.springframework.web.servlet.view.tiles3;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.apache.tiles.locale.impl.DefaultLocaleResolver;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.servlet.NotAServletEnvironmentException;
import org.apache.tiles.request.servlet.ServletUtil;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Tiles LocaleResolver adapter that delegates to a Spring
 * {@link org.springframework.web.servlet.LocaleResolver}, exposing the
 * DispatcherServlet-managed locale.
 * 
 * <p>
 * This adapter gets automatically registered by {@link TilesConfigurer}.
 * 
 * @author Nicolas Le Bas
 * @since 3.2
 * @see org.apache.tiles.definition.UrlDefinitionsFactory#LOCALE_RESOLVER_IMPL_PROPERTY
 */
public class SpringLocaleResolver extends DefaultLocaleResolver {

    @Override
    public Locale resolveLocale(Request request) {
        try {
            HttpServletRequest httpRequest = ServletUtil.getServletRequest(request).getRequest();
            return RequestContextUtils.getLocale(httpRequest);
        } catch (NotAServletEnvironmentException e) {
            return super.resolveLocale(request);
        }
    }

}
