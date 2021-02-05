package com.ultranauts.javaui;

import org.openqa.selenium.WebDriver;

public abstract class WebPage
{
    private WebDriver driver;
 
    protected WebPage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
}