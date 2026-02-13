package com.orangehrmlive.constants;

import com.orangehrmlive.helpers.PropertiesHelpers;

import java.io.IOException;

public class FrameworkConstants {
    private FrameworkConstants(){

    }

    static {
        PropertiesHelpers.loadAllFile();
    }

    public static final String HEADLESS;

    static {
        try {
            HEADLESS = PropertiesHelpers.getValue("HEADLESS");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
