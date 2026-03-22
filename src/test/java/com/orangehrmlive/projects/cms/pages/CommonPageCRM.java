package com.orangehrmlive.projects.cms.pages;

import com.orangehrmlive.projects.cms.pages.SignIn.SignInPageCMS;

public class CommonPageCRM {
    private SignInPageCMS signInPageCMS;
    private DashBoardPageCRM dashBoardPage;

public DashBoardPageCRM getDashBoardPage(){
    if(dashBoardPage==null){
        dashBoardPage = new DashBoardPageCRM();
    }
    return dashBoardPage;
}
}
