package com.orangehrmlive.constants;

import com.orangehrmlive.helpers.PropertiesHelpers;

import java.io.IOException;

public final class FrameworkConstants {
    private FrameworkConstants(){

    }

    static {
        PropertiesHelpers.loadAllFiles();
    }

    public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");;
    public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");
    public static final String EXCEL_DATA_FILE_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_PATH");


}
