package database.dao.sql;

public enum UpdateSQL {
    UPDATE_ATTACHMENT_BY_ID("UPDATE attachment SET content = ?, content_type = ?, test_id = ? WHERE id = ?"),
    UPDATE_AUTHOR_BY_ID("UPDATE author SET name = ?, login = ?, email = ? WHERE id = ?"),
    UPDATE_LOG_BY_ID("UPDATE log SET content = ?, is_exception = ?, test_id = ? WHERE id = ?"),
    UPDATE_PROJECT_BY_ID("UPDATE project SET name = ? WHERE id = ?"),
    UPDATE_SESSION_BY_ID("UPDATE session SET session_key = ?, created_time = ?, build_number = ? WHERE id = ?"),
    UPDATE_STATUS_BY_ID("UPDATE status SET name = ? WHERE id = ?"),
    UPDATE_TEST_BY_ID("UPDATE test SET name = ?, status_id = ?, method_name = ?, project_id = ?, " +
            "session_id = ?, start_time = ?, end_time = ?, env = ?, browser = ? WHERE id = ?");

    private final String sql;
    private UpdateSQL(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
