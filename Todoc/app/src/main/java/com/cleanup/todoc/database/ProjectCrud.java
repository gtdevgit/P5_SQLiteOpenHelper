package com.cleanup.todoc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.cleanup.todoc.model.Project;

import java.util.ArrayList;

public class ProjectCrud extends Crud {
    private static final String TAG = "Todoc ProjectCrud";

    public ProjectCrud() {
        super();
        Log.d(TAG, "Todoc ProjectCrud() called");
    }

    public long insert(Project project) {
        // Question : timestamp
        Log.d(TAG, "ProjectCrud.insert() called with: project = [" + project + "]");
        ContentValues content = new ContentValues();
        content.put(ProjectTableDefinition.getColId(), project.getId());
        content.put(ProjectTableDefinition.getColName(), project.getName());
        content.put(ProjectTableDefinition.getColColor(), project.getColor());
        openForWrite();
        long rowId = getDb().insert(ProjectTableDefinition.getTableName(), null, content);
        Log.d(TAG, "insert project rowId = [" + rowId + "]");
        close();
        return rowId;
    }

    public ArrayList<Project> getAll(){
        Log.d(TAG, "ProjectCrud.getAll() called");

        ArrayList<Project> arrayProject= new ArrayList<>();

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
                arrayProject.add(project);
                cursor.moveToNext();
            }
        };
        close();
        return arrayProject;
    };
}
