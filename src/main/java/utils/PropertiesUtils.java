package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
    private static final String configPath = "src/test/resources/config.properties";
    private static final Properties PROPERTIES = System.getProperties();

    private static void readProperties() {
        try {
            PROPERTIES.load(new FileInputStream(configPath));
        } catch (IOException e) {
            throw new RuntimeException("Properties has not been loaded");
        }
    }

    public static String getSystemProperty(String propertyKey) {
        String envProp = System.getenv(propertyKey);
        if (envProp == null) {
            readProperties();
            envProp = PROPERTIES.getProperty(propertyKey);
        }
        return envProp;
    }
}
