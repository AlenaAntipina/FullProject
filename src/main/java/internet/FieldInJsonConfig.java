package internet;

public enum FieldInJsonConfig {
    MAIN_URL_WITH_CREDENTIALS("mainUrlWithCredentials"),
    BASE_URI("baseUri");

    private final String url;
    private FieldInJsonConfig(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
