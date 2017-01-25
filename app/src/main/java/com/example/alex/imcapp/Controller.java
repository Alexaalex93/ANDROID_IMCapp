package com.example.alex.imcapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Alex on 08/01/2017.
 */

public class Controller  implements View.OnClickListener   {

    private Context _contexto; //La ventana que está escuchando

    public Controller (Context contexto){
        this._contexto = contexto;
    }

    @Override
    public void onClick(View v) {
        int selection = v.getId();
        switch (selection){
            case R.id.calculateButton:

                toActivity2();
                //Podrias hacer un casting a MainActivity para que quede mas claro
                break;
            case R.id.informationButton:

                toInformationActivity();

                break;
            }
    }

    void toActivity2(){

        Activity activity1 = (Activity) this._contexto;
        EditText weightText = (EditText) activity1.findViewById(R.id.weightText);
        EditText heightText = (EditText) activity1.findViewById(R.id.heightText);

        if(weightText.getText().toString().trim().length() != 0 && heightText.getText().toString().trim().length() != 0) {
            Intent toResultsLayout = new Intent(this._contexto, ValueActivity.class);
            toResultsLayout.putExtra("PESO", weightText.getText().toString());
            toResultsLayout.putExtra("ALTURA", heightText.getText().toString());
            activity1.startActivity(toResultsLayout);
        }
        else{ //Para mostrar un dialog de alerta
            AlertDialog.Builder builder = new AlertDialog.Builder(this._contexto);
            builder.setMessage("Por favor, introduce los datos requeridos")
                    .setTitle("Información")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }

                    });
            builder.create();
            builder.show();


        }


    }
    void toInformationActivity(){
        Activity activity = (Activity) this._contexto;
        Intent toInformationLayout = new Intent(this._contexto, InformationActivity.class);
        activity.startActivity(toInformationLayout);

    }



}
