package com.orangehrmlive.projects.cms.testcases;

import com.orangehrmlive.common.BaseTest;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.dataprovider.DataProviderDeleteUser;
import com.orangehrmlive.dataprovider.DataProviderEditUser;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserAdd.UserAddPageCMS;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DeleteuserTest extends BaseTest {
    private SignInTest signInTest;



    @Test(dataProvider = "data_provider_delete_user", dataProviderClass = DataProviderDeleteUser.class)
    public void deleteUser(Hashtable<String, String> data){

        signInTest = new SignInTest();
        signInTest.signInWithAdminRole();
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_CMS_DATA, "DeleteUser");
        getUserDeletePage().DeleteUser(data.get("username"));


    }



}
