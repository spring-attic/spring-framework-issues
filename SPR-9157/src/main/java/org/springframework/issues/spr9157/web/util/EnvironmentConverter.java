package org.springframework.issues.spr9157.web.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.issues.spr9157.Environment;
import org.springframework.util.StringUtils;

/**
 * Environment converter.
 */
public class EnvironmentConverter implements Converter<String, Environment> {
    private static final Logger LOG = LoggerFactory.getLogger(EnvironmentConverter.class);

    public Environment convert(String source) {
        LOG.debug("source: {}", source);
        if (!StringUtils.hasText(source)) {
            return null;
        }
        return new Environment(source.trim());
    }
}
