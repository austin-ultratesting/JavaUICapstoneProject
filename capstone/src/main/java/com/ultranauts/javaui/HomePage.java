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
    private String homePageURL = "https://formy-project.herokuapp.com/";

    //*********Web Elements*********
    private By logoID = By.id("logo");
    private By autoComplete = By.xpath("//a[contains(@href,'/autocomplete') and contains(@class,'btn btn-lg')]");
    private By buttons = By.xpath("//a[contains(@href,'/buttons') and contains(@class,'btn btn-lg')]");
    private By checkBox = By.xpath("//a[contains(@href,'/checkbox') and contains(@class,'btn btn-lg')]");

    public String getHomePageURL() {
        return this.homePageURL;
    }

    public void setHomePageURL(String baseURL) {
        this.homePageURL = baseURL;
    }

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
        return new AutoCompletePage(driver,wait);
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
        driver.get(homePageURL);
        return this;
    }
}