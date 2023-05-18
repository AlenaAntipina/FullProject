package database.dao;

import database.dao.sql.DeleteSQL;
import database.dao.sql.InsertSQL;
import database.dao.sql.SelectSQL;
import database.dao.sql.UpdateSQL;
import database.table.models.Project;
import database.table.models.Status;
import database.table.tablefields.StatusField;

import java.util.List;

public class StatusDAOImpl extends ModelDAOImpl<Status> {

    public StatusDAOImpl() {
    }

    public Status get(long id) {
        String select = SelectSQL.SELECT_ALL_FROM_STATUS_BY_ID.getSql();
        return super.get(id, Status.class, select);
    }

    public List<Status> getAll() {
        String selectAll = SelectSQL.SELECT_ALL_FROM_STATUS.getSql();
        return super.getAll(Status.class, selectAll);
    }

    public void create(Status status) {
        List<Status> statuses = getAll();
        statuses.forEach(
                st -> {
                    if (st.getName().equals(status.getName())) {
                        status.setId(st.getId());
                    }
                }
        );

        if (!statuses.contains(status)) {
            String insert = InsertSQL.INSERT_INTO_STATUS.getSql();
            super.create(Status.class, insert, status);
        }
    }

    public void update(Status status) {
        String update = UpdateSQL.UPDATE_STATUS_BY_ID.getSql();
        super.update(status, StatusField.values().length, Status.class, update);
    }

    public void delete(long id) {
        if (get(id) != null) {
            String delete = DeleteSQL.DELETE_FROM_STATUS_BY_ID.getSql();
            super.delete(id, delete);
        }
    }

}
