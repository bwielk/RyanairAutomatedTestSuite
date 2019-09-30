package constants;

import java.util.HashMap;
import java.util.Map;

public enum RatingFilter {

    EXCELLENT("excellent", "Excellent", 8, 10),
    VERY_GOOD("vgood", "Very good", 7.5, 8),
    GOOD("good", "Good", 7, 7.5),
    AVERAGE("average", "Average", 0, 7);

    private String type;
    private String description;
    private Map<String, Double> range;

    RatingFilter(String type, String description, double min, double max){
        this.type = type;
        this.description = description;
        this.range = new HashMap<>();
        this.range.put("minimum", min);
        this.range.put("maximum", max);
    }

    public String getType(){
        return this.type;
    }

    public Double getMaximum(){
        return this.range.get("maximum");
    }

    public Double getMinimum(){
        return this.range.get("minimum");
    }

    public String getDescription(){
        return this.description;
    }
}
