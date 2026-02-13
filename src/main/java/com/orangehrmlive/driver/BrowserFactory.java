package com.orangehrmlive.driver;

import com.orangehrmlive.constants.FrameworkConstants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public enum BrowserFactory {
    CHROME{
        public ChromeOptions getOptions(){
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("profile.password_manager_leak_detection", false); // Turn off change your password
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("autofill.profile_enabled", false); //Turn off Save Address popup
            options.setExperimentalOption("prefs", prefs);

            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");

            options.setAcceptInsecureCerts(true);

            if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--high-dpi-support=1");
                options.addArguments("--force-device-scale-factor=1");
            } else {
                options.addArguments(START_MAXIMIZED);
            }

            return options;
        }
    };

    private static final String START_MAXIMIZED = "--start-maximized";
}
