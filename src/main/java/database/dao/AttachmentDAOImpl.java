package database.dao;

import database.dao.sql.DeleteSQL;
import database.dao.sql.InsertSQL;
import database.dao.sql.SelectSQL;
import database.dao.sql.UpdateSQL;
import database.table.models.Attachment;
import database.table.tablefields.AttachmentField;

import java.util.List;

public class AttachmentDAOImpl extends ModelDAOImpl<Attachment> {

    public AttachmentDAOImpl() {
    }

    public Attachment get(long id) {
        String select = SelectSQL.SELECT_ALL_FROM_ATTACHMENT_BY_ID.getSql();
        return super.get(id, Attachment.class, select);
    }

    public List<Attachment> getAll() {
        String selectAll = SelectSQL.SELECT_ALL_FROM_ATTACHMENT.getSql();
        return super.getAll(Attachment.class, selectAll);
    }

    public void create(Attachment attachment) {
        String insert = InsertSQL.INSERT_INTO_ATTACHMENT.getSql();
        super.create(Attachment.class, insert, attachment);
    }

    public void update(Attachment attachment) {
        String update = UpdateSQL.UPDATE_ATTACHMENT_BY_ID.getSql();
        super.update(attachment, AttachmentField.values().length, Attachment.class, update);
    }

    public void delete(long id) {
        if (get(id) != null) {
            String delete = DeleteSQL.DELETE_FROM_ATTACHMENT_BY_ID.getSql();
            super.delete(id, delete);
        }
    }

}
