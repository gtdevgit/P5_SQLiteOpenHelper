package com.cleanup.todoc.DataBase;

public class TaskTableDefinition {
    private static final String TABLE_NAME = "tasks";
    private static final String COL_ID = "id";
    private static final String COL_PROJECT_ID = "project_id";
    private static final String COL_NAME = "name";
    private static final String COL_CREATION_TIMESTAMP = "creation_timestamp";

    private static final String CREATE_TABLE = String.format(
            "CREATE TABLE %s " +
                    "(%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s INTEGER, " +
                    "%s INTEGER )",
            TABLE_NAME, COL_ID, COL_NAME, COL_CREATION_TIMESTAMP, COL_PROJECT_ID);

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColId() {
        return COL_ID;
    }

    public static String getColProjectId() {
        return COL_PROJECT_ID;
    }

    public static String getColName() {
        return COL_NAME;
    }

    public static String getColCreationTimestamp() {
        return COL_CREATION_TIMESTAMP;
    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }
}
