package com.orangehrmlive.constants;

import com.orangehrmlive.helpers.PropertiesHelpers;
import com.orangehrmlive.helpers.SystemHelpers;

import java.io.File;
import java.io.IOException;

public final class FrameworkConstants {
    private FrameworkConstants(){

    }

    static {
        PropertiesHelpers.loadAllFiles();
    }
    public static final String YES = "yes";
    public static final String NO = "no";

    public static final String EXTENT_REPORT_NAME = PropertiesHelpers.getValue("EXTENT_REPORT_NAME");
    public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
    public static final String EXTENT_REPORT_FOLDER = PropertiesHelpers.getValue("EXTENT_REPORT_FOLDER");
    public static final String PROJECT_PATH = SystemHelpers.getCurrentDir();
    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + EXTENT_REPORT_FOLDER;
    public static String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;
    public static final String REPORT_TITLE = PropertiesHelpers.getValue("REPORT_TITLE");
    public static final String AUTHOR = PropertiesHelpers.getValue("AUTHOR");
    public static final String OPEN_REPORTS_AFTER_EXECUTION = PropertiesHelpers.getValue("OPEN_REPORTS_AFTER_EXECUTION");


    public static final String SCREENSHOT_SKIPPED_TCS = PropertiesHelpers.getValue("SCREENSHOT_SKIPPED_TCS");
    public static final String OVERRIDE_REPORTS = PropertiesHelpers.getValue("OVERRIDE_REPORTS");
    public static final String VIDEO_RECORD = PropertiesHelpers.getValue("VIDEO_RECORD");
    public static final String SCREENSHOT_PASSED_TCS = PropertiesHelpers.getValue("SCREENSHOT_PASSED_TCS");
    public static final String SCREENSHOT_FAILED_TCS = PropertiesHelpers.getValue("SCREENSHOT_FAILED_TCS");
    public static final String EXPORT_VIDEO_PATH = PropertiesHelpers.getValue("EXPORT_VIDEO_PATH");
    public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");
    public static final String URL_CRM = PropertiesHelpers.getValue("URL_CRM");
    public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");
    public static final String EXCEL_DATA_FILE_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_PATH");
    public static final Integer WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelpers.getValue("WAIT_SLEEP_STEP"));
    public static final Integer WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelpers.getValue("WAIT_PAGE_LOADED"));
    public static final String ACTIVE_PAGE_LOADED = PropertiesHelpers.getValue("ACTIVE_PAGE_LOADED");
    public static final Integer WAIT_EXPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_EXPLICIT"));
    public static final String EXPORT_CAPTURE_PATH = PropertiesHelpers.getValue("EXPORT_CAPTURE_PATH");
}
