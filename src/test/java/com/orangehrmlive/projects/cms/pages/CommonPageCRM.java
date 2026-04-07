package com.orangehrmlive.projects.cms.pages;

import com.orangehrmlive.projects.cms.pages.SignIn.SignInPageCMS;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserAdd.UserAddPageCMS;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserEdit.UserEditPageCMS;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserSearch.UserSearchCMSPage;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.openqa.selenium.By;
import static com.orangehrmlive.keywords.WebUI.*;
public class CommonPageCRM {
    private SignInPageCMS signInPageCMS;
    private UserSearchCMSPage userSearchCMSPage;
    private UserAddPageCMS userAddPageCMS;
    private UserEditPageCMS userEditPageCMS;

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

    public UserAddPageCMS getUserAddPage(){
        if(userAddPageCMS == null){
            userAddPageCMS = new UserAddPageCMS();
        }

        return userAddPageCMS;
    }
    public UserEditPageCMS getUserEditPage(){
        if(userEditPageCMS == null){
            userEditPageCMS = new UserEditPageCMS();
        }

        return userEditPageCMS;
    }

}
