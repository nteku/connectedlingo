package com.maid.connectedlingo;
import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class AccountHandler extends DatabaseHelper{
    public AccountHandler(Context context) {
        super(context);
    }



    /*
    public ArrayList<Account> readAccounts(){

        ArrayList<Account> accounts = new ArrayList<>();
        String query = "SELECT * from Account BY id ASC";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst())
        do
        {
            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String emailAddress = cursor.getString(cursor.getColumnIndex("emailAddress"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            Account account = new Account(username,emailAddress,password);
            accounts.add(account);
        }while(cursor.moveToNext());

        cursor.close();
        db.close();

        return accounts;
    }


    public Account readingSingleAccount(int id)
    {
        Account account;
        String query = "SELECT * FROM Account WHERE id =" + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst())
        {
            int accountID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String
        }
    }

     */
}
