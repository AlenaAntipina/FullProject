package database.table.tablefields;

public enum AttachmentField {
    ID("id"),
    CONTENT("content"),
    CONTENT_TYPE("content_type"),
    TEST_ID("test_id");

    private final String field;

    private AttachmentField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
