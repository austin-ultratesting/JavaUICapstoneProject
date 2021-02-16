package com.ultranauts.javaui;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import com.ultranauts.javapage.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class DatepickerPage extends BasePage{
    
    public DatepickerPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //*********Web Elements*********
    private By logoID = By.id("logo");

    private By datepickerTextField = By.id("datepicker");
    private String period = "datepicker-switch";
    private String left = "prev";
    private String right = "next+";
    private String dayFORMAT = "//td[contains(text(),%d) and contains(@class, \"day\")]";
    
    public void navigateToHome(){
        click(logoID);
    }

    public DatepickerPage clickDatePickerTextField(){
        click(datepickerTextField);
        return this;
    }

    public LocalDate getCurrentPeriod(){
        By calenderHeader = By.className(period);

        var currentPeriod = driver.findElement(calenderHeader).getText().split(" ");

        return LocalDate.of(
                Integer.parseInt(currentPeriod[1]),
                Month.valueOf(currentPeriod[0].toUpperCase()),
                1);
    }

    public void chooseMonth(LocalDate date) {
        var currentPeriod = getCurrentPeriod();

        By leftArrow = By.className(left);

        By rightArrow = By.className(right);

        long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, date.withDayOfMonth(1));
 
        By arrow = monthsAway < 0 ? leftArrow : rightArrow;
 
        for(int i = 0; i < Math.abs(monthsAway); i++){
            click(arrow);
        }
    }

    public void chooseDay(int dayOfMonth) {
        By locator = By.xpath(format(dayFORMAT, dayOfMonth));
        click(locator);
    }
    
    public LocalDate chooseDate(LocalDate date){
        chooseMonth(date);
        chooseDay(date.getDayOfMonth());
        return getSelectedDate();
    }
 
    public LocalDate getSelectedDate(){
        var fields = driver.findElement(datepickerTextField).getAttribute("value").split("/");
        
        return LocalDate.of(
                Integer.parseInt(fields[2]),
                Integer.parseInt(fields[0]),
                Integer.parseInt(fields[1]));
    }   
}
