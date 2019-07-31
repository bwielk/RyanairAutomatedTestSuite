package constants;

public enum WaitingPageOfferedValues {

    CANCELLATION("Free Cancellation"),
    FEES("No Card Fees"),
    AMENDMENTS("Free Amendments");

    String value;

    WaitingPageOfferedValues(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
