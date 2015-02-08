package db;

/**
 * Created by Sahil on 2/7/2015.
 *
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TaskDBHelper extends SQLiteOpenHelper {

    public TaskDBHelper(Context context) {
        super(context, TaskContract.DB_NAME, null, TaskContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        String sqlQuery ="CREATE TABLE " + TaskContract.TABLE + "(" + TaskContract.Columns.TASKDESC + "TEXT, "
                        + TaskContract.Columns.TASKTYPE + "TEXT, " + TaskContract.Columns.DATEYEAR + "INTEGER, " +
                        TaskContract.Columns.DATEMONTH + "INTEGER, " + TaskContract.Columns.DATEDAY + "INTEGER, "
                        + TaskContract.Columns.IMP + "INTEGER )";


        Log.d("TaskDBHelper", "Query to form table: " + sqlQuery);
        sqlDB.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
        sqlDB.execSQL("DROP TABLE IF EXISTS " + TaskContract.TABLE);
        onCreate(sqlDB);
    }
}