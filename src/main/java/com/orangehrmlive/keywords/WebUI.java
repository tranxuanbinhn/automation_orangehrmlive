package com.orangehrmlive.keywords;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WebUI {
    private static SoftAssert softAssert = new SoftAssert();
    public static void stopSoftAssertAll() {

        softAssert.assertAll();
    }

    public static void sleep(long second){
        try{
            Thread.sleep((long) (second*1000));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
public static void waitForPageLoad(){
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_PAGE_LOAD));
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
    ExpectedCondition<Boolean> jsload = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
    Boolean jsReady = javascriptExecutor.executeScript("return document.readyState").toString().equals("complete");
    if(!jsReady){
        try
        {
            wait.until(jsload);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    }
    public static void openWebsite(String url){
        sleep(FrameworkConstants.WAIT_SLEEP_STEP);
        DriverManager.getDriver().get(url);
        waitForPageLoad();


    }
    public static boolean verifyEquals(String actucal, String expect, String message){

        try{
            boolean result =  actucal.equals(expect);
            return result;
        }catch (Exception e){
            System.out.println(message);
            return false;
        }

    }
    public static String getTitlePage(){
        return DriverManager.getDriver().getTitle();
    }
    public static boolean verifyContains(String actual, String expect, String message){
        boolean result = actual.contains(expect);
        if(result){
            System.out.println(actual + " contains "+expect);
        }
        return result;
    }
    public static String getCurrentUrl(){
        return DriverManager.getDriver().getCurrentUrl();
    }
    public static void smartWait(){
        if(FrameworkConstants.ACTIVE_PAGE_LOADED.trim().equals("true")){
            waitForPageLoad();
        }if(FrameworkConstants.WAIT_SLEEP_STEP > 0){
            sleep(FrameworkConstants.WAIT_SLEEP_STEP);
        }
    }



}
