package com.orangehrmlive.helpers;

import com.aventstack.extentreports.model.ScreenCapture;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.utils.LogUtils;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CaptureHelpers extends ScreenRecorder {
    private static ScreenRecorder screenRecorder;
    private static String name;
    private static SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    public CaptureHelpers(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder,String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    public static void captureScreenshot(WebDriver webDriver, String screenName){
        try{
            String path = SystemHelpers.getCurrentDir()+ FrameworkConstants.EXPORT_CAPTURE_PATH;
            File file = new File(path);
            if(!file.exists()){
                LogUtils.info("Path is not exist "+path);
                file.mkdir();
                LogUtils.info("Fodel is created "+file);
            }
            LogUtils.info("Driver for capture is "+webDriver);
            TakesScreenshot ts = (TakesScreenshot) webDriver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File(path+"/"+screenName+"_"+dateFormat.format(new Date())+".png"));
            LogUtils.info("Screenshot taken: " + screenName);
            LogUtils.info("Screenshot taken current URL: " + webDriver.getCurrentUrl());

        }catch (Exception e){
            System.out.println("Some thing wrong with capture "+ e.getMessage());
        }
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if(!movieFolder.exists()){
            movieFolder.mkdir();
        }
        else if(!movieFolder.isDirectory()){
            throw new IOException(movieFolder + " is not a directory.");
        }
        return new File(movieFolder, name + "_" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }
}
