package com.orangehrmlive.dataprovider;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderAddUser {

    @DataProvider(name = "data_provider_add_user")
    public Object[][] getDataAddUser(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
       return excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir()+ FrameworkConstants.EXCEL_CMS_DATA,"AddUser",2,5);
    }
}
