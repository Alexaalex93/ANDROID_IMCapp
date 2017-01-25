package com.example.alex.imcapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 23/01/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private static final String sqlCreacionTablaUsuario = "CREATE TABLE USERTABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT , pass TEXT)";
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
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO USERTABLE (email, pass) VALUES ('" + credentials.getmEmail() + "' , '" + credentials.getmPassword() + "')");

            //db.execSQL("INSERT INTO USERTABLE (email, pass) VALUES ('" + email + "' , '" + password + "')");
            cerrarDataBase(db);
            Log.d(getClass().getCanonicalName(),"Tabla creada");

        }catch (Throwable throwable){
            Log.d(getClass().getCanonicalName(),"Falla al añadir", throwable);
        }
    }

    public int findUser (String email, String password){

        String consulta = "SELECT email, pass FROM USERTABLE WHERE email = '" + email + "'"; //Si consultas tambien contraseña y te devuelve es que existe
        //String consulta = "SELECT * FROM CREDENTIALS";
        //Quiero comprobar si el email que le paso existe en la base de datos

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(consulta, null);
        int exists = -1;

        Log.d(getClass().getCanonicalName(), "Me meto a comparar");
           if(cursor != null && cursor.moveToFirst()) {
               Log.d(getClass().getCanonicalName(), "Encuentro " + cursor.getString(0));
               Log.d(getClass().getCanonicalName(), "Comparo " + cursor.getString(0) + " con " + email +" y " + cursor.getString(1)+ " con " + password);
                //Aquí ya he encontrado usuario y compruebo contraseña
               exists = 0;
               //Solo comparo las contraseñas ya que solo lo hará si ha encontrado un email igual
               if (cursor.getString(1).equals(password)) {
                   exists = 1;
               }
           }
        cerrarDataBase(db);

        cursor.close();

        return exists;
    }


}
