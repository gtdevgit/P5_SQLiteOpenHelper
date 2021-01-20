package com.cleanup.todoc.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Crud {
    private static final String TAG = "Todoc Crud";
    private SQLiteDatabase db;
    private TodocSQLiteOpenHelper todocSQLiteOpenHelper;

    public Crud(Context context) {
        Log.d(TAG, "Crud() called with: context = [" + context + "]");
        todocSQLiteOpenHelper = DIDB.getInstance(context);
    }

    protected void openForWrite(){
        Log.d(TAG, "openForWrite() called");
        db = todocSQLiteOpenHelper.getWritableDatabase();
    }

    protected void openForRead(){
        Log.d(TAG, "openForRead() called");
        db = todocSQLiteOpenHelper.getReadableDatabase();
    }

    protected void close(){
        Log.d(TAG, "close() called");
        db.close();
        todocSQLiteOpenHelper.close();
    }

    protected SQLiteDatabase getDb() {
        return db;
    }
}
