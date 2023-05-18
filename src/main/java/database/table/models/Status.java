package database.table.models;

import aquality.selenium.core.logging.Logger;
import database.table.tablefields.StatusField;
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

public class Status extends Model {
    private long id;
    private String name;

    public Status(String name) {
        this.name = name;
    }

    @Override
    @SneakyThrows
    public Status getModelFromResultSet(ResultSet resultSet) {
        return new Status(resultSet.getLong(StatusField.ID.getField()),
                resultSet.getString(StatusField.NAME.getField()));
    }

    @Override
    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
        Status status = (Status) model;
        try {
            preparedStatement.setString(1, status.getName());
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }
}
