package database.table.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Model {
    public long id;

    public Model getModelFromResultSet(ResultSet resultSet) {
        return new Model();
    }

    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
    }

}