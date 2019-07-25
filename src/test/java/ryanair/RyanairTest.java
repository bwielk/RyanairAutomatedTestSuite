package ryanair;

import org.testng.annotations.Test;
import base.BaseTestClass;
import pages.HomePage;


public class RyanairTest extends BaseTestClass {
    private HomePage homePage = new HomePage(driver);

    @Test
    public void clickButton(){
        homePage.clickSearchButton();
    }
}


