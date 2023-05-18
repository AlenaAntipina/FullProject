package database.table.tablefields;

public enum SessionField {
    ID("id"),
    SESSION_KEY("session_key"),
    CREATED_TIME("created_time"),
    BUILD_NUMBER("build_number");

    private final String field;

    private SessionField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
