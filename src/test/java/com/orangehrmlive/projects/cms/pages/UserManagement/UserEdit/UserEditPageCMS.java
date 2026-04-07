package com.orangehrmlive.projects.cms.pages.UserManagement.UserEdit;

import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserManagementPageCMS;
import org.openqa.selenium.By;

import static com.orangehrmlive.keywords.WebUI.*;
import static com.orangehrmlive.keywords.WebUI.getText;
import static com.orangehrmlive.keywords.WebUI.verifyEquals;

public class UserEditPageCMS extends CommonPageCRM {
    private By buttonEdit = By.xpath("//div[@class='orangehrm-paper-container']//button[2]");
    private By inputUsername = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By buttonSearch = By.xpath("//button[normalize-space()='Search']");
    private By cellUsername = By.xpath("//div[@role='row']//div[@role='cell'][2]");
    private By tableUser = By.xpath("//div[@class='oxd-table-card'][1]");
    private By titleEditUser = By.xpath("//h6[contains(@class, 'orangehrm-main-title') and contains(normalize-space(),'Edit User')]");
    private By selectUserRoleClick = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private By selectRoleAdmin = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='Admin']");
    private By selectRoleESS = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='ESS']");
    private By selectChosenRole = By.xpath("//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private By cellRole = By.xpath("//div[@role='row']//div[@role='cell'][3]");
    private By buttonSave = By.xpath("//button[@type='submit' and normalize-space()='Save']");


    public UserManagementPageCMS editRoleUser(String username, String role){
        searchUserByUsername(username);
        verifyEquals(username, getText(cellUsername),"No Result Search");
        clickElement(buttonEdit);
        waitForElementPresent(titleEditUser);
        String textRoleChosen = getText(selectChosenRole);
        if(textRoleChosen.equals("Admin") && Long.parseLong(role)==1){
            return new UserManagementPageCMS();
        }
        else if(textRoleChosen.equals("ESS") && Long.parseLong(role)!=1){
            return new UserManagementPageCMS();
        }
        clickElement(selectUserRoleClick);

        if (Long.parseLong(role) ==1){
            clickElement(selectRoleAdmin);
        }
        else{
            clickElement(selectRoleESS);
        }
        String roleStr = "";
        if(Long.parseLong(role)==1){
            roleStr="Admin";
        }
        else {
            roleStr = "ESS";
        }

        clickElement(buttonSave);
        //Verify edit success
        searchUserByUsername(username);
        verifyEquals(username, getText(cellUsername),"No Result Search");
        verifyEquals(roleStr, getText(cellRole),"No Result Search");

        return new UserManagementPageCMS();

    }
    public void searchUserByUsername(String username){
        clickMenuAdmin();

        setText(inputUsername,username);
        clickElement(buttonSearch);
        waitForElementPresent(tableUser);


    }

}
