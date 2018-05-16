package vn.com.dtsgroup.look_up_information_android.Class;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;

import vn.com.dtsgroup.look_up_information_android.Init.VLDxxxModule;

/*******************************
 *                             *
 * Created by: VinhLD 20180510 *
 *                             *
 *******************************/

public class Student {

    public static String TABLENAME = "Student";

    public static String COLUMN_ID = "id";
    public static String COLUMN_CODE = "code";
    public static String COLUMN_NAME = "name";
    public static String COLUMN_CLASS = "_class";
    public static String COLUMN_ID_DEPARTMENT = "id_department";
    public static String COLUMN_BRANCH_GROUP = "branch_group";
    public static String COLUMN_BRANCH = "branch";
    public static String COLUMN_STATUS = "status";
    public static String COLUMN_DAY_ADMISSION = "day_admission";
    public static String COLUMN_SCHOOL_YEAR = "school_year";
    public static String COLUMN_COURSE = "course";
    public static String COLUMN_EDUCATION_LEVEL = "education_level";
    public static String COLUMN_GENDER = "gender";
    public static String COLUMN_TYPE_EDUCATION = "type_education";
    public static String COLUMN_AREA = "area";
    public static String COLUMN_AVERAGE_CUMULATIVE = "average_cumulative";
    public static String COLUMN_TOTAL_TERM = "total_term";
    public static String COLUMN_CREATE_AT = "created_at";
    public static String COLUMN_UPDATED_AT = "updated_at";

    public static String[] COLUMNS = {COLUMN_ID, COLUMN_CODE, COLUMN_NAME, COLUMN_CLASS, COLUMN_ID_DEPARTMENT,
            COLUMN_BRANCH_GROUP, COLUMN_BRANCH, COLUMN_STATUS, COLUMN_DAY_ADMISSION, COLUMN_SCHOOL_YEAR,
            COLUMN_COURSE, COLUMN_EDUCATION_LEVEL, COLUMN_GENDER, COLUMN_TYPE_EDUCATION, COLUMN_AREA,
            COLUMN_AVERAGE_CUMULATIVE, COLUMN_TOTAL_TERM, COLUMN_CREATE_AT, COLUMN_UPDATED_AT};

    public static String SQLSTRINGCREATETABLE = "CREATE TABLE " + TABLENAME + "(" +
            COLUMN_ID + " integer PRIMARY KEY, " +
            COLUMN_CODE + " TEXT UNIQUE, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_CLASS + " TEXT, " +
            COLUMN_ID_DEPARTMENT + " integer, " +
            COLUMN_BRANCH_GROUP + " TEXT, " +
            COLUMN_BRANCH + " TEXT, " +
            COLUMN_STATUS + " TEXT, " +
            COLUMN_DAY_ADMISSION + " TEXT, " +
            COLUMN_SCHOOL_YEAR + " TEXT, " +
            COLUMN_COURSE + " integer, " +
            COLUMN_EDUCATION_LEVEL + " TEXT, " +
            COLUMN_GENDER + " TEXT, " +
            COLUMN_TYPE_EDUCATION + " TEXT, " +
            COLUMN_AREA + " integer, " +
            COLUMN_AVERAGE_CUMULATIVE + " TEXT, " +
            COLUMN_TOTAL_TERM + " integer, " +
            COLUMN_CREATE_AT + " TEXT, " +
            COLUMN_UPDATED_AT + " TEXT)";

    public String updateToDB() {
        return "UPDATE " + TABLENAME + " SET "
                + COLUMN_ID + " = " + id + ", " + COLUMN_CODE + " = '" + code + "', " + COLUMN_NAME + " = '" + name + "', "
                + COLUMN_CLASS + " = '" + _class + "', " + COLUMN_ID_DEPARTMENT + " = " + id_department + ", "
                + COLUMN_BRANCH_GROUP + " = '" + branch_group + "', " + COLUMN_BRANCH + " = '" + branch + "', "
                + COLUMN_STATUS + " = '" + status + "', " + COLUMN_DAY_ADMISSION + " = '" + day_admission + "', "
                + COLUMN_SCHOOL_YEAR + " = '" + school_year + "', " + COLUMN_COURSE + " = " + course + ", "
                + COLUMN_EDUCATION_LEVEL + " = '" + education_level + "', " + COLUMN_GENDER + " = '" + gender + "', "
                + COLUMN_TYPE_EDUCATION + " = '" + type_education + "', " + COLUMN_AREA + " = " + area + ", "
                + COLUMN_AVERAGE_CUMULATIVE + " = '" + average_cumulative + "', " + COLUMN_TOTAL_TERM + " = " + total_term + ", "
                + COLUMN_CREATE_AT + " = '" + created_at + "', " + COLUMN_UPDATED_AT + " = '" + updated_at
                + "' WHERE " + COLUMN_ID + " = " + id;
    }

