package com.example.alex.imcapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private static final String CLAVE_REGISTERED = "is_registered";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Controller controller = new Controller(this); //Objeto que escucha

        if(!loginchecker()) {
            Intent loginActivity = new Intent(this, LoginActivity.class);
            startActivity(loginActivity);
            //setContentView(R.layout.activity_login);

        }
        else {
            setContentView(R.layout.activity_main);

            Button calculatebtn = (Button) findViewById(R.id.calculateButton);
            calculatebtn.setOnClickListener(controller);
        }
    }

    Boolean loginchecker(){

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        return  sharedPreferences.getBoolean(CLAVE_REGISTERED, false);

    }

    void guardarClave(boolean logged){

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(CLAVE_REGISTERED, logged);
        editor.apply();

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();

    }
}
