package database.table.tablefields;

public enum LogField {
    ID("id"),
    CONTENT("content"),
    IS_EXCEPTION("is_exception"),
    TEST_ID("test_id");

    private final String field;

    private LogField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
