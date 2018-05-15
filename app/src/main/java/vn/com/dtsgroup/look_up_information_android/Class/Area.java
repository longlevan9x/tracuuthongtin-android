package vn.com.dtsgroup.look_up_information_android.Class;

import android.content.ContentValues;
import android.database.Cursor;

/*******************************
 *                             *
 * Created by: VinhLD 20180515 *
 *                             *
 *******************************/

public class Area {

    public static String TABLENAME = "Area";

    public static String COLUMN_CODE = "code";
    public static String COLUMN_NAME = "name";

    public static String[] COLUMNS = {COLUMN_CODE, COLUMN_NAME};

    public static String SQLSTRINGCREATETABLE = "CREATE TABLE " + TABLENAME + "(" +
            COLUMN_CODE + " integer PRIMARY KEY," +
            COLUMN_NAME + " TEXT UNIQUE" +
            ")";

    public ContentValues values() {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CODE, getCode());
        values.put(COLUMN_NAME, getName());
        return values;
    }

    private int code;
    private String name;

    public Area(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Area(Cursor cursor) {
        cursor.moveToFirst();
        this.code = cursor.getInt(0);
        this.name = cursor.getString(1);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
