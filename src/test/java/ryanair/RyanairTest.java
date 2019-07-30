package ryanair;

import commons.TimeMachine;
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
        String currentDate = TimeMachine.getFutureDateFromToday(1, "yyyy,M,d");
        String futureDate = TimeMachine.getFutureDateFromToday(3, "yyyy,M,d");
        homePage.fillLocationTestField(location);
        homePage.selectPickUpDate(currentDate);
        homePage.selectReturnDate(futureDate);
        homePage.clickSearchButton();
    }
}


