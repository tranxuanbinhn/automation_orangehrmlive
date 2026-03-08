package com.orangehrmlive.projects.crm.pages;

import org.openqa.selenium.By;

public class DashBoardPageCRM extends CommonPageCRM {
    private By menuDashboard = By.xpath("//nav[@aria-label='Sidepanel']");
    public String pageUrl = "/viewAssignClaim";

    public By getMenuDashboard() {
        return menuDashboard;
    }
}
