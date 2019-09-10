package locators;

public class SearchResultsLocators {

    //SEARCH PARAMETERS
    public static final String PICKUP_LOCATION_SEARCH_PARAM = "[ng-bind-html='data.pickupLocation.name']";
    public static final String RETURN_LOCATION_SEARCH_PARAM = "[ng-bind-html='data.returnLocation.name']";
    public static final String DROP_OFF_DATE = "[data-auto-id='searchFormReturnDateReadOnly']";
    public static final String PICK_UP_DATE = "[data-auto-id='searchFormPickupDateReadOnly']";
    public static final String PICK_UP_TIME = "[data-auto-id='searchFormPickupTimeReadOnly']";
    public static final String DROP_OFF_TIME = "[data-auto-id='searchFormReturnTimeReadOnly']";
    public static final String CURRENCY = "[ng-bind='data.currencyCode']";

    //OTHER ELEMENTS
    public static final String PROGRESS_BAR = "[page='vehicles']";
    public static final String EDIT_SEARCH_CRITERIA_BUTTON = "button[data-auto-id='btnEdit']";

    //EDIT SEARCH FORM
    public static final String EDIT_PICK_UP_LOCATION = "input[id='pickupLocation']";
    public static final String EDIT_PICK_UP_DATE = "input[id='pickupDate']";
    public static final String EDIT_PICK_UP_TIME = "input[id='pickupTime']";
    public static final String DIFFERENT_DROP_OFF_LOCATION = "[id='dropoffCheckbox']";
    public static final String RESIDENCE = "[id='residenceCode']";
    public static final String EDIT_CURRENCY = "[id='currencyCode']";
    public static final String EDIT_SEARCH_BUTTON = "[name='searchCarsFormBtn']";
    public static final String EDIT_RETURN_DATE = "[id='returnDate']";
    public static final String EDIT_RETURN_TIME = "[id='returnTime']";
    public static final String FIRST_RESULT_LOCATION_SEARCH = "[id='item-0-0']";
    public static final String NEW_LOCATION_RESULTS = "[id='div-options-id-0']";

    //FILTERS
    public static final String AVAILABLE_CARS = "[class='availabilitySummaryDisplayCount']";
    public static final String FILTER_CHECKBOX_OPTION = "[id='input-size-%s']";
    public static final String FILTER_FUEL_OPTION = "[id='input-fuelPolicy-%s']";
    public static final String FILTER_MILEAGE_OPTION = "[id='input-mileage-%s']";
    public static final String FILTER_RATING_OPTION = "[id='input-hireCompanyRating-%s']";
    public static final String FILTER_SUPPLIER_OPTION = "[id='input-supplier-%s']";
}
