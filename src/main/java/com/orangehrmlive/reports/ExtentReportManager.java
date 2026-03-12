package com.orangehrmlive.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.utils.DateUtils;
import com.orangehrmlive.utils.LogUtils;
import com.orangehrmlive.utils.ReportUtils;

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


}
