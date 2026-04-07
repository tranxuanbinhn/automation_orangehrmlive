package com.orangehrmlive.projects.cms.pages.UserManagement.UserDelete;

import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserManagementPageCMS;
import org.openqa.selenium.By;

import static com.orangehrmlive.keywords.WebUI.*;

public class UserDeletePageCMS extends CommonPageCRM {
    private By buttonDelete = By.xpath("//div[@class='orangehrm-paper-container']//button[1]");
    private By inputUsername = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By buttonSearch = By.xpath("//button[normalize-space()='Search']");
    private By cellUsername = By.xpath("//div[@role='row']//div[@role='cell'][2]");
    private By tableUser = By.xpath("//div[@class='oxd-table-card'][1]");
    private By dialogAlert = By.xpath("//div[@class='oxd-dialog-container-default--inner']");
    private By buttonConfirmDelete = By.xpath("//div[@class='oxd-dialog-container-default--inner']//button[normalize-space()='Yes, Delete']");
    private By alertNoSearch = By.xpath("//span[normalize-space()='No Records Found']");

    public UserManagementPageCMS DeleteUser(String username){
        searchUserByUsername(username);
        verifyEquals(username, getText(cellUsername),"No Result Search");
        clickElement(buttonDelete);

        waitForElementPresent(dialogAlert);



        clickElement(buttonConfirmDelete);
        //Verify edit success
        searchUserByUsername(username);
        verifyContains("No Records Found", getText(alertNoSearch), "Test fail");

        return new UserManagementPageCMS();

    }
    public void searchUserByUsername(String username){
        clickMenuAdmin();

        setText(inputUsername,username);
        clickElement(buttonSearch);
        waitForElementPresent(tableUser);


    }

}
