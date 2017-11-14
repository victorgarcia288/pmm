package com.example.victeb.layout25;

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
        final Button miBoton5= (Button)findViewById(R.id.miBtn5);
        final Button miBoton6= (Button)findViewById(R.id.miBtn6);
        final Button miBoton7 = (Button)findViewById(R.id.miBtn7);


        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Lineal.class);
                startActivity(miIntent);
            }
        });

        miBoton2.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent2= new Intent(MainActivity.this, Table.class);
                startActivity(miIntent2);
            }
        });

        miBoton3.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent3= new Intent(MainActivity.this, Relative.class);
                startActivity(miIntent3);
            }
        });

        miBoton4.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent4= new Intent(MainActivity.this, Grid.class);
                startActivity(miIntent4);
            }
        });

        miBoton5.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent5= new Intent(MainActivity.this, Checkbox.class);
                startActivity(miIntent5);
            }
        });

        miBoton6.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent6= new Intent(MainActivity.this, Radiobutton.class);
                startActivity(miIntent6);
            }
        });

        miBoton7.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent7= new Intent(MainActivity.this, Butttons.class);
                startActivity(miIntent7);
            }
        });
    }

}

