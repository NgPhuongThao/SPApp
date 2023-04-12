package com.example.spapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLClient extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 5;
    public static final String  DATABASE_FILE = "formulaire.db";
    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS Formulaire " +
            "(id INTEGER PRIMARY KEY, " +
            "prenom TEXT, " +
            "telephone INTEGER, " +
            "animal TEXT);";
    public static final String SQL_DELETE = "DROP TABLE IF EXISTS Formulaire ;";

    public SQLClient(Context context){
        super (context, DATABASE_FILE, null, DATABASE_VERSION);
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
}