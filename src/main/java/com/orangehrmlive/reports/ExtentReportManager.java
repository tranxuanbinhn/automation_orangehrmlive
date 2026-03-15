package com.orangehrmlive.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.enums.AuthorType;
import com.orangehrmlive.enums.CategoryType;
import com.orangehrmlive.utils.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Objects;

public class ExtentReportManager {
    private static ExtentReports extentReports;
    private static String link = "";

    public static void initReports(){
        if(Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            if(FrameworkConstants.OVERRIDE_REPORTS.trim().equals(FrameworkConstants.NO)){
                LogUtils.info("Override report is no");
                link=FrameworkConstants.EXTENT_REPORT_FOLDER_PATH+ File.separator+
                        DateUtils.getCurrentDateTimeCustom("_")+"_" +FrameworkConstants.EXTENT_REPORT_FILE_NAME;
                LogUtils.info("Link Extent Report: " + link);
            }
            else {
                LogUtils.info("OVERRIDE EXTENT REPORTS = " + FrameworkConstants.OVERRIDE_REPORTS);
                link = FrameworkConstants.EXTENT_REPORT_FILE_PATH;
                LogUtils.info("Link Extent Report: " + link);
            }
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(link);
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setReportName(FrameworkConstants.REPORT_TITLE);
            extentSparkReporter.config().setReportName(FrameworkConstants.REPORT_TITLE);
            extentReports.setSystemInfo("Framework Name", FrameworkConstants.REPORT_TITLE);
            extentReports.setSystemInfo("Author", FrameworkConstants.AUTHOR);

            LogUtils.info("Extent Reports is installed.");
        }
    }
    public static void flushReports(){
        if(Objects.nonNull(extentReports)){
            extentReports.flush();
        }
        ExtentTestManager.unload();
        ReportUtils.openReports(link);
    }
    public static void createTest(String testcase){
    ExtentTestManager.setExtentTest(extentReports.createTest(IconUtils.getBrowserIcon()+" "+testcase));
    }
    public static void createTest(String testCaseName, String description) {
        ExtentTestManager.setExtentTest(extentReports.createTest(testCaseName, description));
    }
    public static void removeTest(String testcase){
        extentReports.removeTest(testcase);
    }
    public static void addScreenShot(String message) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);


        ExtentTestManager.getExtentTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

    }
    public static void addScreenShot(Status status ,String message) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getExtentTest().log(status, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

    }

    synchronized public static void addAuthors(AuthorType[] authors) {
        if (authors == null) {
            ExtentTestManager.getExtentTest().assignAuthor("ORANGEHRM");
        } else {
            for (AuthorType author : authors) {
                ExtentTestManager.getExtentTest().assignAuthor(author.toString());
            }
        }
    }
    synchronized public static void addCategories(CategoryType[] categories) {
        if (categories == null) {
            ExtentTestManager.getExtentTest().assignCategory("REGRESSION");
        } else {
            // for (String category : categories) {
            for (CategoryType category : categories) {
                ExtentTestManager.getExtentTest().assignCategory(category.toString());
            }
        }
    }
    synchronized public static void addDevices(){
        ExtentTestManager.getExtentTest().assignDevice(BrowserInfoUtils.getBrowserInfo());
    }
    public static void logMessage(String message) {
        ExtentTestManager.getExtentTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        ExtentTestManager.getExtentTest().log(status, message);
    }
    public static void pass(String message) {
        //LogUtils.info("ExtentReportManager class: " + ExtentTestManager.getExtentTest());
        ExtentTestManager.getExtentTest().pass(message);
    }

    public static void pass(Markup message) {
        ExtentTestManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentTestManager.getExtentTest().fail(message);
    }

    public static void fail(Object message) {
        ExtentTestManager.getExtentTest().fail((String) message);
    }

    public static void fail(Markup message) {
        ExtentTestManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentTestManager.getExtentTest().skip(message);
    }

    public static void skip(Markup message) {
        ExtentTestManager.getExtentTest().skip(message);
    }

    public static void info(Markup message) {
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void info(String message) {
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void warning(String message) {
        ExtentTestManager.getExtentTest().log(Status.WARNING, message);
    }




}
