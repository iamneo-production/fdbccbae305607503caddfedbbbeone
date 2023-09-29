package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
    private static final String CONFIG_FILE_PATH = "/config/browser.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = ReadPropertyFile.class.getResourceAsStream(CONFIG_FILE_PATH)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBrowserName() {
        return getProperty("browsername");
    }
}
