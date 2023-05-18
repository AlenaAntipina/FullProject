package database.table.models;

import aquality.selenium.core.logging.Logger;
import database.table.tablefields.TestField;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TestModel extends Model {
    private long id;
    private String name;
    private long statusId;
    private String methodName;
    private long projectId;
    private long sessionId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String env;
    private String browser;

    public TestModel(String testName, int statusId, String method, long projectId, long sessionId, Timestamp startTime, Timestamp endTime, String env, String browser) {
        this.name = testName;
        this.statusId = statusId;
        this.methodName = method;
        this.projectId = projectId;
        this.sessionId = sessionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.env = env;
        this.browser = browser;
    }

    @Override
    @SneakyThrows
    public TestModel getModelFromResultSet(ResultSet resultSet) {
        return new TestModel(
                resultSet.getLong(TestField.ID.getField()),
                resultSet.getString(TestField.NAME.getField()),
                resultSet.getInt(TestField.STATUS_ID.getField()),
                resultSet.getString(TestField.METHOD_NAME.getField()),
                resultSet.getLong(TestField.PROJECT_ID.getField()),
                resultSet.getLong(TestField.SESSION_ID.getField()),
                resultSet.getTimestamp(TestField.START_TIME.getField()),
                resultSet.getTimestamp(TestField.END_TIME.getField()),
                resultSet.getString(TestField.ENV.getField()),
                resultSet.getString(TestField.BROWSER.getField()));
    }

    @Override
    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
        TestModel test = (TestModel) model;
        try {
            preparedStatement.setString(1, test.getName());
            preparedStatement.setLong(2, test.getStatusId());
            preparedStatement.setString(3, test.getMethodName());
            preparedStatement.setLong(4, test.getProjectId());
            preparedStatement.setLong(5, test.getSessionId());
            preparedStatement.setTimestamp(6, test.getStartTime());
            preparedStatement.setTimestamp(7, test.getEndTime());
            preparedStatement.setString(8, test.getEnv());
            preparedStatement.setString(9, test.getBrowser());
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }

}
