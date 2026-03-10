package com.orangehrmlive.dataprovider;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.helpers.PropertiesHelpers;
import com.orangehrmlive.helpers.SystemHelpers;
import com.orangehrmlive.projects.crm.models.SignInModel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public final class DataProviderManager {
    private DataProviderManager() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @Test(dataProvider = "getSignInDataHashTable")
    public void testGetSignInData(Hashtable<String, String> data) {
        System.out.println("signInData.testCaseName = " + data.get(SignInModel.getTestCaseName()));
        System.out.println("signInData.username = " + data.get(SignInModel.getEmail()));
        System.out.println("signInData.password = " + data.get(SignInModel.getPassword()));
        System.out.println("signInData.expectedTitle = " + data.get(SignInModel.getExpectedTitle()));
        System.out.println("signInData.expectedError = " + data.get(SignInModel.getExpectedError()));

    }

    @DataProvider(name = "getSignInDataHashTable")
    public static Object[][] getSignInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object data[][] = excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn", 1, 2);
        return data;
    }
}
