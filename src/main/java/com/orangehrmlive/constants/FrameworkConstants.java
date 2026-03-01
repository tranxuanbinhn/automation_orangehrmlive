package com.orangehrmlive.constants;

import com.orangehrmlive.helpers.PropertiesHelpers;

import java.io.IOException;

public final class FrameworkConstants {
    private FrameworkConstants(){

    }

    static {
        PropertiesHelpers.loadAllFiles();
    }

    public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");
    public static final String URL_CRM = PropertiesHelpers.getValue("URL_CRM");
    public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");
    public static final String EXCEL_DATA_FILE_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_PATH");
    public static final Integer WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelpers.getValue("WAIT_SLEEP_STEP"));
    public static final Integer WAIT_PAGE_LOAD = Integer.parseInt(PropertiesHelpers.getValue("WAIT_PAGE_LOAD"));
    public static final String ACTIVE_PAGE_LOADED = PropertiesHelpers.getValue("ACTIVE_PAGE_LOADED");
}
