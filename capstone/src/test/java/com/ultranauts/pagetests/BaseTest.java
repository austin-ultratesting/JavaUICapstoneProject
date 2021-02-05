package com.ultranauts.pagetests;

import com.ultranauts.javapage.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Page page;

    @BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.

        WebDriverManager.chromedriver().setup();
        
        driver = new ChromeDriver();
 
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,20);
 
        //Maximize Window
        driver.manage().window().maximize();
 
        //Instantiate the Page Class
        page = new Page(driver,wait);
    }
    
    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}