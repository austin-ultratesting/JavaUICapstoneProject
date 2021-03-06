package com.ultranauts.pagetests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.List;
import com.ultranauts.javapage.Page;
import com.ultranauts.javaui.AutoCompletePage;
import com.ultranauts.javaui.CheckboxesPage;
import com.ultranauts.javaui.DatepickerPage;
import com.ultranauts.javaui.HomePage;
import com.ultranauts.javaui.ModalPage;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HerokuUnitTests {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Page page;

    @BeforeMethod
    public void setup() throws Exception {

        String browser = "firefox";

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

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        //Instantiate the Page Class
        page = new Page(driver,wait);
    }

    @Test(priority = 0)
    public void homePageLinks() {
        String homePage = page.getInstance(HomePage.class).getHomePageURL(); 

        String url = "";

        HttpURLConnection huc = null;
        
        int respCode = 200;

        page.getInstance(HomePage.class).goToFormyProject();

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

        url = it.next().getAttribute("href");

        System.out.println(url);

        if(url == null || url.isEmpty()){
            System.out.println("URL is either not configured for anchor tag or it is empty");
            continue;
        }

        if(!url.startsWith(homePage)){
            System.out.println("URL belongs to another domain, skipping it.");
            continue;
        }

        try {
            huc = (HttpURLConnection)(new URL(url).openConnection());

            huc.setRequestMethod("HEAD");

            huc.connect();

            respCode = huc.getResponseCode();

            if(respCode >= 400){
                System.out.println(url+" is a broken link");
            }
            else{
                System.out.println(url+" is a valid link");
            }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test (priority = 1)
    public void autoPageFormEnterText() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickAutoComplete();

        page.getInstance(AutoCompletePage.class).enterAddress("6712 Kingsbury Dr.")
                                                .switchToStreetAddressTextField()
                                                .enterStreetAddress("Ultra Testing 123")
                                                .switchToStreetAddress2TextField()
                                                .enterStreetAddress2("Testing out the enter text function")
                                                .switchToCityTextField()
                                                .enterCity("Dallas")
                                                .switchToStateTextField()
                                                .enterState("Texas")
                                                .switchToZipCodeTextField()
                                                .enterZipCode("60842")
                                                .switchToCountryTextField()
                                                .enterCountry("United States");
    }

    @Test (priority = 2)
    public void checkboxesActivateAndVerify() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickCheckBox();

        page.getInstance(CheckboxesPage.class).clickCheckBox1()
                                              .clickCheckBox2()
                                              .clickCheckBox3();

        boolean result = page.getInstance(CheckboxesPage.class).verifyAllCheckedBoxes();

        System.out.println("Confirmed all checkboxes clicked:" + result);
    }

    @Test (priority = 3)
    public void selectDate() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickDatepicker();

        page.getInstance(DatepickerPage.class).clickDatePickerTextField();

        LocalDate expected = LocalDate.of(2015, Month.DECEMBER, 20);

        LocalDate selection = page.getInstance(DatepickerPage.class).chooseDate(expected);

        System.out.println(selection);

        Assert.assertEquals(selection, expected);
    }

    @Test (priority = 4)
    public void exploreModal() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickModal();

        page.getInstance(ModalPage.class).clickModalButton()
                                         .clickOkButton()
                                         .clickCloseButton()
                                         .clickModalButton()
                                         .clickXButton();
    }
    
    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}