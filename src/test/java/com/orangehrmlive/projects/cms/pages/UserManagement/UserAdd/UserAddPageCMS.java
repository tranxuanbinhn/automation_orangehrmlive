package com.orangehrmlive.projects.cms.pages.UserManagement.UserAdd;
import static com.orangehrmlive.keywords.WebUI.*;
import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import com.orangehrmlive.projects.cms.pages.UserManagement.UserManagementPageCMS;
import org.openqa.selenium.By;

public class UserAddPageCMS extends CommonPageCRM {
    private UserManagementPageCMS userManagementPageCMS;
    private By selectUserRoleClick = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private By inputEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By selectUserStatusClick = By.xpath("(//div[contains(text(),'-- Select --')])[1]");
    private By inputUsername = By.xpath("//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By inputPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private By inputConfirmPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private By buttonSubmit = By.xpath("//button[@type='submit']");
    private By selectStatusDisabled = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='Disabled']");
    private By selectStatusEnabled = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='Enabled']");
    private By selectRoleAdmin = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='Admin']");
    private By selectRoleESS = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='ESS']");
    private By dropdownEmployeeName = By.xpath("//div[@class='oxd-autocomplete-dropdown'][@role='listbox']");
    private By  optionEmployeeName = By.xpath("(//div[@class='oxd-autocomplete-option'][@role='option'])[1]");

    public UserManagementPageCMS addNewUser(Long role, String EmployeeName, Long status, String username, String password, String conpassword){
        clickMenuAdmin();
        userManagementPageCMS.clickButtonAddUser();
        clickElement(selectUserRoleClick);
        if (status ==1){
            clickElement(selectRoleAdmin);
        }
        else{
            clickElement(selectRoleESS);
        }
        clickElement(selectUserStatusClick);
        if (status ==1){
            clickElement(selectStatusEnabled);
        }
        else{
            clickElement(selectStatusDisabled);
        }
        setText(inputEmployeeName, EmployeeName);
        waitForElementPresent(dropdownEmployeeName);
        clickElement(optionEmployeeName);
        setText(inputUsername,username);
        setText(inputPassword,password);
        setText(inputConfirmPassword,conpassword);
        clickElement(buttonSubmit);
        waitForElementPresent(UserManagementPageCMS.getUserManagement());
        verifyContains(getCurrentUrl(),UserManagementPageCMS.getUrl(),"Sign in failed. Can not redirect to Dashboard User Management");
        return new UserManagementPageCMS();
    }
    public void verifyNewProduct(Long role, String EmployeeName, Long status, String username, String password, String conpassword){
        clickMenuAdmin();
        userManagementPageCMS.clickButtonAddUser();
        clickElement(selectUserRoleClick);
        if (status ==1){
            clickElement(selectRoleAdmin);
        }
        else{
            clickElement(selectRoleESS);
        }
        clickElement(selectUserStatusClick);
        if (status ==1){
            clickElement(selectStatusEnabled);
        }
        else{
            clickElement(selectStatusDisabled);
        }
        setText(inputEmployeeName, EmployeeName);
        waitForElementPresent(dropdownEmployeeName);
        clickElement(optionEmployeeName);
        setText(inputUsername,username);
        setText(inputPassword,password);
        setText(inputConfirmPassword,conpassword);
        clickElement(buttonSubmit);
        waitForElementPresent(UserManagementPageCMS.getUserManagement());
        verifyContains(getCurrentUrl(),UserManagementPageCMS.getUrl(),"Sign in failed. Can not redirect to Dashboard User Management");

    }
}
