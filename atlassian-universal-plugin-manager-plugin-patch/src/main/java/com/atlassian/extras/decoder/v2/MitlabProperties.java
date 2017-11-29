package com.atlassian.extras.decoder.v2;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MitlabProperties extends Properties {
    private static final Logger LOGGER = Logger.getLogger(MitlabProperties.class.getName());
    private static final long serialVersionUID = -5557054948226873104L;
    private final Properties localProps;

    public MitlabProperties() {
        this(null);
    }
    
    private MitlabProperties(Properties props) {
        this.localProps = props;
    }
    
    @Override
    public String getProperty(String key) {
        String value = localProps == null ? super.getProperty(key) : localProps.getProperty(key);
        if (LOGGER.isLoggable(Level.INFO)) {
            StringBuilder info = new StringBuilder("MitlabProperties's getProperty{key:");
            info.append(key).append(", value:").append(value).append("}");
            LOGGER.info(info.toString());
        }
        return value == null ? value : value.trim();
    }

    @Override
    public String getProperty(String key, String defaultValue) {
        String value = localProps == null ? super.getProperty(key, defaultValue) : localProps.getProperty(key, defaultValue);
        if (LOGGER.isLoggable(Level.INFO)) {
            StringBuilder info = new StringBuilder("MitlabProperties's getProperty{key:");
            info.append(key).append(", value:").append(value).append(", defaultValue:").append(defaultValue).append("}");
            LOGGER.info(info.toString());
        }
        return value == null ? value : value.trim();
    }
    
    
}
