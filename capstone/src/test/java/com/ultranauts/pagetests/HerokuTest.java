package com.ultranauts.pagetests;

import java.util.concurrent.TimeUnit;

import com.ultranauts.javapage.Page;
import com.ultranauts.javaui.AutoCompletePage;
import com.ultranauts.javaui.ButtonsPage;
import com.ultranauts.javaui.CheckboxesPage;
import com.ultranauts.javaui.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HerokuTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Page page;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
               
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,20);
 
        //Maximize Window
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        //Instantiate the Page Class
        page = new Page(driver,wait);
    }

    @Test(priority = 0)
    public void homePageLinks() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickAutoComplete();
                                        
        page.getInstance(AutoCompletePage.class).navigateToHome();
        
        page.getInstance(HomePage.class).clickButtons();
                                        
        page.getInstance(ButtonsPage.class).navigateToHome();

        page.getInstance(HomePage.class).clickCheckBox();

        page.getInstance(CheckboxesPage.class).navigateToHome();
    }

    @Test (priority = 1)
    public void autoPageForm() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .gotoAutoComplete();

        page.getInstance(AutoCompletePage.class).enterAddress("6712 Kingsbury Dr.")
                                                .switchToStreetAddressTextField()
                                                .enterStreetAddress("Ultra Testing 123")
                                                .switchToStreetAddress2TextField()
                                                .enterStreetAddress2("Testing out the enter text function");
    }
    
    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}