package database.table.models;

import aquality.selenium.core.logging.Logger;
import database.table.tablefields.LogField;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Log extends Model {
    private long id;
    private String content;
    private boolean isException;
    private long testId;

    public Log(String content, boolean isException, long testId) {
        this.content = content;
        this.isException = isException;
        this.testId = testId;
    }

    @Override
    @SneakyThrows
    public Log getModelFromResultSet(ResultSet resultSet) {
        return new Log(resultSet.getLong(LogField.ID.getField()),
                resultSet.getString(LogField.CONTENT.getField()),
                resultSet.getBoolean(LogField.IS_EXCEPTION.getField()),
                resultSet.getLong(LogField.TEST_ID.getField()));
    }

    @Override
    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
        Log log = (Log) model;
        try {
            preparedStatement.setString(1, log.getContent());
            preparedStatement.setBoolean(2, log.isException());
            preparedStatement.setLong(3, log.getTestId());
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }
}
