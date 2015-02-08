

/**
 * Created by Sahil on 2/7/2015.
 * Creates the stuff we need for DBs
 */
package db; // Make sure this matches your apps package

        import android.provider.BaseColumns;

        import java.util.Calendar;

public class TaskContract {
    public static final String DB_NAME = "com.teamnewb.sahil.db.tasks";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "tasks";



    public static class Columns {
        public static final String TASKDESC = "taskdesc"; //TODO: get task description input here and other inputs as well
        public static final String DATEMONTH = "month";
        public static final String DATEDAY = "day";
        public static final String DATEYEAR = "year";
        public static final String TASKTYPE = "tasktype";
        public static final String IMP = "imp";

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