package com.orangehrmlive.reports;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.enums.Browser;
import com.orangehrmlive.utils.BrowserInfoUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {
    private AllureManager() {
    }
    public static void setAllureEnvironmentInformation(){
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("TEST URL", FrameworkConstants.URL_CRM).
                        put("Target Execution", FrameworkConstants.TARGET).
                        put("Global Timeout", String.valueOf(FrameworkConstants.WAIT_DEFAULT)).
                        put("Page Load Timeout", String.valueOf(FrameworkConstants.WAIT_PAGE_LOADED)).
                        put("Headless Mode", FrameworkConstants.HEADLESS).
                        put("Local Browser", String.valueOf(Browser.CHROME)).
                        put("Remote URL", FrameworkConstants.REMOTE_URL).
                        put("Remote Port", FrameworkConstants.REMOTE_PORT).
                        build());
    }
    @Attachment(value = "Fail test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport()
    {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception e) {

        }
        return new byte[0];
    }
    @Attachment(value = "Step ScreenShot", type = "image/png")
    public static byte[] takeScreenshotStep()
    {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception e) {

        }
        return new byte[0];
    }
    @Attachment(value = "Browser Information", type = "text/plain")
    public static String addBrowserInformationOnAllureReport() {
        return BrowserInfoUtils.getOSInfo();
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String saveTextlog(String message){
        return message;
    }
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html){
        return html;
    }

}
