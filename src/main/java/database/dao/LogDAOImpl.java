package database.dao;

import database.dao.sql.DeleteSQL;
import database.dao.sql.InsertSQL;
import database.dao.sql.SelectSQL;
import database.dao.sql.UpdateSQL;
import database.table.models.Log;
import database.table.tablefields.LogField;

import java.util.List;

public class LogDAOImpl extends ModelDAOImpl<Log> {

    public LogDAOImpl() {
    }

    public Log get(long id) {
        String select = SelectSQL.SELECT_ALL_FROM_LOG_BY_ID.getSql();
        return super.get(id, Log.class, select);
    }

    public List<Log> getAll() {
        String selectAll = SelectSQL.SELECT_ALL_FROM_LOG.getSql();
        return super.getAll(Log.class, selectAll);
    }

    public void create(Log log) {
        String insert = InsertSQL.INSERT_INTO_LOG.getSql();
        super.create(Log.class, insert, log);
    }

    public void update(Log log) {
        String update = UpdateSQL.UPDATE_LOG_BY_ID.getSql();
        super.update(log, LogField.values().length, Log.class, update);
    }

    public void delete(long id) {
        if (get(id) != null) {
            String delete = DeleteSQL.DELETE_FROM_LOG_BY_ID.getSql();
            super.delete(id, delete);
        }
    }

}
