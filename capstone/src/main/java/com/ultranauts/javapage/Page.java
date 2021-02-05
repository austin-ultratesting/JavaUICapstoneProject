package com.ultranauts.javapage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
 
/**
 * Created by obaskirt on 08-Nov-17.
 */
public class Page {
 
    protected WebDriver driver;
    protected WebDriverWait driverwait;
    
    //Constructor
    public Page(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.driverwait = wait;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
 
    //JAVA Generics to Create and return a New Page
    public  <T extends BasePage> T getInstance (Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.driverwait);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
