package pages;

import commons.BrowserActions;
import org.openqa.selenium.WebDriver;
import waits.Waits;

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
}
