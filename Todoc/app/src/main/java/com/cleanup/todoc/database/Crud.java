package com.cleanup.todoc.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Crud {
    private static final String TAG = "Todoc Crud";
    private static SQLiteDatabase db;
    private static TodocSQLiteOpenHelper todocSQLiteOpenHelper;

    public Crud() {
        Log.d(TAG, "Crud() called");
        todocSQLiteOpenHelper = DIDB.getInstance();
    }

    protected void openForWrite(){
        Log.d(TAG, "openForWrite() called");
        db = todocSQLiteOpenHelper.getWritableDatabase();
    }

    protected static void openForRead(){
        Log.d(TAG, "openForRead() called");
        db = todocSQLiteOpenHelper.getReadableDatabase();
    }

    protected static void close(){
        Log.d(TAG, "close() called");
        db.close();
        todocSQLiteOpenHelper.close();
    }

    protected static SQLiteDatabase getDb() {
        return db;
    }
}
