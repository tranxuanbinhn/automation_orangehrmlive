package com.orangehrmlive.driver;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.enums.Target;
import com.orangehrmlive.exceptions.TargetNotValidException;
import com.orangehrmlive.utils.LogUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TargetFactory {
    public WebDriver createInstance(String browser){
        Target target = Target.valueOf(FrameworkConstants.TARGET.toUpperCase());
        WebDriver webDriver;
        String browserName = (FrameworkConstants.BROWSER != null && !FrameworkConstants.BROWSER.isEmpty()) ? FrameworkConstants.BROWSER
                : browser;
        Allure.step("\uD83E\uDD16 Run on browser: " + browserName);
        switch (target){
            case LOCAL:
                webDriver = BrowserFactory.valueOf(browserName.toUpperCase()).createDriver();
                break;
            case REMOTE:
                //Create new driver on Cloud (Selenium Grid, Docker) from method below
                webDriver = createRemoteInstance(BrowserFactory.valueOf(browserName.toUpperCase()).getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return webDriver;

    }
    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", FrameworkConstants.REMOTE_URL, FrameworkConstants.REMOTE_PORT);
            LogUtils.info("Remote URL: " + gridURL);
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
        } catch (java.net.MalformedURLException e) {
            LogUtils.error("Grid URL is invalid or Grid Port is not available");
            LogUtils.error(String.format("Browser: %s", capability.getBrowserName()), e);
        } catch (IllegalArgumentException e) {
            LogUtils.error(String.format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
        }

        return remoteWebDriver;
    }

}
