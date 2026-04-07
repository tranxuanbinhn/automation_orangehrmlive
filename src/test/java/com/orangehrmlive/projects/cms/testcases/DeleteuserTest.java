package com.orangehrmlive.projects.cms.testcases;

import com.orangehrmlive.common.BaseTest;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.dataprovider.DataProviderEditUser;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserAdd.UserAddPageCMS;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DeleteuserTest extends BaseTest {
    private SignInTest signInTest;
    private UserAddPageCMS userAddPageCMS;


    @Test(dataProvider = "data_provider_delete_user", dataProviderClass = DataProviderEditUser.class)
    public void editUser(Hashtable<String, String> data){

        signInTest = new SignInTest();
        signInTest.signInWithAdminRole();
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_CMS_DATA, "DeleteUser");
        getUserEditPage().editRoleUser(data.get("username"), data.get("role"));


    }



}
