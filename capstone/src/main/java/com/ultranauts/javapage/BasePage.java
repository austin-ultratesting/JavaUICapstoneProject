package com.ultranauts.javapage;

import static org.openqa.selenium.Keys.TAB;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class used to define all actions that the POM modeled subclasses
 * should follow.
 * <p>
 * BasePage should not be instanciated.
 * 
 * @author Austin Bell
 */
public abstract class BasePage extends Page {

    /**
     * Constructor to be inherited.
     *
     * @param driver Webdriver that is passed to the super constructor of
     *               {@link Page}
     * @param wait   WebDriverWait that is passed to the super constructor of
     *               {@link Page}
     */
    protected BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Click on the Web Element defined on the WebPage specified by Element Location Parameter
     *  
     * @param elementLocation Element Location as defined by 
     * {@link org.openqa.selenium.By} calls on selector methods
     */
    public void click (By elementLocation) {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
            driver.findElement(elementLocation).click();
        }
        catch(StaleElementReferenceException e){
            driver.findElement(elementLocation).click();
        }
    }
 
    
    /**
     * Write Text into an element's location, for example an input field
     *  
     * @param elementLocation Element Location as defined by 
     * {@link org.openqa.selenium.By} calls on selector methods
     * @param text String of text to be written into the element
     */
    public void writeText (By elementLocation, String text) {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
            driver.findElement(elementLocation).sendKeys(text);
        }
        catch(StaleElementReferenceException e){
            driver.findElement(elementLocation).sendKeys(text);
        }
    }
 
    
    /**
     * Reads any text on a WebElement given the element's location
     *  
     * @param elementLocation Element Location as defined by 
     * {@link org.openqa.selenium.By} calls on selector methods
     * @return A string that represents the visible text shown.
     */
    public String readText (By elementLocation) {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
            return driver.findElement(elementLocation).getText();
        }
        catch(StaleElementReferenceException e){
            return driver.findElement(elementLocation).getText();
        }
    }

    
    /**
     * Simulate the use of the Tab key given the element's location
     *  
     * @param elementLocation Element Location as defined by 
     * {@link org.openqa.selenium.By} calls on selector methods
     */
    public void sendTabKey(By elementLocation){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
            driver.findElement(elementLocation).sendKeys(TAB);
        }
        catch(StaleElementReferenceException e){
            driver.findElement(elementLocation).sendKeys(TAB);
        }
    }
}