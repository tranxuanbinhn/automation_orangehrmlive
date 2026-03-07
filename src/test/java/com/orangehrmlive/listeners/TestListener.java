package com.orangehrmlive.listeners;

import com.aventstack.extentreports.model.ScreenCapture;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.helpers.CaptureHelpers;
import com.orangehrmlive.helpers.PropertiesHelpers;
import com.orangehrmlive.helpers.ScreenRecorderHelpers;
import com.orangehrmlive.keywords.WebUI;
import com.orangehrmlive.utils.LogUtils;
import org.testng.*;

import java.io.IOException;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    static int count_passedTCs;
    static int count_failedTCs;
    static int count_skippedTCs;
    private ScreenRecorderHelpers screenRecorderHelpers;
    @Override
    public void onStart(ISuite iSuite) {
        LogUtils.info("*******RUN START********");
        PropertiesHelpers.loadAllFiles();
        LogUtils.info("========= INSTALLED CONFIGURATION DATA =========");
        LogUtils.info("=====> Starting Suite: " + iSuite.getName());
    }
    @Override
    public void onFinish(ISuite iSuite) {
        LogUtils.info("********** RUN FINISHED **********");
        LogUtils.info("=====> End Suite: " + iSuite.getName());
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
        }
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
        }
        if (FrameworkConstants.VIDEO_RECORD.trim().toLowerCase().equals("yes")) {
            WebUI.sleep(2);

            screenRecorderHelpers.stopRecording(true);

        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("TEST SKIP!!!! "+"Testcase "+getTestName(result)+" skipped");
        count_skippedTCs+=1;
        if(FrameworkConstants.SCREENSHOT_SKIPPED_TCS.trim().toLowerCase().equals("yes")){
            CaptureHelpers.captureScreenshot(DriverManager.getDriver(), getTestName(result));
        }
        if (FrameworkConstants.VIDEO_RECORD.trim().toLowerCase().equals("yes")) {
            WebUI.sleep(2);

            screenRecorderHelpers.stopRecording(true);

        }
    }
}
