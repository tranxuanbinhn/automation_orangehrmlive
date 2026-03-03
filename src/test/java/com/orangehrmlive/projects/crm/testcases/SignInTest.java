package com.orangehrmlive.projects.crm.testcases;

import com.orangehrmlive.projects.crm.pages.DashBoardPageCRM;
import com.orangehrmlive.projects.crm.pages.SignIn.SignInPageCRM;
import org.testng.annotations.Test;

public class SignInTest {
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
