package com.orangehrmlive.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import com.orangehrmlive.annotations.FrameWorkAnnotation;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.enums.AuthorType;
import com.orangehrmlive.enums.Browser;
import com.orangehrmlive.enums.CategoryType;
import com.orangehrmlive.helpers.CaptureHelpers;
import com.orangehrmlive.helpers.FileHelpers;
import com.orangehrmlive.helpers.PropertiesHelpers;
import com.orangehrmlive.helpers.ScreenRecorderHelpers;
import com.orangehrmlive.keywords.WebUI;
import com.orangehrmlive.reports.AllureManager;
import com.orangehrmlive.reports.ExtentReportManager;
import com.orangehrmlive.reports.ExtentTestManager;
import com.orangehrmlive.utils.BrowserInfoUtils;
import com.orangehrmlive.utils.LogUtils;
import io.qameta.allure.Allure;
import org.testng.*;
import static com.orangehrmlive.constants.FrameworkConstants.*;
import java.io.IOException;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    static int count_passedTCs;
    static int count_failedTCs;
    static int count_skippedTCs;
    static int count_TotalTCs;
    private ScreenRecorderHelpers screenRecorderHelpers;
    @Override
    public void onStart(ISuite iSuite) {
        LogUtils.info("*******RUN START********");
        PropertiesHelpers.loadAllFiles();
        AllureManager.setAllureEnvironmentInformation();
        ExtentReportManager.initReports();
        LogUtils.info("========= INSTALLED CONFIGURATION DATA =========");
        LogUtils.info("=====> Starting Suite: " + iSuite.getName());

    }
    @Override
    public void onFinish(ISuite iSuite) {
        LogUtils.info("********** RUN FINISHED **********");
        LogUtils.info("=====> End Suite: " + iSuite.getName());
        ExtentReportManager.flushReports();
        AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("Target Execution", FrameworkConstants.TARGET).put("Global Timeout", String.valueOf(FrameworkConstants.WAIT_DEFAULT)).put("Page Load Timeout", String.valueOf(FrameworkConstants.WAIT_PAGE_LOADED)).put("Headless Mode", FrameworkConstants.HEADLESS).put("Local Browser", String.valueOf(Browser.CHROME)).put("Remote URL", FrameworkConstants.REMOTE_URL).put("Remote Port", FrameworkConstants.REMOTE_PORT).put("TCs Total", String.valueOf(count_TotalTCs)).put("TCs Passed", String.valueOf(count_passedTCs)).put("TCs Skipped", String.valueOf(count_skippedTCs)).put("TCs Failed", String.valueOf(count_failedTCs)).build());
        FileHelpers.copyFile("src/test/resources/config/allure/categories.json", "target/allure-results/categories.json");
        FileHelpers.copyFile("src/test/resources/config/allure/executor.json", "target/allure-results/executor.json");


        //FileHelpers.copyFile("src/test/resources/config/allure/environment.xml", "target/allure-results/environment.xml");

    }
    public String getTestName(ITestResult iTestResult){
        return iTestResult.getTestName() != null ? iTestResult.getTestName() :iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("TEST SUCCESS!!! Test case "+getTestName(result)+" pass");
        count_passedTCs+=1;
        if(FrameworkConstants.SCREENSHOT_PASSED_TCS.trim().toLowerCase().equals("yes")){
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(),getTestName(result));
            ExtentReportManager.addScreenShot(Status.PASS,getTestName(result));
        }
        ExtentReportManager.logMessage(Status.PASS, "Test case: " + getTestName(result) + " is passed.");
        if (FrameworkConstants.VIDEO_RECORD.trim().toLowerCase().equals("yes")) {
            WebUI.sleep(2);

            screenRecorderHelpers.stopRecording(true);

        }

    }


    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.info("TEST FAIL!!!! "+"Testcase "+getTestName(result)+" fail");
        count_failedTCs+=1;
        if(FrameworkConstants.SCREENSHOT_FAILED_TCS.trim().toLowerCase().equals("yes")){
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(result));
            ExtentReportManager.addScreenShot(Status.FAIL,getTestName(result));
        }
        ExtentReportManager.logMessage(Status.FAIL, "Test case: " + getTestName(result) + " is failed.");

        if (FrameworkConstants.VIDEO_RECORD.trim().toLowerCase().equals("yes")) {
            WebUI.sleep(2);

            screenRecorderHelpers.stopRecording(true);

        }
    }
public AuthorType[] getAuthorType(ITestResult iTestResult){
    if(iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)==null){
        return null;
    }
    return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class).author();
}
    public CategoryType[] getCategoryType(ITestResult iTestResult){
        if(iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)==null){
            return null;
        }
        return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class).category();
    }


    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Testcase "+getTestName(result)+" is starting....");
        count_TotalTCs+=1;
        ExtentReportManager.createTest(result.getTestName());
        ExtentReportManager.addAuthors(getAuthorType(result));
        ExtentReportManager.addCategories(getCategoryType(result));
        ExtentReportManager.addDevices();
        ExtentReportManager.info(BrowserInfoUtils.getOSInfo());
        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            screenRecorderHelpers.startRecording(getTestName(result));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("TEST SKIP!!!! "+"Testcase "+getTestName(result)+" skipped");
        count_skippedTCs+=1;
        if(FrameworkConstants.SCREENSHOT_SKIPPED_TCS.trim().toLowerCase().equals("yes")){
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(result));
        }
        ExtentReportManager.logMessage(Status.SKIP, "Test case: " + getTestName(result) + " is skipped.");

        if (FrameworkConstants.VIDEO_RECORD.trim().toLowerCase().equals("yes")) {
            WebUI.sleep(2);

            screenRecorderHelpers.stopRecording(true);

        }
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        ExtentReportManager.logMessage("Test failed but it is in defined success ratio: " + getTestName(iTestResult));
    }
}
