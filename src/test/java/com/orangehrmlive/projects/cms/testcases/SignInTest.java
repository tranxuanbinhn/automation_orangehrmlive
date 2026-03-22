package com.orangehrmlive.projects.cms.testcases;

import com.orangehrmlive.common.BaseTest;
import com.orangehrmlive.projects.cms.pages.DashBoardPageCRM;
import com.orangehrmlive.projects.cms.pages.SignIn.SignInPageCMS;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {
    SignInPageCMS signInPageCMS;
    DashBoardPageCRM dashBoardPageCRM;

    public SignInTest() {
        signInPageCMS = new SignInPageCMS();
    }

    @Test
    public void signInWithAdminRole(){
    dashBoardPageCRM = signInPageCMS.signInWithAdminRole();

    }
}
