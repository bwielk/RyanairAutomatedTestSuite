package constants;

public enum RatingFilter {

    EXCELLENT("excellent"),
    VERY_GOOD("vgood"),
    GOOD("good"),
    AVERAGE("average");

    private String type;

    RatingFilter(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
