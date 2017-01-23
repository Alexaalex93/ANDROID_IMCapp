package com.example.alex.imcapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alex on 23/01/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private static final String sqlCreacionTablaUsuario = "CREATE TABLE USER(id TEXT PRIMARY KEY, password TEXT)";

    public  BaseDatos(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){

        super(context, nombre, factory, version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreacionTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void cerrarDataBase(SQLiteDatabase db){ db.close();}

}
