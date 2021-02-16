package com.ultranauts.javaui;

import com.ultranauts.javapage.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalPage extends BasePage {

    public ModalPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    private By logoID = By.id("logo");
    private By modalButtonID = By.id("modal-button");
    private By okButtonID = By.id("ok-button");
    private By closeButtonID = By.id("close-button");
    private By xButtonID = By.cssSelector("[aria-hidden=true]");
    
    public void navigateToHome(){
        click(logoID);
    }

    public ModalPage clickModalButton(){
        click(modalButtonID);
        return this;
    }

    public ModalPage clickOkButton(){
        click(okButtonID);
        return this;
    }

    public ModalPage clickCloseButton(){
        click(closeButtonID);
        return this;
    }

    public ModalPage clickXButton(){
        click(xButtonID);
        return this;
    }
}
