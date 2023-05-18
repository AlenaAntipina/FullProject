package database.table.models;

import aquality.selenium.core.logging.Logger;
import database.table.tablefields.AttachmentField;
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

public class Attachment extends Model {
    private long id;
    private byte[] content;
    private String contentType;
    private long testId;

    public Attachment(byte[] content, String contentType, long testId) {
        this.content = content;
        this.contentType = contentType;
        this.testId = testId;
    }

    @Override
    @SneakyThrows
    public Attachment getModelFromResultSet(ResultSet resultSet) {
        return new Attachment(resultSet.getLong(AttachmentField.ID.getField()),
                resultSet.getBytes(AttachmentField.CONTENT.getField()),
                resultSet.getString(AttachmentField.CONTENT_TYPE.getField()),
                resultSet.getLong(AttachmentField.TEST_ID.getField()));
    }

    @Override
    public void prepareStatementForEdit(PreparedStatement preparedStatement, Model model) {
        Attachment attachment = (Attachment) model;
        try {
            preparedStatement.setBytes(1, attachment.getContent());
            preparedStatement.setString(2, attachment.getContentType());
            preparedStatement.setLong(3, attachment.getTestId());
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }
}
