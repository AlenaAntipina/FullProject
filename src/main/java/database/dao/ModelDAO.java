package database.dao;

import database.table.models.Model;

import java.util.List;

public interface ModelDAO<T> {

    T get(long id, Class<T> modelClass, String sql);

    List<T> getAll(Class<T> modelClass, String sql);

    void create(Class<T> modelClass, String sql, Model modelToCreate);

    void update(Model modelToUpdate, int positionId, Class<T> modelClass, String sql);

    void delete(long id, String sql);
}
