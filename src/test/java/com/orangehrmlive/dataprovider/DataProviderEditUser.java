package com.orangehrmlive.dataprovider;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderEditUser {
    @DataProvider(name = "data_provider_edit_user")
    public Object[][] getDataEditUser(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        return excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir()+ FrameworkConstants.EXCEL_CMS_DATA,"EditUser",1,1);
    }

}
