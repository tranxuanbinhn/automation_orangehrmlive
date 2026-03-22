package com.orangehrmlive.projects.cms.pages.UserManagement;

import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import org.openqa.selenium.By;

public class UserManagementCMS extends CommonPageCRM {
    private By selectUserRoleClick = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private By inputElementName = By.xpath("//input[@placeholder='Type for hints...']");
    private By selectUserStatusClick = By.xpath("(//div[contains(text(),'-- Select --')])[1]");
    private By inputUsername = By.xpath("//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By inputPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private By inputConfirmPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private By buttonSubmit = By.xpath("//button[@type='submit']");
    private By selectStatusDisabled = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='Disabled']");
    private By selectStatusEnabled = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='Enabled']");
    private By selectRoleAdmin = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='Admin']");
    private By selectRoleESS = By.xpath("//div[contains(@class,'oxd-select-option')][.//text()='ESS']");

}
