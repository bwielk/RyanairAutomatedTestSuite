package pages;

import commons.BrowserActions;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    private BrowserActions browserActions;

    public SearchResultsPage(WebDriver driver){
        this.browserActions = new BrowserActions(driver);
    }
}
