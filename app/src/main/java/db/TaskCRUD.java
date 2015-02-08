package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by Sahil on 2/7/2015.
 */
import android.util.Log;
public class TaskCRUD {
    private TaskDBHelper dbHelper;

    public TaskCRUD (Context context)
    {
        dbHelper = new TaskDBHelper(context);
    }

    public boolean insert(TaskContract.Columns c)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.Columns.DATEDAY, c.day);
        Log.d(TaskContract.Columns.DATEDAY, c.day + "");
        values.put(TaskContract.Columns.DATEMONTH, c.month);
        Log.d(TaskContract.Columns.DATEMONTH, c.month + "");
        values.put(TaskContract.Columns.DATEYEAR, c.year);
        Log.d(TaskContract.Columns.DATEYEAR, c.year + "");
        values.put(TaskContract.Columns.TASKDESC, c.description);
        Log.d(TaskContract.Columns.TASKDESC, c.description);
        values.put(TaskContract.Columns.TASKTYPE, c.type);
        Log.d(TaskContract.Columns.TASKTYPE, c.type);
        values.put(TaskContract.Columns.IMP, c.imp);
        Log.d(TaskContract.Columns.IMP, c.imp + "");

        return true;
    }

    public boolean delete(String description)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(TaskContract.TABLE, description + "= ?", new String[] { String.valueOf(description) });
        db.close(); // Closing database connection
        return true;
    }
    public ArrayList<Tasks> getData(int m, int y) {
        ArrayList<Tasks> t = new ArrayList<Tasks>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String q = "SELECT * FROM " + TaskContract.TABLE + " WHERE " +
                TaskContract.Columns.DATEMONTH + " = " + m + " AND " + TaskContract.Columns.DATEYEAR + " = " + y + " ORDER BY "
                + TaskContract.Columns.DATEDAY + " DESC;";
        Cursor c = db.rawQuery(q, null);
        c.moveToFirst();
        do {
            String desc = c.getString(0);
            String type = c.getString(1);
            int year = Integer.parseInt(c.getString(3));
            int month = Integer.parseInt(c.getString(4));
            int day = Integer.parseInt(c.getString(5));
            int imp = Integer.parseInt(c.getString(6));
            Tasks task = new Tasks(day, month, year, imp, desc, type);
            t.add(task);
        } while (c.moveToNext());
        return t;
    }

}

