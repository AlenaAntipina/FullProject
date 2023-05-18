package database.table.models;

import aquality.selenium.core.logging.Logger;
import database.table.tablefields.AuthorField;
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

public class Author extends Model {
    private long id;
    private String name;
    private String login;
    private String email;

    public Author(String nameForAuthor, String loginForAuthor, String emailForAuthor) {
        this.name = nameForAuthor;
        this.login = loginForAuthor;
        this.email = emailForAuthor;
    }

    @Override
    @SneakyThrows
    public Author getModelFromResultSet(ResultSet resultSet) {
        return new Author(resultSet.getLong(AuthorField.ID.getField()),
                resultSet.getString(AuthorField.NAME.getField()),
                resultSet.getString(AuthorField.LOGIN.getField()),
                resultSet.getString(AuthorField.EMAIL.getField()));
    }

    @Override
    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
        Author author = (Author) model;
        try {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getLogin());
            preparedStatement.setString(3, author.getEmail());
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }
}
