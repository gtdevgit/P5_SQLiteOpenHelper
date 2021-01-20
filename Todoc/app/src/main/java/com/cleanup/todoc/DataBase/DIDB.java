package com.cleanup.todoc.DataBase;

import android.content.Context;
import android.support.annotation.Nullable;

public class DIDB {
    private static TodocSQLiteOpenHelper todocSQLiteOpenHelper = null;

    public static TodocSQLiteOpenHelper getInstance(@Nullable Context context) {
        if (todocSQLiteOpenHelper == null) {
            todocSQLiteOpenHelper = new TodocSQLiteOpenHelper(context,
                    TodocSQLiteOpenHelper.getDbName(),
                    null,
                    TodocSQLiteOpenHelper.getDbVersion());
        }
        return todocSQLiteOpenHelper;
    };
}
