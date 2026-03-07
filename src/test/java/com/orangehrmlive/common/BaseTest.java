package com.orangehrmlive.common;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.BrowserFactory;
import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.keywords.WebUI;
import com.orangehrmlive.listeners.TestListener;
import com.orangehrmlive.projects.crm.pages.CommonPageCRM;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends CommonPageCRM {
    @Parameters("BROWSER")
    @BeforeClass
    public void createDriver(@Optional("chrome") String browser){
        String browserName = (FrameworkConstants.BROWSER != null && !FrameworkConstants.BROWSER.isEmpty()) ? FrameworkConstants.BROWSER
                : browser;
        WebDriver webDriver = BrowserFactory.valueOf(browserName.toUpperCase()).createDriver();
        DriverManager.setDriver(webDriver);
    }
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        WebUI.stopSoftAssertAll();
        DriverManager.quit();
    }
}
