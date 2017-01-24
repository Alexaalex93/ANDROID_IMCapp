package com.example.alex.imcapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 23/01/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private static final String sqlCreacionTablaUsuario = "CREATE TABLE USER(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT PRIMARY KEY, password TEXT)";
    //Primary key obligatorio!!!

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

    public void addCredentials (Credentials credentials){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO USER (email, password) VALUES ('" + credentials.getmEmail() + "' , '" + credentials.getmPassword() + "')");
        cerrarDataBase(db);

    }

    public boolean findUser (Credentials credentials){

        String consulta = "SELECT email FROM USER WHERE email = '" + credentials.getmEmail() + "'"; //Si consultas tambien contraseña y te devuelve es que existe
        //Quiero comprobar si el email que le paso existe en la base de datos

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(consulta, null);


         if(cursor.getString(0) == credentials.getmEmail())
             return true;
         return false;

    }

}
