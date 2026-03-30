package com.orangehrmlive.projects.cms.pages;

import org.openqa.selenium.By;

public class DashBoardPageCRM extends CommonPageCRM {
    private By menuDashboard = By.xpath("//nav[@aria-label='Sidepanel']");
    public String pageUrl = "/dashboard/index";

    public By getMenuDashboard() {
        return menuDashboard;
    }
}
