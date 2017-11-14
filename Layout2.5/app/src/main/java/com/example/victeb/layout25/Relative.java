package com.example.victeb.layout25;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Relative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        final Button botonPrueba = (Button) findViewById(R.id.botonPrueba);
        final TextView etiquetaPrueba = (TextView) findViewById(R.id.etiquetaPrueba);

        botonPrueba.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                etiquetaPrueba.setText("Hola");

            }
        });
    }
}
