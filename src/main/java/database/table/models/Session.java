package database.table.models;

import aquality.selenium.core.logging.Logger;
import database.table.tablefields.SessionField;
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

public class Session extends Model {
    private long id;
    private String sessionKey;
    private Timestamp createdTime;
    private long buildNumber;

    public Session(String sessionKeyForSession, Timestamp timestamp, long buildNumberForSession) {
        this.sessionKey = sessionKeyForSession;
        this.createdTime = timestamp;
        this.buildNumber = buildNumberForSession;
    }

    @Override
    @SneakyThrows
    public Session getModelFromResultSet(ResultSet resultSet) {
        return new Session(
                resultSet.getLong(SessionField.ID.getField()),
                resultSet.getString(SessionField.SESSION_KEY.getField()),
                resultSet.getTimestamp(SessionField.CREATED_TIME.getField()),
                resultSet.getLong(SessionField.BUILD_NUMBER.getField()));
    }

    @Override
    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
        Session session = (Session) model;
        try {
            preparedStatement.setString(1, session.getSessionKey());
            preparedStatement.setTimestamp(2, session.getCreatedTime());
            preparedStatement.setLong(3, session.getBuildNumber());
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }
}
