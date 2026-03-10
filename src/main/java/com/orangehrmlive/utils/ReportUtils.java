package com.orangehrmlive.utils;

import java.io.File;
import static com.orangehrmlive.constants.FrameworkConstants.*;
public class ReportUtils {
    private ReportUtils() {

    }
    public static String createExtentReportPath() {
        String link = "";
        if (OVERRIDE_REPORTS.trim().equals(NO)) {
            System.out.println("OVERRIDE_REPORTS = " + OVERRIDE_REPORTS);
            link = EXTENT_REPORT_FOLDER_PATH + File.separator + DateUtils.getCurrentDate() + "_"
                    + EXTENT_REPORT_FILE_NAME;
            System.out.println("Created link reports: " + link);
            return link;
        } else {
            System.out.println("OVERRIDE_REPORTS = " + OVERRIDE_REPORTS);
            link = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;
            System.out.println("Created link reports: " + link);
            return link;
        }
    }


}
