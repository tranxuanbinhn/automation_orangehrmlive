package com.orangehrmlive.projects.crm.pages.SignIn;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.projects.crm.pages.DashBoardPageCRM;
import org.openqa.selenium.By;
import static com.orangehrmlive.keywords.WebUI.*;

public class SignInPageCRM {
    private String pageURL = "/auth/login";
    private By inputUsername = By.xpath("//input[@placeholder='Username']");
    private By inputPassword = By.xpath("//input[@placeholder='Password']");
    private By buttonSign = By.xpath("//button[normalize-space()='Login']");

    public SignInPageCRM(){}

         DashBoardPageCRM signInWithAdminRole(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        openWebsite(FrameworkConstants.URL_CRM);

        return new DashBoardPageCRM();
    }

}
