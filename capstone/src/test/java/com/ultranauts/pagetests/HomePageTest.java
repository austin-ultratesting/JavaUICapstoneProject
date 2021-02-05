package com.ultranauts.pagetests;

import com.ultranauts.javaui.AutoCompletePage;
import com.ultranauts.javaui.HomePage;
import org.testng.annotations.Test;



public class HomePageTest extends BaseTest{

    @Test(priority = 0)
    public void homePageLinks() {

        // *************PAGE INSTANTIATIONS*************
        // HomePage homePage = new HomePage(driver, wait);

        // *************PAGE METHODS********************
        /*
         * homePage.goToFormyProject();
         * 
         * homePage.clickAutoComplete() .getDriver().navigate().back();
         * homePage.clickButtons() .getDriver().navigate().back();
         * homePage.clickCheckBox() .getDriver().navigate().back();
         */
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickAutoComplete()
                                        .navigateBack()
                                        .clickButtons()
                                        .navigateBack()
                                        .clickCheckBox()
                                        .navigateBack();
    }

    @Test (priority = 1)
    public void autoPageForm() {
 
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
 
        
        homePage.goToFormyProject();
        
        AutoCompletePage autoPageForm = homePage.gotoAutoComplete();

        autoPageForm.enterAddress("6712 Kingsbury Dr.");
        autoPageForm.enterStreetAddress("Ultra Testing 123");
        autoPageForm.enterStreetAddress2("Testing out the enter text function");
    }
    
}
