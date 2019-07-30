package pages;

import commons.BrowserActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import waits.*;

import static locators.HomePageLocators.*;

public class HomePage {

    private BrowserActions browserActions;
    private Waits waits;

    public HomePage(WebDriver driver){
        this.browserActions = new BrowserActions(driver);
        this.waits = new Waits(driver);
    }

    public void clickSearchButton(){
        browserActions.click(SEARCH_BUTTON);
    }

    public void fillLocationTestField(String location){
        browserActions.fillTextField(LOCATION_INPUT, location);
        waits.waitUntilElementIsVisible(LOCATION_OPTIONS);
        browserActions.click(FIRST_AIRPORT_RESULT);
    }

    /**
     * two methods below select date using the date picker/calendar element
     * @param date formatted date as string
     */
    public void selectPickUpDate(String date){
        browserActions.click(PICKUP_DATE_INPUT);
        browserActions.checkElementIsDisplayed(PICK_UP_TIME);
        browserActions.click(String.format(PICKUP_DATE_TO_SELECT, date));
        browserActions.pressKey(Keys.ESCAPE);
    }

    public void selectReturnDate(String date){
        browserActions.click(RETURN_DATE_INPUT);
        browserActions.checkElementIsDisplayed(RETURN_TIME);
        browserActions.click(String.format(RETURN_DATE_TO_SELECT, date));
        browserActions.pressKey(Keys.ESCAPE);
    }
}
