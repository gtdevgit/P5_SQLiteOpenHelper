package com.cleanup.todoc.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.cleanup.todoc.MainApplication;
import com.cleanup.todoc.crud.Crud;
import com.cleanup.todoc.database.TaskTableDefinition;
import com.cleanup.todoc.model.Task;

import java.util.ArrayList;

public class TaskCrud extends Crud {
    private static final String TAG = "Todoc TaskCrud";

    public TaskCrud(MainApplication context) {
        super(context);
        Log.d(TAG, "TaskCrud() called with: context = [" + context + "]");
    }

    public long insert(Task task) {
        // Question : timestamp
        Log.d(TAG, "Task.insert() called with: task = [" + task + "]");
        ContentValues content = new ContentValues();
        content.put(TaskTableDefinition.getColName(), task.getName());
        content.put(TaskTableDefinition.getColProjectId(), task.getProjectId());
        content.put(TaskTableDefinition.getColCreationTimestamp(), task.getCreationTimestamp());

        long rowId = getDb().insert(TaskTableDefinition.getTableName(), null, content);
        Log.d(TAG, "insert task() rowId = [" + rowId + "]");

        return  rowId;
    }

    public ArrayList<Task> getAll(){
        Log.d(TAG, "TaskCrud.getAll() called");

        ArrayList<Task> arrayTask= new ArrayList<>();

        Cursor cursor = getDb().query(TaskTableDefinition.getTableName(),
                new String[] {TaskTableDefinition.getColId(),
                        TaskTableDefinition.getColName(),
                        TaskTableDefinition.getColProjectId(),
                        TaskTableDefinition.getColCreationTimestamp()},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(0);
                long projectId = cursor.getLong(2);
                String name = cursor.getString(1);
                long creationTimestamp = cursor.getLong(3);
                Log.d(TAG, String.format("cursor with id=[%d], projectId=[%d], name=[%s] creationTimestamp=[%d]", id, projectId, name, creationTimestamp));
                Task task = new Task(id, projectId, name, creationTimestamp);
                arrayTask.add(task);
                cursor.moveToNext();
            }
        };
        return arrayTask;
    };

    public void delete(long Id){
        Log.d(TAG, "delete() called with: Id = [" + Id + "]");
        String[] arg = new String[] {String.valueOf(Id)};
        String where = String.format("%s=?", TaskTableDefinition.getColId(), Id) ;
        getDb().delete(TaskTableDefinition.getTableName(), where, arg);
    }
}
