package com.maid.connectedlingo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "TranslatorDatabase.db";
    public DatabaseHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE Account (id INTEGER PRIMARY KEY AUTOINCREMENT, emailAddress TEXT, username TEXT, password TEXT, savedTranslations TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS Account";
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public boolean create (Account account) {

        ContentValues values = new ContentValues();
        values.put("username", account.getUsername());
        values.put("emailAddress", account.getEmailAddress());
        values.put("password", account.getPassword());
        values.put("savedtranslations", " ");

        SQLiteDatabase db = this.getWritableDatabase();
        long isSucessful = db.insert("Account", null, values);
        if (isSucessful == -1) {
            return false;
        }

        return true;
    }


    public Cursor getAccount(String emailAddress){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from Account WHERE emai")
    }


}
