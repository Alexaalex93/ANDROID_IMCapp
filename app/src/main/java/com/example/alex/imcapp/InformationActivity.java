package com.example.alex.imcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        String[] arrayRatio = new String[]{
                "<16.00",
                "16.00 - 16.99",
                "17.00 - 18.49",
                "18.50 - 24.99",
                "25.00 - 29.99",
                "30.00 - 34.99",
                "35.00 - 40.00",
                ">40.00"
        };

        String[] arrayClasificacion = new String[]{
                "Infrapeso: Delgadez severa",
                "Infrapeso: Delgadez moderada",
                "Infrapeso: Delgadez aceptable",
                "Peso normal",
                "Sobrepeso",
                "Obeso: Tipo I",
                "Obeso: Tipo II",
                "Obeso: Tipo III"
        };

        //Creamos el Adapter
        ListAdapter adapter = new Adapter(this, arrayClasificacion, arrayRatio, R.layout.fila);

        //Asociamos el adapter a la vista
        ListView listView = (ListView) findViewById(R.id.tabla_info);
        listView.setAdapter(adapter);
    }
}
