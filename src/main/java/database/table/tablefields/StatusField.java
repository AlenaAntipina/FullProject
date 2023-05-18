package database.table.tablefields;

public enum StatusField {
    ID("id"),
    NAME("name");

    private final String field;

    private StatusField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
