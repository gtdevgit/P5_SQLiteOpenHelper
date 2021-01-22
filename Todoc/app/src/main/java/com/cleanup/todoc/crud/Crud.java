package com.cleanup.todoc.crud;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cleanup.todoc.database.DIDB;
import com.cleanup.todoc.database.TodocSQLiteOpenHelper;

public class Crud {
    private static final String TAG = "Todoc Crud";
    private static SQLiteDatabase db;

    protected static void openForWrite(){
        Log.d(TAG, "openForWrite() called");
        db = getTodocSQLiteOpenHelper().getWritableDatabase();
    }

    protected static void openForRead(){
        Log.d(TAG, "openForRead() called");
        db = getTodocSQLiteOpenHelper().getReadableDatabase();
    }

    protected static void close(){
        Log.d(TAG, "close() called");
        db.close();
        getTodocSQLiteOpenHelper().close();
    }

    private static TodocSQLiteOpenHelper getTodocSQLiteOpenHelper(){
        Log.d(TAG, "getTodocSQLiteOpenHelper() called");
        return DIDB.getInstance();
    }

    protected static SQLiteDatabase getDb() {
        return db;
    }
}
