package com.orangehrmlive.projects.crm.testcases;

import com.orangehrmlive.common.BaseTest;
import com.orangehrmlive.projects.crm.pages.DashBoardPageCRM;
import com.orangehrmlive.projects.crm.pages.SignIn.SignInPageCRM;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {
    SignInPageCRM signInPageCRM;
    DashBoardPageCRM dashBoardPageCRM;

    public SignInTest() {
        signInPageCRM = new SignInPageCRM();
    }

    @Test
    public void signInWithAdminRole(){
    dashBoardPageCRM = signInPageCRM.signInWithAdminRole();

    }
}
