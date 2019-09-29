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
        CarSizeFilters[] filters1 = {CarSizeFilters.COMPACT, CarSizeFilters.ECONOMY};
        CarSizeFilters[] filters2 = {CarSizeFilters.STANDARD};
        String[] filteringResults1 = {"compact", "economy"};
        String[] filteringResults2 = {"standard"};
        return new Object[][]{
                {filters1, filteringResults1},
                {filters2, filteringResults2}
        };
    }

    @DataProvider(name = "filters-supplier")
    Object[][] pickup() {
        SupplierFilter[] filter1 = {SupplierFilter.HERTZ, SupplierFilter.EUROPCAR};
        SupplierFilter[] filter2 = {SupplierFilter.EUROPCAR, SupplierFilter.HERTZ, SupplierFilter.DOLLAR};
        String[] filteringResults1 = {"hertz", "europcar"};
        String[] filteringResults2 = {"europcar", "hertz", "dollar"};
        return new Object[][]{
                {filter1, filteringResults1},
                {filter2, filteringResults2}
        };
    }

    @Test(dataProvider = "filters-car-size")
    public void searchForCarsOfSpecificSize(CarSizeFilters[] carSizeFilters, String[] expectedResults){
        conductBasicSearch("Barcelona", 5, 16);
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.filterByCarSize(new ArrayList<>(Arrays.asList(carSizeFilters)));
        searchResultsPage.checkFilteringByCarSizeResults(expectedResults);
    }

    @Test(dataProvider = "filters-supplier")
    public void searchForCarsOfSpecificSuppliers(SupplierFilter[] suppliers, String[] expectedResults){
        conductBasicSearch("New York", 10, 29);
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.filterBySupplier(new ArrayList<>(Arrays.asList(suppliers)));
        searchResultsPage.checkFilteringBySuppliersResults(expectedResults);
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
