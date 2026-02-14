package com.orangehrmlive.helpers;

import com.orangehrmlive.utils.LanguageUtils;
import com.orangehrmlive.utils.LogUtils;
import lombok.Getter;

import java.io.FileInputStream;
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
    private static String relPropertiesFilePathDefault = "src/test/resources/config/config.properties";

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
    public static String getValue(String key) {
        String keyvalue = null;
     try {
         if (file == null && properties == null) {
             properties = new Properties();
             linkFile = SystemHelpers.getCurrentUrl() + relPropertiesFilePathDefault;
             file = new FileInputStream(linkFile);
             properties.load(file);
             file.close();
         }
        keyvalue = properties.getProperty(key);
         return LanguageUtils.convertCharset_ISO_8859_1_To_UTF8(keyvalue);
     } catch(Exception e){
         System.out.println(e.getMessage());
         return keyvalue;
        }

    }



}
