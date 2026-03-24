package com.orangehrmlive.projects.cms.pages.UserManagement.UserSearch;

import com.orangehrmlive.projects.cms.pages.CommonPageCRM;
import org.openqa.selenium.By;
import static com.orangehrmlive.keywords.WebUI.*;

public class UserSearchCMSPage extends CommonPageCRM {
    private By inputUsername = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By buttonSearch = By.xpath("//button(@normalize-space='Search')");
    private By cellUsername = By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-paper-container']/div[@class='orangehrm-container']/div[@role='table']/div[@role='rowgroup']/div[@class='oxd-table-card']/div[@role='row']/div[1]");
    private By tableUser = By.xpath("//div[@class='oxd-table-card'][1]");
    public UserSearchCMSPage searchByUserName(String username){
        clickMenuAdmin();
        setText(inputUsername,username);
        clickElement(buttonSearch);
        waitForElementPresent(tableUser);
        verifyEquals(username, getText(cellUsername),"No Result Search");
        return new UserSearchCMSPage();
    }

}
