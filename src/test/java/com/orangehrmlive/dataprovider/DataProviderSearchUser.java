package com.orangehrmlive.dataprovider;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderSearchUser {
    @DataProvider(name = "data_provider_search_user")
    public Object[][] getDataSearchUser(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        return excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir()+ FrameworkConstants.EXCEL_CMS_DATA,"SearchUser",2,5);

    }
}
