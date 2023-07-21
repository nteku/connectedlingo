package com.maid.connectedlingo;
import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class AccountHandler extends DatabaseHelper{
    public AccountHandler(Context context) {
        super(context);
    }


    public boolean create (Account account){
        ContentValues values = new ContentValues();
        values.put("username", account.getUsername());
        values.put("emailAddress", account.getEmailAddress());
        values.put("password",account.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();
        boolean isSucessful = db.insert("Account",null,values) > 0;
        db.close();

        return isSucessful;
    }

    public ArrayList<Account> readAccounts(){
        String query = "SELECT * from Account BY id ASC";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);
    }
}
