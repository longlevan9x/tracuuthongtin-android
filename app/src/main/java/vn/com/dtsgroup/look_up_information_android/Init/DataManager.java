package vn.com.dtsgroup.look_up_information_android.Init;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

import vn.com.dtsgroup.look_up_information_android.Adapter.StudentAdapter;
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

    public String FacultyName(int id) {
        return "Khoa Công nghệ Thông tin HN";
    }

    public boolean insertOrUpdateArea(Area area) {
        if (updateArea(area) != 0)
            return true;
        else if (insertArea(area) != -1)
            return true;
        return false;
    }

    public long insertArea(Area area) {
        return database.insert(Area.TABLENAME, null, area.values());
    }

    public long updateArea(Area area) {
        return database.update(Area.TABLENAME, area.values(), Area.COLUMN_CODE + " = '" + area.getCode() + "'", null);
    }

    public void createTableStudent() {
        database.execSQL(Student.SQLSTRINGCREATETABLE);
    }

    public Area getAreaByCode(int code) {
        Cursor cursor = database.query(Area.TABLENAME, Area.COLUMNS, Area.COLUMN_CODE + " = '" + code + "'",
                null, null, null, null, null);
        Log.e("Area", String.valueOf(cursor.getCount()));
        if (cursor.getCount() == 0)
            return null;
        cursor.moveToFirst();
        Area area = new Area(cursor);
        cursor.close();
        return area;
    }

    public String AreaName(int code) {
        Area area = getAreaByCode(code);
        return area.getName();
    }

    public boolean insertOrUpdateStudent(Student student) {
        if (insertStudent(student) != -1 || updateStudent(student) != 0)
            return true;
        return false;
    }

    public long insertStudent(Student student) {
        return database.insert(Student.TABLENAME, null, student.values());
    }

    public int updateStudent(Student student) {
        return database.update(Student.TABLENAME, student.values(), Student.COLUMN_ID + " = '" + student.getId() + "'", null);
    }

    public Student getStudentbyCODE(String code) {
        Cursor cursor = database.query(Student.TABLENAME, Student.COLUMNS, Student.COLUMN_CODE + "=?",
                new String[]{code}, null, null, null, null);
        if (cursor.getCount() == 0)
            return null;
        cursor.moveToFirst();
        Student student = new Student(cursor);
        cursor.close();
        return student;
    }

    public ArrayList<StudentAdapter.VStudent> Students(String query) {
        ArrayList<StudentAdapter.VStudent> vstudents = new ArrayList<StudentAdapter.VStudent>();
        Cursor cursor = database.query(Student.TABLENAME, Student.COLUMNS, Student.COLUMN_CODE + " = '" + query + "' OR "
                        + Student.COLUMN_NAME + " = '" + query + "' OR " + Student.COLUMN_CLASS + " = '" + query + "'",
                null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int rank = 1;
            while (!cursor.isAfterLast()) {
                vstudents.add(new StudentAdapter.VStudent(rank, cursor));
                cursor.moveToNext();
                rank++;
            }
        }
        return vstudents;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }
}
