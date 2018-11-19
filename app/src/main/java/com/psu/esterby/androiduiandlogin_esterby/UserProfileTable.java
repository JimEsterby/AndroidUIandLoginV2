package com.psu.esterby.androiduiandlogin_esterby;

// class methods return SQLite commands
public class UserProfileTable {

    public static final String DB_NAME = "UserProfile";
    public static final String INDEX_ID = "index_id";  // cannot use "index", must be keyword for SQL command language

    // Database fields:
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USER_NAME = "user_name";
    public static final String BIRTHDAY = "birthday";  // optional
    public static final String MOBILE = "mobile";  // (phone) optional
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PASS = "password";

    public static final String TAG = "UserProfileTable";  // logging needed?

    // return SQL command for creating the table
    public static String create() {
        return new String ("CREATE TABLE " + DB_NAME + " (" +
        INDEX_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        FIRST_NAME + " TEXT, " +
        LAST_NAME + " TEXT, " +
        USER_NAME + " TEXT, " +
        BIRTHDAY + " TEXT, " +
        MOBILE + " TEXT, " +
        FIELD_EMAIL + " TEXT, " +
        FIELD_PASS + " TEXT)");
    }

    public static String select() {
        return new String("SELECT * FROM " + DB_NAME);
    }

    public static final String delete() {
        return "DROP TABLE IF EXISTS " + DB_NAME;
    }
}
