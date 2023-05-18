package pages.dataforpages;

public enum Attribute {
    HREF("href"),
    SRC("src");

    private final String attr;

    private Attribute(String attr) {
        this.attr = attr;
    }

    public String getAttribute() {
        return attr;
    }
}
