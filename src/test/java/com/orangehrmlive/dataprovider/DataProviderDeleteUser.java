package com.orangehrmlive.dataprovider;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderDeleteUser {
    @DataProvider(name = "data_provider_delete_user")
    public Object[][] getDataDeleteUser(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        return excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir()+ FrameworkConstants.EXCEL_CMS_DATA,"DeleteUser",1,3);
    }

}
