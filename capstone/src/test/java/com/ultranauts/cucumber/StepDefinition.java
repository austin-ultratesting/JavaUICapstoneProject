package com.ultranauts.cucumber;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import com.ultranauts.javapage.Page;
import com.ultranauts.javaui.CheckboxesPage;
import com.ultranauts.javaui.DatepickerPage;
import com.ultranauts.javaui.HomePage;
import com.ultranauts.javaui.ModalPage;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {

    private WebDriver driver;
    private WebDriverWait wait;
    private Page page;
    private LocalDate date;

    @Before public void setup() throws Exception {
        System.out.println("*******before SanitySmoke*******");

        String browser = "chrome";
        
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

    @Given("^I am on the Checkbox Page$")
    public void i_am_on_the_checkbox_page() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickCheckBox();
    }

    @When("^I click on all checkboxes$")
    public void i_click_on_all_checkboxes() {
        page.getInstance(CheckboxesPage.class).clickCheckBox1()
                                              .clickCheckBox2()
                                              .clickCheckBox3();
    } 
    
    @Then("^all the checkboxes will be active$")
    public void all_the_checkboxes_will_be_active(){
        boolean result = page.getInstance(CheckboxesPage.class).verifyAllCheckedBoxes();
        System.out.println("Confirmed all checkboxes clicked:" + result);
        Assert.assertTrue(result);
    }

    @Given("^I am on the Modal Page$")
    public void i_am_on_the_modal_page() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickModal();
    }

    @When("^I open the modal on the webpage$")
    public void i_open_the_modal_on_the_webpage() {
        page.getInstance(ModalPage.class).clickModalButton();
    }

    @Then("^I can close it with the close button$")
    public void i_can_close_it_with_the_close_button(){
        page.getInstance(ModalPage.class).clickCloseButton();
    }

    @Given("^I am on the Datepicker Page$")
    public void i_am_on_the_datepicker_page() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickDatepicker();
    }

    @When("^I click on the text field$")
    public void i_click_on_the_text_field() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickDatepicker();
    }

    @Then("I can select a date with {int}, {int}, and {int}")
    public void i_can_select_a_date_with_and(int day, int month, int year) {
        LocalDate expectedDate = LocalDate.of(year, month, day);

        page.getInstance(DatepickerPage.class).clickDatePickerTextField();

        date = page.getInstance(DatepickerPage.class).chooseDate(expectedDate);
    }

    @And("^the full date should display on the text field$")
    public void the_full_date_should_display_on_the_text_field(){
        LocalDate textField = page.getInstance(DatepickerPage.class).getSelectedDate();

        System.out.println(textField);

        Assert.assertEquals(date, textField);
    }

    @After public void tearDown(){ 
        driver.close(); 
     } 
}
