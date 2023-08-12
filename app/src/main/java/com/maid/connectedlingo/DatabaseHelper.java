package com.maid.connectedlingo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import java.lang.reflect.Type;
import java.util.List;

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


    public Cursor getAccount(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from Account", null);

        return cursor;
    }

    public boolean saveTranslation(String username,String emailAddress, String password, List<ProcessedTranslation> savedTranslations, String prevTranslations )
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        JSONArray jsonArray = new JSONArray(savedTranslations);

        contentValues.put("username",username);
        contentValues.put("emailAddress",emailAddress);
        contentValues.put("password",password);
        contentValues.put("savedTranslations", prevTranslations + getSavedTranslations(savedTranslations));

        Cursor cursor = db.rawQuery("Select * from Account where username = ?", new String []{username});

        if (cursor.getCount() > 0)
        {
            long result = db.update("Account", contentValues,"username=?",new String[] {username});
            if (result == -1){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }


    public String getSavedTranslations(List <ProcessedTranslation> savedTranslations) {

        String formattedString = "";

        if (savedTranslations == null)
        {
            return "";
        }
        for (ProcessedTranslation translation: savedTranslations)
        {
            formattedString += translation.toString();
        }

        return formattedString;
    }

    public String retrievePreviousTranslations(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select savedTranslations from Account where username = ?", new String []{username});

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append(res.getString(0));
        }

        Log.d("DS",buffer.toString());
        return buffer.toString();
    }

}
