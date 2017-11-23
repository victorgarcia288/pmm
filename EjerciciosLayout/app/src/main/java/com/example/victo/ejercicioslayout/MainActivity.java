package com.example.victo.ejercicioslayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button miBoton= (Button)findViewById(R.id.miBtn);
        final Button miBoton2= (Button)findViewById(R.id.miBtn2);
        final Button miBoton3= (Button)findViewById(R.id.miBtn3);
        final Button miBoton4= (Button)findViewById(R.id.miBtn4);



        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, RadiobuttonsColores.class);
                startActivity(miIntent);
            }
        });

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent2 = new Intent(MainActivity.this, ButtonsColores.class);
                startActivity(miIntent2);
            }
        });

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent3 = new Intent(MainActivity.this, ButtonsColores.class);
                startActivity(miIntent3);
            }
        });

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent4 = new Intent(MainActivity.this, ButtonsColores.class);
                startActivity(miIntent4);
            }
        });
    }
}
