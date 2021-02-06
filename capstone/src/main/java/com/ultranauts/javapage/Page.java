package com.ultranauts.javapage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
/**
* An abstraction used to represent any instance of a Web Page typically used by
* a web browser. Every Test that inherits from {@link com.ultranauts.pagetests.HerokuTest} will
* create a Page object which can then call on Pages classes following the POM Model.
* <p>
* The Page Classes was designed to have Generics implemented so that a user can
* chain method calls for readability in the actual tests. Generic User actions are
* definied in {@link BasePage} while any of the subclasses for
* BasePage drive most of the actions a user would like to test.
* @author Austin Bell
*/ 
public class Page {
 
    /**
   * Selenium Web Driver to be used by the current Page
   * 
   */
    protected WebDriver driver;

    /**
   * Selenium Web Driver Wait object to store the time out for operations
   */
    protected WebDriverWait driverwait;
    
    /**
    * Constructor method for all webpages. A Page requires a driver and a wait
    * out time as defined in the parameters. All subclasses invoke the super
    * constructor
    *
    * @param driver Webdriver that is used to execute calls for Page
    * @param wait WebDriverWait that initializes a default timeout when looking for elements
    */
    public Page(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.driverwait = wait;
    }

    /** 
     * Returns the Page's driver
     * 
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    /** 
     * Sets the Page's driver
     * 
     * @param driver
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
 
    /**
     * Implementation of Generics to use Page to call methods of all classes that
     * inherit from {@link com.ultranauts.javapage.BasePage}.   
     * 
     * @param pageClass A page.class that are subclasses of {@link com.ultranauts.javapage.BasePage}
     * @return A new instance of any of the subclasses of {@link com.ultranauts.javapage.BasePage}
     */
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
