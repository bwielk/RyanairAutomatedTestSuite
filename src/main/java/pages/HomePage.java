package pages;

import commons.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static locators.HomePageLocators.*;

public class HomePage {

    private BrowserActions browserActions;

    public HomePage(WebDriver driver){
        this.browserActions = new BrowserActions(driver);
    }

    public void clickSearchButton(){
        browserActions.click(SEARCH_BUTTON);
    }
}
