package com.orangehrmlive.projects.cms.pages;

import com.orangehrmlive.projects.cms.pages.SignIn.SignInPageCMS;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserSearch.UserSearchCMSPage;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.openqa.selenium.By;
import static com.orangehrmlive.keywords.WebUI.*;
public class CommonPageCRM {
    private SignInPageCMS signInPageCMS;
    private UserSearchCMSPage userSearchCMSPage;
    private DashBoardPageCRM dashBoardPage;
    private By menuAdmin = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    public DashBoardPageCRM getDashBoardPage(){
    if(dashBoardPage==null){
        dashBoardPage = new DashBoardPageCRM();
    }
    return dashBoardPage;
}
    public void clickMenuAdmin(){
        clickElement(menuAdmin);
    }
    public UserSearchCMSPage getUserSearchPage() {
        if (userSearchCMSPage == null) {
            userSearchCMSPage = new UserSearchCMSPage();
        }
        return userSearchCMSPage;
    }

}
