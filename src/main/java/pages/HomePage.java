package pages;

import commons.BrowserActions;
import constants.WaitingPageOfferedValues;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import waits.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static locators.HomePageLocators.*;
import static locators.SearchResultsLocators.PROGRESS_BAR;
import static locators.WaitingPage.HEADER;
import static locators.WaitingPage.OFFERED_VALUES;

public class HomePage extends BrowserActions{

    private Waits waits;

    public HomePage(WebDriver driver){
        super(driver);
        this.waits = new Waits(driver);
    }

    public void clickSearchButton(){
        click(SEARCH_BUTTON);
        waits.waitUntilElementIsVisible(PROGRESS_BAR);
    }

    public void fillLocationTestField(String location){
        fillTextField(LOCATION_INPUT, location);
        waits.waitUntilElementIsVisible(LOCATION_OPTIONS);
        click(FIRST_AIRPORT_RESULT);
    }

    /**
     * two methods below select date using the date picker/calendar element
     * @param date formatted date as string
     */
    public void selectPickUpDate(String date){
        click(PICKUP_DATE_INPUT);
        checkElementIsDisplayed(PICK_UP_TIME);
        click(String.format(PICKUP_DATE_TO_SELECT, date));
        pressKey(Keys.ESCAPE);
    }

    public void selectReturnDate(String date){
        click(RETURN_DATE_INPUT);
        checkElementIsDisplayed(RETURN_TIME);
        click(String.format(RETURN_DATE_TO_SELECT, date));
        pressKey(Keys.ESCAPE);
    }
}
