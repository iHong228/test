package enumpak;

/**
 * Created by user on 2017-08-02.
 */
public enum Bookshelf {
    NAME("name"), WRITER("writer"), PRICE("price");

    private final String value;

    Bookshelf(String value) {
        this.value = value;
    }

    public String stringValue() {
        return value;
    }

    public static Bookshelf stringValueOf(String value) {
        switch (value) {
            case "name":
                return NAME;
            case "writer":
                return WRITER;
            case "price":
                return PRICE;
            default:
                throw new AssertionError("Unknown value : " + value);
        }
    }
}
