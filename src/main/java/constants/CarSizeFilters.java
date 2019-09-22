package constants;

public enum CarSizeFilters {

    COMPACT("compact"),
    STANDARD("standard"),
    CARGO("cargovan"),
    CONVERTIBLE("convertible");

    private String carSize;

    CarSizeFilters(String carSize){
        this.carSize = carSize;
    }

    public String getCarSize(){
        return this.carSize;
    }
}
