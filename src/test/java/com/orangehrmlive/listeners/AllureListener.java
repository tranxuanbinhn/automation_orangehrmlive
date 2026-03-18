package com.orangehrmlive.listeners;

import com.orangehrmlive.driver.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static  com.orangehrmlive.constants.FrameworkConstants.*;
public class AllureListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        if (SCREENSHOT_PASSED_TCS.equals(YES) && result.getStatus().equals(Status.PASSED)){
            if(DriverManager.getDriver() !=null){
                Allure.addAttachment(result.getName() +"_Passed_Screenshot",
                        new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));

            }
        } if (SCREENSHOT_FAILED_TCS.equals(YES) && result.getStatus().equals(Status.FAILED)){
            if(DriverManager.getDriver() !=null){
                Allure.addAttachment(result.getName() +"_Failed_Screenshot",
                        new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));

            }
        }
    }
}
