package com.orangehrmlive.helpers;

import java.io.File;
import java.util.Properties;

public final class SystemHelpers {
    public static String getCurrentDir(){
        return System.getProperty("user.dir") + File.separator;
    }
}
