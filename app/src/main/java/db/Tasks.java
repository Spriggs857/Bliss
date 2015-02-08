package db;

/**
 * Created by Sahil on 2/7/2015.
 */
public class Tasks {

    public int day, month, year, imp;
    public String desc, type;

    public Tasks(int d, int m, int y, int i, String de, String t)
    {
        day = d;
        month = m;
        year = y;
        imp = i;
        desc = de;
        type = t;
    }

    public int getDay()
    {
        return day;
    }
    public int getMonth()
    {
        return month;
    }
    public int getYear()
    {
        return year;
    }
    public int getImp()
    {
        return imp;
    }
    public String getDesc()
    {
        return desc;
    }
    public String getType()
    {
        return type;
    }
}
