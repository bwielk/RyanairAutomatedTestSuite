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
        CarSizeFilters[] filters = {CarSizeFilters.COMPACT, CarSizeFilters.ECONOMY};
        String[] filteringResults = {"compact", "economy"};
        return new Object[][]{
                {filters, filteringResults}
        };
    }

    @Test(dataProvider = "filters-car-size")
    public void searchForCarsOfSpecificSize(CarSizeFilters[] carSizeFilters, String[] expectedResults){
        conductBasicSearch("Barcelona", 5, 16);
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.filterByCarSize(new ArrayList<>(Arrays.asList(carSizeFilters)));
        searchResultsPage.checkFilteringByCarSizeResults(expectedResults);
    }

    private void conductBasicSearch(String location, long daysFromNowForPickUp, long daysFromNowReturnDate){
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
