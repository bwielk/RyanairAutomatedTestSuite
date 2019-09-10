package constants;

public enum MileageFilters {

    LIMITED("limited"),
    UNLIMITED("unlimited");

    private String type;

    MileageFilters(String type){
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
