package ryanair;

import base.BaseTestClass;
import commons.TimeMachine;
import constants.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import java.util.ArrayList;
import java.util.Arrays;

public class RyanairCarSearchFilterTest extends BaseTestClass {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @DataProvider(name = "filters-car-size")
    Object[][] filters() {
        return new Object[][]{
                {CarSizeFilters.CARGO, CarSizeFilters.COMPACT}
        };
    }

    @Test(dataProvider = "filters-car-size")
    public void searchForCarsInSpecificLocation(CarSizeFilters[] carSizeFilters){
        conductSearch("Barcelona", 5, 16);
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.filterByCarSize(new ArrayList<>(Arrays.asList(carSizeFilters)));
    }

    private void conductSearch(String location, long daysFromNowForPickUp, long daysFromNowReturnDate){
        homePage = new HomePage(driver);
        if(daysFromNowForPickUp >= daysFromNowReturnDate){
            throw new IllegalArgumentException("Number of future days for pick up date must be less than the " +
                    "number of future days for return date");
        }
        String currentDate = TimeMachine.getFutureDateFromToday(daysFromNowForPickUp, "yyyy,M,d");
        String futureDate = TimeMachine.getFutureDateFromToday(daysFromNowReturnDate, "yyyy,M,d");
        homePage.fillLocationTestField(location);
        homePage.selectPickUpDate(currentDate);
        homePage.selectReturnDate(futureDate);
        homePage.clickSearchButton();
    }
}
