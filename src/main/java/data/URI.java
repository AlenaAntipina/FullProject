package data;

public enum URI {
    TOKEN_GET("/token/get");

    private final String uri;

    URI(String uri) {
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }
}
