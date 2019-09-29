package constants;

public enum SupplierFilter {

    ENTERPRISE("enterprise"),
    DOLLAR("dollar"),
    HERTZ("hertz"),
    EUROPCAR("europcar");

    private String name;

    SupplierFilter(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
