package database.dao;

import database.dao.sql.DeleteSQL;
import database.dao.sql.InsertSQL;
import database.dao.sql.SelectSQL;
import database.dao.sql.UpdateSQL;
import database.table.models.Author;
import database.table.models.Project;
import database.table.tablefields.AuthorField;
import java.util.List;

public class AuthorDAOImpl extends ModelDAOImpl<Author> {

    public AuthorDAOImpl() {
    }

    public Author get(long id) {
        String select = SelectSQL.SELECT_ALL_FROM_AUTHOR_BY_ID.getSql();
        return super.get(id, Author.class, select);
    }

    public List<Author> getAll() {
        String selectAll = SelectSQL.SELECT_ALL_FROM_AUTHOR.getSql();
        return super.getAll(Author.class, selectAll);
    }

    public void create(Author author) {
        List<Author> authors = getAll();
        authors.forEach(
                au -> {
                    if (au.getLogin().equals(author.getLogin())) {
                        author.setId(au.getId());
                    }
                }
        );

        if (!authors.contains(author)) {
            String insert = InsertSQL.INSERT_INTO_AUTHOR.getSql();
            super.create(Author.class, insert, author);
        }
    }

    public void update(Author author) {
        String update = UpdateSQL.UPDATE_AUTHOR_BY_ID.getSql();
        super.update(author, AuthorField.values().length, Author.class, update);
    }

    public void delete(long id) {
        if (get(id) != null) {
            String delete = DeleteSQL.DELETE_FROM_AUTHOR_BY_ID.getSql();
            super.delete(id, delete);
        }
    }
}
