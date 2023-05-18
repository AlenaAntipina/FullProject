package database;

import aquality.selenium.core.logging.Logger;
import lombok.experimental.UtilityClass;
import utils.JsonUtils;
import utils.PathUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DBConnection {
    private static final String PATH = PathUtils.getAbsolutePath("jdbcConnection.json");

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        JsonUtils.getStringData(FieldInJsonJDBC.URL.getUrl(), PATH),
                        JsonUtils.getStringData(FieldInJsonJDBC.USER_NAME.getUrl(), PATH),
                        JsonUtils.getStringData(FieldInJsonJDBC.PASSWORD.getUrl(), PATH));
            } catch (SQLException e) {
                Logger.getInstance().error("SQLException: " + e);
            }
        }
        return connection;
    }
}
