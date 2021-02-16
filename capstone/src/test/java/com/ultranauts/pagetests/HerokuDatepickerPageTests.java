package com.ultranauts.pagetests;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import com.ultranauts.javapage.Page;
import com.ultranauts.javaui.DatepickerPage;
import com.ultranauts.javaui.HomePage;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HerokuDatepickerPageTests{

    private WebDriver driver;
    private WebDriverWait wait;
    private Page page;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            driver = new ChromeDriver(options);
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

    @Test (priority = 0, groups = { "heroku"})
    public void selectDate() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickDatepicker();

        page.getInstance(DatepickerPage.class).clickDatePickerTextField();

        LocalDate expected = LocalDate.of(2020, Month.DECEMBER, 20);

        LocalDate selection = page.getInstance(DatepickerPage.class).chooseDate(expected);

        System.out.println(selection);

        Assert.assertEquals(selection, expected);
    }
    
    @AfterMethod
    public void teardown () {
        driver.quit();
    }
    
}