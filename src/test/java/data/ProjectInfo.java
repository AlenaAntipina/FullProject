package data;

public enum ProjectInfo {
    LOGS("info"),
    AUTHOR_NAME("MAD"),
    COOKIE_PARAM("token"),
    FRAME_NAME("addProjectFrame");

    private final String text;

    ProjectInfo(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
