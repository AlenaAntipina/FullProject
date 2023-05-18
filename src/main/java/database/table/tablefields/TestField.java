package database.table.tablefields;

public enum TestField {
    ID("id"),
    NAME("name"),
    STATUS_ID("status_id"),
    METHOD_NAME("method_name"),
    PROJECT_ID("project_id"),
    SESSION_ID("session_id"),
    START_TIME("start_time"),
    END_TIME("end_time"),
    ENV("env"),
    BROWSER("browser");

    private final String field;

    private TestField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
