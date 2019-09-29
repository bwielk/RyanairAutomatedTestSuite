package pages;

import commons.BrowserActions;
import constants.*;
import org.openqa.selenium.WebDriver;
import waits.Waits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static locators.SearchResultsLocators.*;

public class SearchResultsPage extends BrowserActions {

    private Waits waits;

    public SearchResultsPage(WebDriver driver){
        super(driver);
        this.waits = new Waits(driver);
    }

    public void editSearchCriteria(String locationToEdit){
        click(EDIT_SEARCH_CRITERIA_BUTTON);
        waits.waitUntilElementIsVisible(EDIT_SEARCH_BUTTON);
        editLocation(locationToEdit);
        runNewSearch();
    }

    public void editLocation(String newLocation){
        clearAndFillTextField(EDIT_PICK_UP_LOCATION, newLocation);
        waits.waitUntilElementIsVisible(NEW_LOCATION_RESULTS);
        click(FIRST_RESULT_LOCATION_SEARCH);
        assert getElementByCssSelector(EDIT_PICK_UP_LOCATION).getAttribute("focus").toLowerCase().contains(newLocation.toLowerCase());
    }

    public void runNewSearch(){
        click(EDIT_SEARCH_BUTTON);
        waits.waitUntilElementIsVisible(PROGRESS_BAR);
    }

    public void filterByCarSize(ArrayList<CarSizeFilters> filters){
        filters.forEach((x)-> {
            if(!checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING)){
                click(String.format(FILTER_SIZE_OPTION, x.getCarSize()));
                assert checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING);
            }else{
                String availableCarsBeforeFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                click(String.format(FILTER_SIZE_OPTION, x.getCarSize()));
                waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCarsBeforeFilter);
                String availableCarsAfterFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                assert !availableCarsBeforeFilter.equals(availableCarsAfterFilter);
            }
        });
    }

    public void checkFilteringByCarSizeResults(String[] expectedResult){
        /**
         * Scrolling down until we've got all results visible
         */
        List<String> results = new ArrayList<>();
        int numberOfAvailableCars = Integer.valueOf(getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText());
        int numOfVisibleCarsAfterScroll = 0;
        while(numOfVisibleCarsAfterScroll != numberOfAvailableCars){
            scrollPageDown();
            numOfVisibleCarsAfterScroll = getElementsByCssSelector(CAR_ITEM_PANEL).size();
        }
        /**
         * Get sought for attributes
         */
        List<String> paramValues = getAttributeValues(CAR_ITEM_PANEL, "ct-vehicle-block-replace");
        paramValues.forEach((x)-> {
            results.add(getElementByCssSelector(String.format(CAR_ITEM_PRECISE_SELECTOR, x) + " " + CAR_TYPE_RESULT).getText());
        });
        /**
         * Check the values
         */
        int numberOfMatchingParams = 0;
        for(String param : expectedResult){
            for(String result : results){
                if(result.toLowerCase().equals(param.toLowerCase())){
                    numberOfMatchingParams++;
                }
            }
        }
        assert numberOfAvailableCars == numberOfMatchingParams;
    }

    public void filterByMileage(ArrayList<MileageFilters> filters){
        filters.forEach((x)-> {
            String availableCars = getElementByCssSelector(AVAILABLE_CARS_BEFORE_FILTERING).getText();
            click(String.format(FILTER_MILEAGE_OPTION, x.getType()));
            waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCars);
        });
    }

    public void filterByRating(ArrayList<RatingFilter> filters){
        filters.forEach((x)-> {
            String availableCars = getElementByCssSelector(AVAILABLE_CARS_BEFORE_FILTERING).getText();
            click(String.format(FILTER_RATING_OPTION, x.getType()));
            waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCars);
        });
    }

    public void filterBySupplier(ArrayList<SupplierFilter> filters){
        filters.forEach((x)-> {
            String availableCars = getElementByCssSelector(AVAILABLE_CARS_BEFORE_FILTERING).getText();
            click(String.format(FILTER_SUPPLIER_OPTION, x.getName()));
            waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCars);
        });
    }

    public void filterByFuelPolicy(ArrayList<FuelPolicyFilter> filters){
        filters.forEach((x)-> {
            String availableCars = getElementByCssSelector(AVAILABLE_CARS_BEFORE_FILTERING).getText();
            click(String.format(FILTER_SUPPLIER_OPTION, x.getType()));
            waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCars);
        });
    }
}
