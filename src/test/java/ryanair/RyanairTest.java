package ryanair;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTestClass;
import pages.HomePage;


public class RyanairTest extends BaseTestClass {
    private HomePage homePage = new HomePage(driver);

    @DataProvider(name = "locations-for-car-search")
    Object[][] carSearchLocations(){
        return new Object[][] {{"Heathrow"}, {"Modlin"}};
    }

    @Test(dataProvider = "locations-for-car-search")
    public void searchForCarsInSpecificLocation(String location){
        homePage.fillLocationTestField(location);
        homePage.clickSearchButton();
    }
}


