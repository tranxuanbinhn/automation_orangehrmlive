package com.orangehrmlive.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters("BROWSER")
    @BeforeClass
    public void createDriver(@Optional("chrome") String browser){
        WebDriver webDriver;
        switch (browser)
        {
            case "chrome":
            {
                webDriver = new ChromeDriver();

            }
        }
    }
}
