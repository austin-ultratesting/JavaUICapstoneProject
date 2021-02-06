package com.ultranauts.javaui;

import com.ultranauts.javapage.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //*********Web Elements*********
    By logoID = By.id("logo");
    
    public void navigateToHome(){
        click(logoID);
    }
}
