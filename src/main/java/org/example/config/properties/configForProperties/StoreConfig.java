package org.example.config.properties.configForProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreConfig {
    private Properties properties;

    public StoreConfig() {
        this.properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/main/java/org/example/config/properties/config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getChromeDriverPath() {
        return properties.getProperty("webdriver.chrome.driver.path");
    }

    public String getSpecialBrowserPath() {
        return properties.getProperty("special.browser.path");
    }

    public String getEmail() {
        return properties.getProperty("email");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getPhone() {
        return properties.getProperty("phone");
    }
}
