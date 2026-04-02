package com.orangehrmlive.projects.cms.testcases;

import com.orangehrmlive.common.BaseTest;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.dataprovider.DataProviderAddUser;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserAdd.UserAddPageCMS;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AdduserTest extends BaseTest {
    private SignInTest signInTest;
    private UserAddPageCMS userAddPageCMS;


    @Test(dataProvider = "data_provider_add_user", dataProviderClass = DataProviderAddUser.class)
    public void addUser(Hashtable<String, String> data){

        signInTest = new SignInTest();
        signInTest.signInWithAdminRole();
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_CMS_DATA, "AddUser");
        getUserAddPage().addNewUser(data.get("role"), data.get("employeeName"),data.get("status"), data.get("username"),
                data.get("password"), data.get("conpassword"));


    }



}
