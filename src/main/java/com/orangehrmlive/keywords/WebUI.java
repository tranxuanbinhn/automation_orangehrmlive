package com.orangehrmlive.keywords;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_PAGE_LOADED));
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
    public static WebElement waitForElementPresent(By by){
        try{
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isElementVisible(By by, int second){
        try{
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
             wait.until(ExpectedConditions.visibilityOfElementLocated(by));
             return true;
        }catch (TimeoutException e){
            return false;
        }
    }
    public static WebElement getWebElement(By by){
        return DriverManager.getDriver().findElement(by);
    }
    public static void scrollToElementAtBottom(By by){
        try{
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(false);",getWebElement(by));
        }
        catch (TimeoutException e){

        }
    }
    public static WebElement waitForElementVisible(By by){
        waitForElementPresent(by);
        try{
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT));
            boolean visible = isElementVisible(by,1);
            if(visible){
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            else {
                scrollToElementAtBottom(by);
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        }
        catch (Throwable throwable){
            return null;

    }

    }
    public static void clearText(By by){
        smartWait();
        waitForElementPresent(by).clear();
    }
    public static void setText(By by, String value){
        smartWait();
        waitForElementVisible(by).sendKeys(value);
    }
    public static void clickElement(By by){
        smartWait();
        waitForElementVisible(by).click();
    }
    public static void verifyElementPresent(By by, int timeout, String message){
        smartWait();
        try{
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch (Exception e){

        System.out.println(message);
        }

    }






}
