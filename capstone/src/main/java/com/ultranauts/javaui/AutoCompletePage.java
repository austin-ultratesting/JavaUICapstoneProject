package com.ultranauts.javaui;

import com.ultranauts.javapage.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompletePage extends BasePage{

	public AutoCompletePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //*********Web Elements*********
    private By logoID = By.id("logo");
    private By addressTextField = By.id("autocomplete");
    private By streetAddressTextField = By.id("street_number");
    private By streetAddress2TextField = By.id("route");
    private By cityTextField = By.id("locality");
    private By stateTextField = By.id("administrative_area_level_1");
    private By zipCodeTextField = By.id("postal_code");
    private By countryTextField = By.id("country");

    public void navigateToHome(){
        click(logoID);
    }

    public AutoCompletePage clickAddressTextField(){
        click(addressTextField);
        return this;
    }

    public AutoCompletePage clickStreetAddressTextField(){
        click(streetAddressTextField);
        return this;
    }

    public AutoCompletePage clickStreetAddress2TextField(){
        click(streetAddress2TextField);
        return this;
    }

    public AutoCompletePage clickCityTextField(){
        click(cityTextField);
        return this;
    }

    public AutoCompletePage clickStateTextField(){
        click(stateTextField);
        return this;
    }

    public AutoCompletePage clickZipCodeTextField(){
        click(zipCodeTextField);
        return this;
    }

    public AutoCompletePage clickCountryTextField(){
        click(countryTextField);
        return this;
    }

    public AutoCompletePage switchToStreetAddressTextField(){
        sendTabKey(addressTextField);
        return this;
    }
    
    public AutoCompletePage switchToStreetAddress2TextField(){
        sendTabKey(streetAddressTextField);
        return this;
    }

    public AutoCompletePage switchToCityTextField(){
        sendTabKey(streetAddress2TextField);
        return this;
    }

    public AutoCompletePage switchToStateTextField(){
        sendTabKey(stateTextField);
        return this;
    }

    public AutoCompletePage switchToZipCodeTextField(){
        sendTabKey(zipCodeTextField);
        return this;
    }

    public AutoCompletePage switchToCountryTextField(){
        sendTabKey(countryTextField);
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

    public AutoCompletePage enterCity(String city) {
        writeText(cityTextField,city);
        return this;
    }

    public AutoCompletePage enterState(String state) {
        writeText(stateTextField,state);
        return this;
    }

    public AutoCompletePage enterZipCode(String zipCode) {
        writeText(zipCodeTextField,zipCode);
        return this;
    }

    public AutoCompletePage enterCountry(String country) {
        writeText(countryTextField,country);
        return this;
    }
}
