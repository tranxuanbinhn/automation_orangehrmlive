package com.orangehrmlive.common;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.BrowserFactory;
import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters("BROWSER")
    @BeforeClass
    public void createDriver(@Optional("chrome") String browser){
        String browserName = (FrameworkConstants.BROWSER != null && !FrameworkConstants.BROWSER.isEmpty()) ? FrameworkConstants.BROWSER
                : browser;
        WebDriver webDriver = BrowserFactory.valueOf(browserName.toUpperCase()).createDriver();
        DriverManager.setDriver(webDriver);
    }
}
