package database.dao;

import database.dao.sql.DeleteSQL;
import database.dao.sql.InsertSQL;
import database.dao.sql.SelectSQL;
import database.dao.sql.UpdateSQL;
import database.table.models.Session;
import database.table.tablefields.SessionField;
import java.util.List;

public class SessionDAOImpl extends ModelDAOImpl<Session> {

    public SessionDAOImpl() {
    }

    public Session get(long id) {
        String select = SelectSQL.SELECT_ALL_FROM_SESSION_BY_ID.getSql();
        return super.get(id, Session.class, select);
    }

    public List<Session> getAll() {
        String selectAll = SelectSQL.SELECT_ALL_FROM_SESSION.getSql();
        return super.getAll(Session.class, selectAll);
    }

    public void create(Session session) {
        String insert = InsertSQL.INSERT_INTO_SESSION.getSql();
        super.create(Session.class, insert, session);
    }

    public void update(Session session) {
        String update = UpdateSQL.UPDATE_SESSION_BY_ID.getSql();
        super.update(session, SessionField.values().length, Session.class, update);
    }

    public void delete(long id) {
        if (get(id) != null) {
            String delete = DeleteSQL.DELETE_FROM_SESSION_BY_ID.getSql();
            super.delete(id, delete);
        }
    }

}
