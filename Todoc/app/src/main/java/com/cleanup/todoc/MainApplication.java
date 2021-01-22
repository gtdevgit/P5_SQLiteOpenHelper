package com.cleanup.todoc;

import android.app.Application;
import android.util.Log;

/**
 * To get the context of the application.
 * It is the context of the application and not that of an activity.
 */
public class MainApplication extends Application {
    private static final String TAG = "Todoc MainApplication";
    private static Application application;

    public MainApplication() {
        Log.d(TAG, "MainApplication() called");
        application = this;
    }

    public static Application getInstance() {
        Log.d(TAG, "getInstance() called");
        return application;
    }
}
