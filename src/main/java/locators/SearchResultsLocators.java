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
    public static final String AVAILABLE_CARS_BEFORE_FILTERING = "[class='ct-availability-wrapper'] strong[class='availabilitySummaryTotal']";
    public static final String AVAILABLE_CARS_AFTER_FILTERING = "[class='ct-availability-wrapper'] strong[class='availabilitySummaryDisplayCount']";
    public static final String FILTER_SIZE_OPTION = "label[for='size-%s']";
    public static final String FILTER_FUEL_OPTION = "[id='input-fuelPolicy-%s']";
    public static final String FILTER_MILEAGE_OPTION = "[id='input-mileage-%s']";
    public static final String FILTER_RATING_OPTION = "label[for='hireCompanyRating-%s']";
    public static final String FILTER_SUPPLIER_OPTION = "label[for='supplier-%s']";

    //RESULTS
    public static final String CAR_ITEM_PANEL = "[class='ct-car-list-item__wrap']";
    public static final String CAR_ITEM_PRECISE_SELECTOR = "[ct-vehicle-block-replace='%s']";
    public static final String CAR_TYPE_RESULT = "ct-vehicle-block-group[class=\"ct-block\"]";
    public static final String SHOW_MORE_RESULTS = "[class=\"ct-loading-show-more-container\"] button";
    public static final String CAR_SUPPLIER_RESULT = CAR_ITEM_PANEL + " img[class=\"ct-supplier-image-size__undefined\"]";
    public static final String CAR_RATING_RESULT = "[ng-bind=\":: $ctrl.customerReviewsScoresOverall\"]";
    public static final String CAR_RATING_RESULT_DESCRIPTION = "[class=\"ct-customer-rating-description\"]";

//    public static final String CAR_SIZE_INFO = CAR_ITEM_PANEL + ;
}
