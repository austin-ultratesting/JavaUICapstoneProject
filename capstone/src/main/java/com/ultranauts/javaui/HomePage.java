package com.ultranauts.javaui;

import com.ultranauts.javapage.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class HomePage extends BasePage {
 
    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait driverwait) {
        super(driver, driverwait);
    }

    //*********Page Variables*********
    String baseURL = "https://formy-project.herokuapp.com/";

    //*********Web Elements*********
    By logoID = By.id("logo");
    By autoComplete = By.xpath("//a[contains(@href,'/autocomplete') and contains(@class,'btn btn-lg')]");
    By buttons = By.xpath("//a[contains(@href,'/buttons') and contains(@class,'btn btn-lg')]");
    By checkBox = By.xpath("//a[contains(@href,'/checkbox') and contains(@class,'btn btn-lg')]");

    public void navigateToHome(){
        click(logoID);
    }

    public HomePage navigateBack(){
        driver.navigate().back();
        return this;
    }

    public HomePage clickAutoComplete(){
        click(autoComplete);
        return this;
    }

    public AutoCompletePage gotoAutoComplete(){
        click(autoComplete);
        return new AutoCompletePage(driver,driverwait);
    }

    public HomePage clickButtons(){
        click(buttons);
        return this;
    }

    public HomePage clickCheckBox(){
        click(checkBox);
        return this;
    }

    public HomePage goToFormyProject() {
        driver.get(baseURL);
        return this;
    }
}