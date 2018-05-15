package vn.com.dtsgroup.look_up_information_android.Init;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Locale;

import vn.com.dtsgroup.look_up_information_android.Class.Area;
import vn.com.dtsgroup.look_up_information_android.Class.Student;

/*******************************
 *                             *
 * Created by: VinhLD 20180514 *
 *                             *
 *******************************/

public class DataManager {

    public static String KEYENCODE = "LusTeam@2018";
    public static String DATABASENAME = VLDxxxModule.VLDEncodeMD5("LUS", KEYENCODE) + ".db";//436325800d795c4c95f3bc2a1afda37c.db

    private Context context;
    private SQLiteDatabase database;

    @SuppressLint("WrongConstant")
    public DataManager(Context context) {
        this.context = context;
        this.database = context.openOrCreateDatabase(DataManager.DATABASENAME, SQLiteDatabase.CREATE_IF_NECESSARY,
                null);
        createTable();
        insertOrUpdateArea(new Area(10, "Hà Nội"));
        insertOrUpdateArea(new Area(20, "Nam Định"));
    }

    public void createTable() {
        if (!isTableExists(Student.TABLENAME)) {
            createTableStudent();
        }
        if (!isTableExists(Area.TABLENAME)) {
            createTableArea();
        }
    }

    public boolean isTableExists(String tableName) {
        Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "'",
                null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

    public void createTableArea() {
        database.execSQL(Area.SQLSTRINGCREATETABLE);
    }

    public boolean insertOrUpdateArea(Area area) {
        if (updateArea(area) != 0)
            return true;
        else if (insertArea(area) != -1)
            return true;
        return false;
    }

    public long insertArea(Area area) {
        long l = database.insert(Area.TABLENAME, null, area.values());
        return l;
    }

    public long updateArea(Area area) {
        long l = database.update(Area.TABLENAME, area.values(), Area.COLUMN_CODE + "=?",
                new String[]{String.valueOf(area.getCode())});
        return l;
    }

    public void createTableStudent() {
        database.execSQL(Student.SQLSTRINGCREATETABLE);
    }

    public Area getAreaByCode(String code) {
        Cursor cursor = database.query(Area.TABLENAME, Area.COLUMNS, Area.COLUMN_CODE + "=?",
                new String[]{code}, null, null, null, null);
        Log.e("Area", String.valueOf(cursor.getCount()));
        if (cursor.getCount() == 0)
            return null;
        Area area = new Area(cursor);
        cursor.close();
        return area;
    }

    public boolean insertOrUpdateStudent(Student student) {
        if (updateStudent(student) != 0)
            return true;
        else if (insertStudent(student) != -1)
            return true;
        return false;
    }

    public long insertStudent(Student student) {
        long l = database.insert(Student.TABLENAME, null, student.values());
        return l;
    }

    public long updateStudent(Student student) {
        long l = database.update(Student.TABLENAME, student.values(), Student.COLUMN_ID + "=?",
                new String[]{String.valueOf(student.getId())});
        return l;
    }

    public Student getStudentbyCODE(String code) {
        Cursor cursor = database.query(Student.TABLENAME, Student.COLUMNS, Student.COLUMN_CODE + "=?",
                new String[]{code}, null, null, null, null);
        if (cursor.getCount() == 0)
            return null;
        Student student = new Student(cursor);
        cursor.close();
        return student;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }
}
