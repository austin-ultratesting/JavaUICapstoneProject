package com.ultranauts.javaui;

import com.ultranauts.javapage.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompletePage extends BasePage{

	public AutoCompletePage(WebDriver driver, WebDriverWait driverwait) {
        super(driver, driverwait);
    }
    
    //*********Web Elements*********
    By addressTextField = By.id("autocomplete");
    By streetAddressTextField = By.id("street_number");
    By streetAddress2TextField = By.id("route");

    public AutoCompletePage clickAddressTextField(){
        click(addressTextField);
        return this;
    }

    public AutoCompletePage clickStreetAddressTextField(){
        click(streetAddressTextField);
        return this;
    }

    public AutoCompletePage switchToStreetAddressTextField(){
        sendTabKey(addressTextField);
        return this;
    }

    public AutoCompletePage clickStreetAddress2TextField(){
        click(streetAddress2TextField);
        return this;
    }

    public AutoCompletePage switchToStreetAddress2TextField(){
        sendTabKey(streetAddressTextField);
        return this;
    }
    
    public AutoCompletePage enterAddress(String address){
        writeText(addressTextField,address);
        return this;
    }

    public AutoCompletePage enterStreetAddress(String streetAddress) {
        writeText(streetAddressTextField,streetAddress);
        return this;
    }

    public AutoCompletePage enterStreetAddress2(String streetAddress2) {
        writeText(streetAddress2TextField,streetAddress2);
        return this;
    }
}
