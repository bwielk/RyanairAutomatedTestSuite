package pages;

import commons.BrowserActions;
import org.openqa.selenium.WebDriver;

import static locators.HomePageLocators.*;

public class HomePage {

    private BrowserActions browserActions;

    public HomePage(WebDriver driver){
        this.browserActions = new BrowserActions(driver);
    }

    public void clickSearchButton(){
        browserActions.clickButton(SEARCH_BUTTON);
    }

    public void fillLocationTestField(String location){
        browserActions.fillTextField(LOCATION_INPUT, location);
    }

    /**
     * two methods below select date using the date picker/calendar element
     * @param date formatted date as string
     */
    public void selectPickUpDate(String date){
    }

    public void selectReturnDate(String date){
    }

    /**
     * two methods below select dats by filling out the date forms
     */
}
