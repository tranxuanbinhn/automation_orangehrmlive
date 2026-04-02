package com.orangehrmlive.projects.cms.pages.UserManagement;
import static com.orangehrmlive.keywords.WebUI.*;
import org.openqa.selenium.By;

public class UserManagementPageCMS {
    private final By buttonAddUser = By.xpath("//button[normalize-space()='Add']");
    private static By userManagement = By.xpath("//h6[normalize-space()='Management']");
    private static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
    public UserManagementPageCMS(){

    }
    public static By getUserManagement(){
        return userManagement;
    }

    public static String getUrl() {
        return url;
    }

    public void clickButtonAddUser(){
        clickElement(buttonAddUser);
    }
}
