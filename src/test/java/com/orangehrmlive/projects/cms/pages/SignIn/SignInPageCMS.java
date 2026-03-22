package com.orangehrmlive.projects.cms.pages.SignIn;

import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.ExcelHelpers;
import com.orangehrmlive.projects.cms.models.SignInModel;
import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import com.orangehrmlive.projects.cms.pages.DashBoardPageCRM;
import com.orangehrmlive.utils.DecodeUtils;
import org.openqa.selenium.By;

import static com.orangehrmlive.keywords.WebUI.*;

public class SignInPageCMS extends CommonPageCRM {
    private String pageURL = "/auth/login";
    private By inputUsername = By.xpath("//input[@placeholder='Username']");
    private By inputPassword = By.xpath("//input[@placeholder='Password']");
    private By buttonSign = By.xpath("//button[normalize-space()='Login']");

    public SignInPageCMS() {
    }

    public DashBoardPageCRM signInWithAdminRole() {

        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        openWebsite(FrameworkConstants.URL_CRM);
        verifyContains(getCurrentUrl(), pageURL, "The url of signin page not match");
        clearText(inputUsername);
        clearText(inputPassword);
        setText(inputUsername, excelHelpers.getCellData(1, SignInModel.getUsername()));
        setText(inputPassword, DecodeUtils.decrypt(excelHelpers.getCellData(1, SignInModel.getPassword())));
        clickElement(buttonSign);
        DashBoardPageCRM dashBoardPageCRM = new DashBoardPageCRM();
        waitForElementVisible(dashBoardPageCRM.getMenuDashboard());
        verifyContains(getCurrentUrl(), getDashBoardPage().pageUrl, "Sign in failed. Can not redirect to Dashboard page.");

        return dashBoardPageCRM;
    }

}
