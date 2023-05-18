package pages.modelsUI;

public enum TestUIField {
    TEST_NAME("Test name"),
    TEST_METHOD("Test method"),
    LATEST_TEST_RESULT("Latest test result"),
    LATEST_TEST_START_TIME("Latest test start time"),
    LATEST_TEST_END_TIME("Latest test end time");

    private final String field;

    private TestUIField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
