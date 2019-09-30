package pages;

import commons.BrowserActions;
import constants.*;
import org.openqa.selenium.WebDriver;
import waits.Waits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String option = FILTER_SIZE_OPTION;
        filters.forEach((x)-> {
            if(!checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING)){
                click(String.format(option, x.getCarSize()));
                assert checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING);
            }else{
                String availableCarsBeforeFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                click(String.format(option, x.getCarSize()));
                waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCarsBeforeFilter);
                String availableCarsAfterFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                assert !availableCarsBeforeFilter.equals(availableCarsAfterFilter);
            }
        });
    }

    public void checkFilteringByCarSizeResults(String[] expectedResult){

        int numberOfAvailableCars = Integer.valueOf(getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText());
        scrollDownThePageUntilAllResultsAreShown(numberOfAvailableCars);
        List<String> results = getInfoFromAllDisplayedCars(CAR_TYPE_RESULT);
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

    public void filterBySupplier(ArrayList<SupplierFilter> filters){
        String option = FILTER_SUPPLIER_OPTION;
        filters.forEach((x)-> {
            if(!checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING)){
                click(String.format(option, x.getName()));
                assert checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING);
            }else{
                String availableCarsBeforeFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                click(String.format(option, x.getName()));
                waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCarsBeforeFilter);
                String availableCarsAfterFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                assert !availableCarsBeforeFilter.equals(availableCarsAfterFilter);
            }
        });
    }

    public void checkFilteringBySuppliersResults(String[] expectedResults){
        int numberOfAvailableCars = Integer.valueOf(getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText());
        scrollDownThePageUntilAllResultsAreShown(numberOfAvailableCars);
        List<String> results = getAttributeValues(CAR_SUPPLIER_RESULT, "alt");
        int numberOfMatchingParams = 0;
        for(String param : expectedResults){
            for(String result : results){
                if(result.toLowerCase().equals(param.toLowerCase())){
                    numberOfMatchingParams++;
                }
            }
        }
        assert numberOfAvailableCars == numberOfMatchingParams;
    }

    public void filterByRating(ArrayList<RatingFilter> filters){
        String option = FILTER_RATING_OPTION;
        filters.forEach((x)-> {
            if(!checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING)){
                click(String.format(option, x.getType()));
                assert checkElementIsDisplayed(AVAILABLE_CARS_AFTER_FILTERING);
            }else{
                String availableCarsBeforeFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                click(String.format(option, x.getType()));
                waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCarsBeforeFilter);
                String availableCarsAfterFilter = getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText();
                assert !availableCarsBeforeFilter.equals(availableCarsAfterFilter);
            }
        });
    }

    public void checkFilteringByRatingResults(RatingFilter[] expectedResults){
        int numberOfAvailableCars = Integer.valueOf(getElementByCssSelector(AVAILABLE_CARS_AFTER_FILTERING).getText());
        scrollDownThePageUntilAllResultsAreShown(numberOfAvailableCars);
        List<String> ratingScoresDescription = getInfoFromAllDisplayedCars(CAR_RATING_RESULT_DESCRIPTION);
        List<String> ratingScoresAsNumbers = getInfoFromAllDisplayedCars(CAR_RATING_RESULT);
        assert ratingScoresAsNumbers.size() == ratingScoresDescription.size();
        Map<String, List<Double>> results = new HashMap<>();
        for(int i=0; i<ratingScoresAsNumbers.size(); i++){
            String key = ratingScoresDescription.get(i).toLowerCase();
            if(results.keySet().contains(key)){
                results.get(key).add(Double.valueOf(ratingScoresAsNumbers.get(i)));
            }else{
                List<Double> values = new ArrayList<>();
                values.add(Double.valueOf(ratingScoresAsNumbers.get(i)));
                results.put(ratingScoresDescription.get(i).toLowerCase(), values);
            }
        }
        for(RatingFilter filter: expectedResults){
            List<Double> r = results.get(filter.getDescription().toLowerCase());
            assert r.stream().allMatch(x -> x >= filter.getMinimum() && x <= filter.getMaximum());
        }
    }


//    public void filterByFuelPolicy(ArrayList<FuelPolicyFilter> filters){
//        filters.forEach((x)-> {
//            String availableCars = getElementByCssSelector(AVAILABLE_CARS_BEFORE_FILTERING).getText();
//            click(String.format(FILTER_SUPPLIER_OPTION, x.getType()));
//            waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCars);
//        });
//    }

//    public void filterByMileage(ArrayList<MileageFilters> filters){
//        filters.forEach((x)-> {
//            String availableCars = getElementByCssSelector(AVAILABLE_CARS_BEFORE_FILTERING).getText();
//            click(String.format(FILTER_MILEAGE_OPTION, x.getType()));
//            waits.waitUntilTextHasChanged(AVAILABLE_CARS_BEFORE_FILTERING, availableCars);
//        });
//    }
//

    public void scrollDownThePageUntilAllResultsAreShown(int numberOfAvailableCars){
        int numOfVisibleCarsAfterScroll = 0;
        while(numOfVisibleCarsAfterScroll != numberOfAvailableCars){
            scrollPageDown();
            numOfVisibleCarsAfterScroll = getElementsByCssSelector(CAR_ITEM_PANEL).size();
        }
    }

    /**
     * Extracts content about a car (e.g. category, type etc.) from all cars displayed in the results.
     * All the data is aggregated in a list
     * @param informationCssSelector - css selector of a detail displayed in car item in the the results list
     * @return a list of Strings representing the displayed values
     */
    public List<String> getInfoFromAllDisplayedCars(String informationCssSelector){
        List<String> results = new ArrayList<>();
        /**
         * Here (line 76) we need to get all the car ids from the ct-vehicle-block-replace attribute. It makes
         * searching for car data easier css locator-wise
         */
        List<String> paramValues = getAttributeValues(CAR_ITEM_PANEL, "ct-vehicle-block-replace");
        paramValues.forEach((x)-> {
            results.add(getElementByCssSelector(String.format(CAR_ITEM_PRECISE_SELECTOR, x) + " " + informationCssSelector).getText());
        });
        return results;
    }
}
