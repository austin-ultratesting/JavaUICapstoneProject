package com.ultranauts.pagetests;

import com.ultranauts.javaui.AutoCompletePage;
import com.ultranauts.javaui.HomePage;
import org.testng.annotations.Test;



public class HomePageTest extends BaseTest{

    @Test(priority = 0)
    public void homePageLinks() {
        page.getInstance(HomePage.class).goToFormyProject()
                                        .clickAutoComplete()
                                        .navigateToHome();
        
        page.getInstance(HomePage.class).clickButtons()
                                        .navigateToHome();

        page.getInstance(HomePage.class).clickCheckBox()
                                        .navigateToHome();
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
    
}
