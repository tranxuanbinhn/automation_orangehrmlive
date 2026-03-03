package com.orangehrmlive.projects.crm.pages;

import com.orangehrmlive.projects.crm.pages.SignIn.SignInPageCRM;

public class CommonPageCRM {
    private SignInPageCRM signInPageCRM;
    private DashBoardPageCRM dashBoardPage;

public DashBoardPageCRM getDashBoardPage(){
    if(dashBoardPage==null){
        dashBoardPage = new DashBoardPageCRM();
    }
    return dashBoardPage;
}
}
