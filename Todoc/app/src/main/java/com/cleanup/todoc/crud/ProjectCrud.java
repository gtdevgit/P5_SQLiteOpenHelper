package com.cleanup.todoc.crud;

import android.database.Cursor;
import android.util.Log;

import com.cleanup.todoc.database.ProjectTableDefinition;
import com.cleanup.todoc.model.Project;

import java.util.ArrayList;

public class ProjectCrud extends Crud {
    private static final String TAG = "Todoc ProjectCrud";

    public static ArrayList<Project> getAll(){
        Log.d(TAG, "ProjectCrud.getAll() called");

        ArrayList<Project> arrayList= new ArrayList<>();

        openForRead();
        Cursor cursor = getDb().query(ProjectTableDefinition.getTableName(),
                new String[] {ProjectTableDefinition.getColId(),
                        ProjectTableDefinition.getColName(),
                        ProjectTableDefinition.getColColor()},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(0);
                String name = cursor.getString(1);
                int color = cursor.getInt(2);
                Log.d(TAG, String.format("cursor project with id=[%d], name=[%s], color=[%d]", id, name, color));
                Project project = new Project(id, name, color);
                arrayList.add(project);
                cursor.moveToNext();
            }
        };
        close();
        return arrayList;
    };

    public static Project[] getAllAsArray(){
        ArrayList<Project> arrayList = ProjectCrud.getAll();
        Project[] arrayProject = new Project[arrayList.size()];
        arrayProject = arrayList.toArray(arrayProject);
        return  arrayProject;
    }
}
