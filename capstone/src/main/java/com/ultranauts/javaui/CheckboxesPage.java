package com.ultranauts.javaui;

import java.util.List;

import com.ultranauts.javapage.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //*********Web Elements*********
    private By logoID = By.id("logo");
    private By checkBox1 = By.cssSelector("input#checkbox-1");
    private By checkBox2 = By.cssSelector("input#checkbox-2");
    private By checkBox3 = By.cssSelector("input#checkbox-3");
    
    public void navigateToHome(){
        click(logoID);
    }

    public CheckboxesPage clickCheckBox1(){
        click(checkBox1);
        return this;

    }

    public CheckboxesPage clickCheckBox2(){
        click(checkBox2);
        return this;
    }

    public CheckboxesPage clickCheckBox3(){
        click(checkBox3);
        return this;
    }

    public boolean verifyAllCheckedBoxes(){
        boolean verify = false;
        
        List<WebElement> uncheckboxes = driver.findElements(By.cssSelector("input:not(:checked)[type='checkbox']"));

        if(uncheckboxes.isEmpty()){
            verify = true;
        }

        return verify;
    }
}
