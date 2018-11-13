package com.psu.esterby.androiduiandlogin_esterby;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserProfilePersistence implements IPersistence {

    private DatabaseAccess dbAccess;

    public UserProfilePersistence(Context c) {
        dbAccess = new DatabaseAccess(c);
    }

    @Override
    public void insert(Object o) {
        // Cast the generic object to User Profile
        UserProfile up = (UserProfile)o;

        SQLiteDatabase theDB = dbAccess.getWritableDatabase();

        // The ContentValues object is used to create a map of values, where the fields are the keys
        ContentValues cv = new ContentValues();
        cv.put(UserProfileTable.FIRST_NAME, up.getFirstName());
        cv.put(UserProfileTable.LAST_NAME, up.getLastName());
        cv.put(UserProfileTable.USER_NAME, up.getUserName());
        cv.put(UserProfileTable.BIRTHDAY, up.getBirthday());
        cv.put(UserProfileTable.MOBILE, up.getPhone());
        cv.put(UserProfileTable.FIELD_EMAIL, up.getEmailAddress());
        cv.put(UserProfileTable.FIELD_PASS, up.getPassword());

        // Insert the profile into the database and close it
        theDB.insert(UserProfileTable.DB_NAME, null, cv);
        theDB.close();
    }

    @Override
    public void delete(Object o) {
        // do nothing
    }

    @Override
    public void edit(Object o) {
        // do nothing
    }

    @Override
    public ArrayList getDataFromDB() {
        // Create ArrayList of user profiles
        ArrayList<UserProfile> profiles = null;

        // Instantiate the database
        SQLiteDatabase theDB = dbAccess.getWritableDatabase();

        // Gather all the records found in the user profile database
        Cursor cursor = theDB.rawQuery(UserProfileTable.select(), null);

        // Iterate through the database
        cursor.moveToFirst();

        profiles = new ArrayList<>();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(UserProfileTable.FIRST_NAME));
                String lastname = cursor.getString(cursor.getColumnIndex(UserProfileTable.LAST_NAME));
                String username = cursor.getString(cursor.getColumnIndex(UserProfileTable.USER_NAME));
                String birthday = cursor.getString(cursor.getColumnIndex(UserProfileTable.BIRTHDAY));
                String phone = cursor.getString(cursor.getColumnIndex(UserProfileTable.MOBILE));
                String email = cursor.getString(cursor.getColumnIndex(UserProfileTable.FIELD_EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(UserProfileTable.FIELD_PASS));

                UserProfile userProfile = new UserProfile(name, lastname, username, phone, email, password, birthday);
                profiles.add(userProfile);

            } while (cursor.moveToNext()) ;
        }

        return profiles;
    }
}
