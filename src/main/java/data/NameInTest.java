package data;

public enum NameInTest {
    TEST_NAME("Test name"),
    TEST_METHOD_NAME("Test method name"),
    STATUS("Status"),
    START_TIME("Start time"),
    END_TIME("End time"),
    PROJECT_NAME("Project name"),
    ENVIRONMENT("Environment"),
    BROWSER("Browser");

    private final String name;

    private NameInTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
