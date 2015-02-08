

/**
 * Created by Sahil on 2/7/2015.
 * Creates the stuff we need for DBs
 */
package db; // Make sure this matches your apps package

        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.provider.BaseColumns;
        import android.util.Log;

        import java.util.Calendar;


public class TaskContract {
    public static final String DB_NAME = "com.teamnewb.sahil.db.tasks";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "tasks";



    public static class Columns {
        public static final String KEY_TASKDESC = "com.teamnewb.sahil.TaskContract.TASKDESC";
        public static final String KEY_DATEMONTH = "com.teamnewb.sahil.TaskContract.MONTH";
        public static final String KEY_DATEDAY = "com.teamnewb.sahil.TaskContract.DAY";
        public static final String KEY_DATEYEAR = "com.teamnewb.sahil.TaskContract.YEAR";
        public static final String KEY_TASKTYPE = "com.teamnewb.sahil.TaskContract.TYPE";
        public static final String KEY_IMP = "com.teamnewb.sahil.TaskContract.IMP";

        //Variables used to transfer/store data
        public String description;
        public String type; //note if completed task store as COMPLETEDTASK
        public int year;
        public int month;
        public int day;
        public int im; //0 = not important, else 1

        public Columns(String d, String t, int i) {
            description = d;
            type = t;
            im = i;
            Calendar cal = Calendar.getInstance();
            year = cal.get(Calendar.YEAR);
            day = cal.get(Calendar.DAY_OF_MONTH);
            month = Calendar.MONTH;
        }

    }

}