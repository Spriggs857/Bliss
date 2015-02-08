package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
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
        values.clear();
//        values.put(TaskContract.Columns.KEY_DATEDAY, c.day);
//        Log.d(TaskContract.Columns.KEY_DATEDAY, c.day + "");
//
//        values.put(TaskContract.Columns.KEY_IMP, c.im);
//        Log.d(TaskContract.Columns.KEY_IMP, c.im + "");

        values.put(TaskContract.Columns.KEY_TASKDESC, c.description);
        Log.d(TaskContract.Columns.KEY_TASKDESC, c.description);

//        values.put(TaskContract.Columns.KEY_DATEMONTH, c.month);
//        Log.d(TaskContract.Columns.KEY_DATEMONTH, c.month + "");
//
//        values.put(TaskContract.Columns.KEY_TASKTYPE, c.type);
//        Log.d(TaskContract.Columns.KEY_TASKTYPE, c.type);
//
//        values.put(TaskContract.Columns.KEY_DATEYEAR, c.year);
//        Log.d(TaskContract.Columns.KEY_DATEYEAR, c.year + "");

        Log.d("values description",values.toString());

//        db.insertWithOnConflict(TaskContract.TABLE,null,values,SQLiteDatabase.CONFLICT_IGNORE);
        db.insert(TaskContract.TABLE,null,values);
        db.close();
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

        String q = "SELECT * FROM " + TaskContract.TABLE;
//            String q = "SELECT * FROM " + TaskContract.TABLE + " WHERE " +
//                    TaskContract.Columns.KEY_DATEMONTH + " = " + m + " AND " + TaskContract.Columns.KEY_DATEYEAR + " = " + y + " ORDER BY "
//                    + TaskContract.Columns.KEY_DATEDAY + " DESC;";
            Cursor c = db.rawQuery(q, null);
        Log.d("# of rows: ",String.valueOf(c.getCount()));
            c.moveToFirst();
        if (c.getCount() > 0)
        {
            do {
                String desc = c.getString(0);
                String type = c.getString(1);
                int year = Integer.parseInt(c.getString(3));
                int month = Integer.parseInt(c.getString(4));
                int day = Integer.parseInt(c.getString(5));
                int imp = Integer.parseInt(c.getString(6));
                Tasks task = new Tasks(desc, type, year, month, day, imp);
                t.add(task);
            } while (c.moveToNext());
            return t;
        }
        else
        {
            return null;
        }
    }

}

