package com.orangehrmlive.constants;

import com.orangehrmlive.helpers.PropertiesHelpers;

import java.io.IOException;

public final class FrameworkConstants {
    private FrameworkConstants(){

    }

    static {
        PropertiesHelpers.loadAllFile();
    }

    public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");;
    public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");



}
