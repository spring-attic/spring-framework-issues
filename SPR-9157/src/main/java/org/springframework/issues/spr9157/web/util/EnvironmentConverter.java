package org.springframework.issues.spr9157.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.issues.spr9157.model.EnhancedEnvironmentImpl;
import org.springframework.issues.spr9157.model.Environment;
import org.springframework.util.StringUtils;

/**
 * Environment converter.
 * 
 * @author ferengra
 */
public class EnvironmentConverter implements Converter<String, Environment> {
    private static final Logger LOG = LoggerFactory.getLogger(EnvironmentConverter.class);

    public Environment convert(String source) {
        LOG.debug("source: {}", source);
        if (!StringUtils.hasText(source)) {
            return null;
        }
        return new EnhancedEnvironmentImpl(source.trim(), source.trim());
    }
}
