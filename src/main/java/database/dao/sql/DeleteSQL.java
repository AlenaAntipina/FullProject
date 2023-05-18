package database.dao.sql;

public enum DeleteSQL {
    DELETE_FROM_ATTACHMENT_BY_ID("DELETE FROM attachment WHERE id =?"),
    DELETE_FROM_AUTHOR_BY_ID("DELETE FROM author WHERE id =?"),
    DELETE_FROM_LOG_BY_ID("DELETE FROM log WHERE id =?"),
    DELETE_FROM_PROJECT_BY_ID("DELETE FROM project WHERE id =?"),
    DELETE_FROM_SESSION_BY_ID("DELETE FROM session WHERE id =?"),
    DELETE_FROM_STATUS_BY_ID("DELETE FROM status WHERE id =?"),
    DELETE_FROM_TEST_BY_ID("DELETE FROM test WHERE id =?");

    private final String sql;
    private DeleteSQL(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
