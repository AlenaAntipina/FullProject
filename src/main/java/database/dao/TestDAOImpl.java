package database.dao;

import database.dao.sql.DeleteSQL;
import database.dao.sql.InsertSQL;
import database.dao.sql.SelectSQL;
import database.dao.sql.UpdateSQL;
import database.table.models.TestModel;
import database.table.tablefields.TestField;
import java.util.List;

public class TestDAOImpl extends ModelDAOImpl<TestModel> {

    public TestDAOImpl() {
    }

    public TestModel get(long id) {
        String select = SelectSQL.SELECT_ALL_FROM_TEST_BY_ID.getSql();
        return super.get(id, TestModel.class, select);
    }

    public List<TestModel> getAll() {
        String selectAll = SelectSQL.SELECT_ALL_FROM_TEST.getSql();
        return super.getAll(TestModel.class, selectAll);
    }

    public void create(TestModel test) {
        String insert = InsertSQL.INSERT_INTO_TEST.getSql();
        super.create(TestModel.class, insert, test);
    }

    public void update(TestModel test) {
        String update = UpdateSQL.UPDATE_TEST_BY_ID.getSql();
        super.update(test, TestField.values().length, TestModel.class, update);
    }

    public void delete(long id) {
        if (get(id) != null) {
            String delete = DeleteSQL.DELETE_FROM_TEST_BY_ID.getSql();
            super.delete(id, delete);
        }
    }

}
