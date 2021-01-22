package com.cleanup.todoc;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cleanup.todoc.database.TodocSQLiteOpenHelper;

/**
 * To get the context of the application.
 * It is the context of the application and not that of an activity.
 */
public class MainApplication extends Application {
    private static final String TAG = "Todoc MainApplication";

    private SQLiteDatabase db = null;

    public MainApplication() {
        Log.d(TAG, "MainApplication() called");
    }

    public SQLiteDatabase getDb(){
        Log.d(TAG, "getDb() called");
        if (db == null) {
            db = new TodocSQLiteOpenHelper(this).getWritableDatabase();
        }
        return db;
    }
}
