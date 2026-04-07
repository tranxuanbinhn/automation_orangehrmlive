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

        setText(inputUsername,username);


        clickElement(buttonSearch);


        waitForElementPresent(tableUser);


        verifyEquals(username, getText(cellUsername),"No Result Search");


        return new UserManagementPageCMS();
    }

}
