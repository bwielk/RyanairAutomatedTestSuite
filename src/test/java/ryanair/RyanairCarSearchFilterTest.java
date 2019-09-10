package ryanair;

import base.BaseTestClass;
import commons.TimeMachine;
import constants.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class RyanairCarSearchFilterTest extends BaseTestClass {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @DataProvider(name = "locations-for-car-search")
    Object[][] carSearchLocations(){
        return new Object[][] {{"Barcelona"}};
    }

    @DataProvider(name = "filters")
    Object[][] filters() {
        return new Object[][] {
                {CarSizeFilters.CARGO, CarSizeFilters.COMPACT},
                {FuelPolicyFilter.FULL_TO_FULL, FuelPolicyFilter.SAME_TO_SAME},
                {MileageFilters.LIMITED},
                {RatingFilter.AVERAGE, RatingFilter.GOOD},
                {SupplierFilter.ENTERPRISE, SupplierFilter.EUROPCAR, SupplierFilter.HERTZ}};
    }

    @Test(dataProvider = "locations-for-car-search")
    public void searchForCarsInSpecificLocation(String location){
        conductSearch(location, 5, 16);
        searchResultsPage = new SearchResultsPage(driver);

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
