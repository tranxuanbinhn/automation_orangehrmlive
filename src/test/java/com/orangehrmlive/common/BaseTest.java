package com.orangehrmlive.common;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.BrowserFactory;
import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.driver.TargetFactory;
import com.orangehrmlive.helpers.PropertiesHelpers;
import com.orangehrmlive.keywords.WebUI;
import com.orangehrmlive.listeners.TestListener;
import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends CommonPageCRM {
    @Parameters("BROWSER")
    @BeforeClass
    public void createDriver(@Optional("chrome") String browser){
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
            driver.manage().window().setSize(new Dimension(1920, 1080)); // ép Selenium resize
            System.out.println("Actual window size: " + driver.manage().window().getSize());
        } else {
            driver.manage().window().maximize();
        }
        DriverManager.setDriver(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        WebUI.stopSoftAssertAll();
        DriverManager.quit();
    }

    public WebDriver createBrowser(@Optional("chrome") String browser) {
        PropertiesHelpers.loadAllFiles();
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
            driver.manage().window().setSize(new Dimension(1920, 1080)); // ép Selenium resize
            System.out.println("Actual window size: " + driver.manage().window().getSize());
        } else {
            driver.manage().window().maximize();
        }
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
    }
}