    public ContentValues values() {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, getId());
        values.put(COLUMN_CODE, getCode());
        values.put(COLUMN_NAME, getName());
        values.put(COLUMN_CLASS, get_class());
        values.put(COLUMN_ID_DEPARTMENT, getId_department());
        values.put(COLUMN_BRANCH_GROUP, getBranch_group());
        values.put(COLUMN_BRANCH, getBranch());
        values.put(COLUMN_STATUS, getStatus());
        values.put(COLUMN_DAY_ADMISSION, getDay_admission());
        values.put(COLUMN_SCHOOL_YEAR, getSchool_year());
        values.put(COLUMN_COURSE, getCourse());
        values.put(COLUMN_EDUCATION_LEVEL, getEducation_level());
        values.put(COLUMN_GENDER, getGender());
        values.put(COLUMN_TYPE_EDUCATION, getType_education());
        values.put(COLUMN_AREA, getArea());
        values.put(COLUMN_AVERAGE_CUMULATIVE, getAverage_cumulative());
        values.put(COLUMN_TOTAL_TERM, getTotal_term());
        values.put(COLUMN_CREATE_AT, getCreated_at());
        values.put(COLUMN_UPDATED_AT, getUpdated_at());
        return values;
    }

    private int id, id_department, course, area, total_term;
    private String code, name, _class, branch_group, branch, status, day_admission,
            school_year, education_level, gender, type_education, average_cumulative;
    private String created_at, updated_at;

    public Student(int id, String code, String name, String _class, int id_department, String branch_group,
                   String branch, String status, String day_admission, String school_year, int course,
                   String education_level, String gender, String type_education, int area,
                   String average_cumulative, int total_term, String created_at, String updated_at) {
        this.id = id;
        this.id_department = id_department;
        this.course = course;
        this.area = area;
        this.total_term = total_term;
        this.code = code;
        this.name = name;
        this._class = _class;
        this.branch_group = branch_group;
        this.branch = branch;
        this.status = status;
        this.day_admission = day_admission;
        this.school_year = school_year;
        this.education_level = education_level;
        this.gender = gender;
        this.type_education = type_education;
        this.average_cumulative = average_cumulative;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Student(Cursor cursor) {
        cursor.moveToFirst();
        this.id = cursor.getInt(0);
        this.code = cursor.getString(1);
        this.name = cursor.getString(2);
        this._class = cursor.getString(3);
        this.id_department = cursor.getInt(4);
        this.branch_group = cursor.getString(5);
        this.branch = cursor.getString(6);
        this.status = cursor.getString(7);
        this.day_admission = cursor.getString(8);
        this.school_year = cursor.getString(9);
        this.course = cursor.getInt(10);
        this.education_level = cursor.getString(11);
        this.gender = cursor.getString(12);
        this.type_education = cursor.getString(13);
        this.area = cursor.getInt(14);
        this.average_cumulative = cursor.getString(15);
        this.total_term = cursor.getInt(16);
        this.created_at = cursor.getString(17);
        this.updated_at = cursor.getString(18);
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getTotal_term() {
        return total_term;
    }

    public void setTotal_term(int total_term) {
        this.total_term = total_term;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getBranch_group() {
        return branch_group;
    }

    public void setBranch_group(String branch_group) {
        this.branch_group = branch_group;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDay_admission() {
        return day_admission;
    }

    public void setDay_admission(String day_admission) {
        this.day_admission = day_admission;
    }

    public String getSchool_year() {
        return school_year;
    }

    public void setSchool_year(String school_year) {
        this.school_year = school_year;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType_education() {
        return type_education;
    }

    public void setType_education(String type_education) {
        this.type_education = type_education;
    }

    public String getAverage_cumulative() {
        return average_cumulative;
    }

    public void setAverage_cumulative(String average_cumulative) {
        this.average_cumulative = average_cumulative;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
