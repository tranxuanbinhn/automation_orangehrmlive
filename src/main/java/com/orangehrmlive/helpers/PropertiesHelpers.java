package com.orangehrmlive.helpers;

import com.orangehrmlive.utils.LogUtils;
import lombok.Getter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelpers {
    @Getter
    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream out;

    public static Properties loadAllFile(){
        LinkedList<String> files = new LinkedList<>();
        files.add("src/test/resources/config/data.properties");
        try{
            properties = new Properties();
            for (String f:files){
                Properties temProp = new Properties();
                linkFile =SystemHelpers.getCurrentUrl() + f;
                file = new FileInputStream(linkFile);
                temProp.load(file);
            properties.putAll(temProp);
            }
            file.close();
            LogUtils.infor("Put all file properties");
            return  properties;
        }
       catch (IOException e) {
           LogUtils.infor("Warning !! Can not Load All File.");
           return new Properties();
        }
    }

}
