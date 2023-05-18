package database.table.tablefields;

public enum ProjectField {
    ID("id"),
    NAME("name");

    private final String field;

    private ProjectField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
