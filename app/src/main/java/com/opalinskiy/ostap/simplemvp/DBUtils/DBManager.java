package com.opalinskiy.ostap.simplemvp.DBUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.opalinskiy.ostap.simplemvp.DBUtils.DBHelper;
import com.opalinskiy.ostap.simplemvp.model.User;

/**
 * Created by Evronot on 07.06.2016.
 */
public class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        this.dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void writeUserToDb(User user) {
        ContentValues cv = new ContentValues();
        cv.put(dbHelper.KEY_NAME, user.getName());
        cv.put(dbHelper.KEY_EMAIL, user.getEmail());
        database.insert(dbHelper.TABLE_NAME, null, cv);
        Toast.makeText(context, "User saved!", Toast.LENGTH_SHORT).show();
    }

    public User findUserById(String id) {
        Cursor cursor = database.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME + " WHERE "
                + dbHelper.KEY_ID + " = '" + id + "'", null);
        if (cursor != null && cursor.moveToFirst()) {
            User user = new User();
            user.setName(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            return user;
        }
        cursor.close();
        return null;
    }

    public void closeDatabase() {
        if (database != null) {
            database.close();
        }
    }
}
