package com.orangehrmlive.listeners;

import com.orangehrmlive.helpers.PropertiesHelpers;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {
    @Override
    public void onStart(ISuite iSuite) {
        PropertiesHelpers.loadAllFiles();
    }


}
