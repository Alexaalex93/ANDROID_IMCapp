package com.example.alex.imcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ValueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Controller controller = new Controller(this);

        Bundle extras = getIntent().getExtras();
        int a = Integer.parseInt(extras.getString("PESO"));
        double b = Double.parseDouble(extras.getString("ALTURA"))/100;

        double imc = (a/(b*b)) * 100;
        int imcint = (int) imc ;
        double imcdou = (double) imcint / 100;

        TextView imcText = (TextView) findViewById(R.id.imcText);


        imcText.setText(Double.toString(imcdou) );

        Button informacion = (Button) findViewById(R.id.informationButton);
        informacion.setOnClickListener(controller);


    }
}
