package com.cleanup.todoc.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cleanup.todoc.MainApplication;

public class Crud {
    private static final String TAG = "Todoc Crud";
    private SQLiteDatabase db;

    public Crud(MainApplication context){
        Log.d(TAG, "Crud() called with: context = [" + context + "]");
        this.db = context.getDb();
    }

    public SQLiteDatabase getDb() {
        Log.d(TAG, "getDb() called");
        return db;
    }
}
