package org.springframework.issues;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Workaround an issue with PathVariables.
 * 
 * Most of the controllers use a @RequestMapping like /circuits/{id}/extend.
 * 
 * But a circuit id can itself have a slash, an id of abc/def resuls in /circuits/abc/def/extend which doesn't match the
 * mapping.
 * 
 * This is handled, as usual, by escaping the reserved characters such that / becomes %2F when rendering the page (just
 * as a space becomes %20) @see URLEncoder
 * 
 * This PostProcessor tells spring not to decode the %2F until after it has looked up the handler mapping, so
 * /circuits/{id}/extend will match /circuits/abc%2Fdef/extend (but wouldn't match the decoded /circuits/abc/def/extend
 * 
 * @author cartedan
 * 
 */
@Component
public class HandlerMappingConfigurer implements BeanPostProcessor, PriorityOrdered {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RequestMappingHandlerMapping) {
            RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) bean;

            // URL decode after request mapping, not before.
            requestMappingHandlerMapping.setUrlDecode(false);

            // Workaround to make the previous fix work. See https://jira.springsource.org/browse/SPR-11101.
            requestMappingHandlerMapping.setAlwaysUseFullPath(true);

        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }
}
