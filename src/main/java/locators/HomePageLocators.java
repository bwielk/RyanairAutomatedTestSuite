package locators;

public class HomePageLocators {

    public static final String  LOCATION_INPUT = "input[id='pickupLocation']";
    public static final String  RETURN_TO_DIFFERENT_LOCATION_CHECKBOX = "[checkbox-id='dropoffCheckbox2'] input";
    public static final String  RETURN_LOCATION_INPUT  = "input[id='returnLocation']";
    public static final String  SEARCH_BUTTON = "[name='searchCarsFormBtn']";
    public static final String  PICKUP_DATE_INPUT = "[id='pickupDate']";
    public static final String  RETURN_DATE_INPUT = "[id='returnDate']";
    public static final String  PICK_UP_TIME = "[id='ct-pickup-timers']";
    public static final String  RETURN_TIME = "[id='ct-return-timers']";
    public static final String  PICKUP_DATE_TO_SELECT = "[data-comp-id='ct-calendar-date-true'][data-date='%s']";
    public static final String  RETURN_DATE_TO_SELECT = "[data-comp-id='ct-calendar-date-true'][data-date='%s']";
    public static final String  LOCATION_OPTIONS = "[id='div-options-id-0']";
    public static final String  AIRPORT_LOCATION_OPTIONS = "[data-auto-id='listAirports'] ul";
    public static final String  FIRST_AIRPORT_RESULT = AIRPORT_LOCATION_OPTIONS + " [id='item-0-0']";
}
