package database.dao;

import database.dao.sql.DeleteSQL;
import database.dao.sql.InsertSQL;
import database.dao.sql.SelectSQL;
import database.dao.sql.UpdateSQL;
import database.table.models.Project;
import database.table.tablefields.ProjectField;

import java.util.List;

public class ProjectDAOImpl extends ModelDAOImpl<Project> {

    public ProjectDAOImpl() {
    }

    public Project get(long id) {
        String select = SelectSQL.SELECT_ALL_FROM_PROJECT_BY_ID.getSql();
        return super.get(id, Project.class, select);
    }

    public List<Project> getAll() {
        String selectAll = SelectSQL.SELECT_ALL_FROM_PROJECT.getSql();
        return super.getAll(Project.class, selectAll);
    }

    public void create(Project project) {
        List<Project> projects = getAll();
        projects.forEach(
                pr -> {
                    if (pr.getName().equals(project.getName())) {
                        project.setId(pr.getId());
                    }
                }
        );

        if (!projects.contains(project)) {
            String insert = InsertSQL.INSERT_INTO_PROJECT.getSql();
            super.create(Project.class, insert, project);
        }
    }

    public void update(Project project) {
        String update = UpdateSQL.UPDATE_PROJECT_BY_ID.getSql();
        super.update(project, ProjectField.values().length, Project.class, update);
    }

    public void delete(long id) {
        if (get(id) != null) {
            String delete = DeleteSQL.DELETE_FROM_PROJECT_BY_ID.getSql();
            super.delete(id, delete);
        }
    }

}
