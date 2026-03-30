package com.orangehrmlive.projects.cms.pages.UserManagement.UserSearch;

import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserManagementPageCMS;
import com.orangehrmlive.utils.LogUtils;
import org.openqa.selenium.By;
import static com.orangehrmlive.keywords.WebUI.*;

public class UserSearchCMSPage extends CommonPageCRM {
    private By inputUsername = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By buttonSearch = By.xpath("//button[normalize-space()='Search']");
    private By cellUsername = By.xpath("//div[@role='row']//div[@role='cell'][2]");
    private By tableUser = By.xpath("//div[@class='oxd-table-card'][1]");
    public UserManagementPageCMS searchByUserName(String username){
        clickMenuAdmin();
        LogUtils.info("Driver after click menu admin"+ DriverManager.getDriver());
        setText(inputUsername,username);
        LogUtils.info("Driver after set tex, username"+ DriverManager.getDriver() +" "+ username);

        clickElement(buttonSearch);
        LogUtils.info("Driver after click search"+ DriverManager.getDriver());

        waitForElementPresent(tableUser);
        LogUtils.info("Driver after waitfor"+ DriverManager.getDriver());

        verifyEquals(username, getText(cellUsername),"No Result Search");
        LogUtils.info("Driver after verify"+ DriverManager.getDriver());

        return new UserManagementPageCMS();
    }

}
