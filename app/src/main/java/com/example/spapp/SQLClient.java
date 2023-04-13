package com.example.spapp;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SQLClient extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;
    private static final String  DATABASE_NAME = "formulaire.db";
    private static final String TABLE_NOM = "sauveurs";
    private static final String COL_PRENOM = "prenom";
    private static final String COL_TELEPHONE = "telephone";
    private static final String COL_ANIMAL = "animal";
    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NOM + "("
            + COL_PRENOM + " TEXT,"
            + COL_TELEPHONE + " TEXT,"
            + COL_ANIMAL + " TEXT" + ")";
    public static final String SQL_DELETE = "DROP TABLE IF EXISTS " + TABLE_NOM;

    public SQLClient(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLClient.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLClient.SQL_DELETE);
        this.onCreate(db);
    }

    public void insererDonnees(String prenom, String telephone, String animal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_PRENOM, prenom);
        values.put(COL_TELEPHONE, telephone);
        values.put(COL_ANIMAL, animal);

        db.insert(TABLE_NOM, null, values);
        db.close();
    }

    public ArrayList<String> getDonnees() {
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<String> dataList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NOM, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String prenom = cursor.getString(cursor.getColumnIndex(COL_PRENOM));
                @SuppressLint("Range") String telephone = cursor.getString(cursor.getColumnIndex(COL_TELEPHONE));
                @SuppressLint("Range") String animal = cursor.getString(cursor.getColumnIndex(COL_ANIMAL));

                String data = prenom + " - " + telephone + " - " + animal;
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dataList;
    }
}