package com.cleanup.todoc.database;

public class ProjectTableDefinition {
    private static final String TABLE_NAME = "projects";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_COLOR = "color";

    private static final String CREATE_TABLE = String.format(
        "CREATE TABLE %s " +
        "(%s INTEGER PRIMARY KEY, " +
        "%s TEXT NOT NULL, " +
        "%s INTEGER )",
        getTableName(), getColId(), getColName(), getColColor());

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColId() {
        return COL_ID;
    }

    public static String getColName() {
        return COL_NAME;
    }

    public static String getColColor() {
        return COL_COLOR;
    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }

    public static String createInsertIntoSatatement(long id, String name, int color){
        return String.format(
                "INSERT INTO %s (%s, %s, %s) " +
                "VALUES (%d, \"%s\", %d)",
                getTableName(), getColId(), getColName(), getColColor(),
                id, name, color);
    }
}
