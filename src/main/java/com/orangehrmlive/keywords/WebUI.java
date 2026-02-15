package com.orangehrmlive.keywords;

import org.testng.asserts.SoftAssert;

public class WebUI {
    private static SoftAssert softAssert = new SoftAssert();
    public static void stopSoftAssertAll() {

        softAssert.assertAll();
    }

}
