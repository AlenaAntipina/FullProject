package database.table.models;

import aquality.selenium.core.logging.Logger;
import database.table.tablefields.ProjectField;
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

public class Project extends Model {
    private long id;
    private String name;

    public Project(String projectName) {
        this.name = projectName;
    }

    @Override
    @SneakyThrows
    public Project getModelFromResultSet(ResultSet resultSet) {
        return new Project(
                resultSet.getLong(ProjectField.ID.getField()),
                resultSet.getString(ProjectField.NAME.getField()));
    }

    @Override
    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
        Project project = (Project) model;
        try {
            preparedStatement.setString(1, project.getName());
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }

}
