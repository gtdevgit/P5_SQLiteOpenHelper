package com.cleanup.todoc.database;

import android.util.Log;

import com.cleanup.todoc.MainApplication;

public class DIDB {
    private static final String TAG = "Todoc DIDB";
    private static TodocSQLiteOpenHelper todocSQLiteOpenHelper;

    public DIDB(){
        Log.d(TAG, "DIDB() called");
    }

    public static TodocSQLiteOpenHelper getInstance() {
        Log.d(TAG, "getInstance() called");
        if (todocSQLiteOpenHelper == null) {
            todocSQLiteOpenHelper = new TodocSQLiteOpenHelper(MainApplication.getInstance(),
                    TodocSQLiteOpenHelper.getDbName(),
                    null,
                    TodocSQLiteOpenHelper.getDbVersion());
        }
        return todocSQLiteOpenHelper;
    };
}
