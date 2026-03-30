package com.orangehrmlive.projects.cms.testcases;

import com.orangehrmlive.common.BaseTest;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.dataprovider.DataProviderSearchUser;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.projects.cms.pages.SignIn.SignInPageCMS;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class SearchuserTest extends BaseTest {
    private SignInPageCMS signInPageCMS;

    @Test(dataProvider = "data_provider_search_user", dataProviderClass = DataProviderSearchUser.class)
    public void searchUser(Hashtable<String, String> data){
        signInPageCMS = new SignInPageCMS();
        signInPageCMS.signInWithAdminRole();
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_CMS_DATA, "SearchUser");
        getUserSearchPage().searchByUserName(data.get("username"));


    }

}
