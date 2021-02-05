package com.ultranauts.javaui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPage extends WebPage {

    protected TestPage(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        TestPage examplePage = new TestPage(new ChromeDriver());
        
        examplePage.getDriver().get("https://formy-project.herokuapp.com/keypress");
        WebElement name = examplePage.getDriver().findElement(By.id("name"));
        name.click();
        name.sendKeys("Austin Bell");
        WebElement button = examplePage.getDriver().findElement(By.id("button"));
        button.click();
        examplePage.getDriver().close();
        examplePage.getDriver().quit();
/*
        examplePage.setDriver(new FirefoxDriver());
        examplePage.getDriver().get("https://www.google.com");
        examplePage.getDriver().close();
        examplePage.getDriver().quit();
*/
    }
}