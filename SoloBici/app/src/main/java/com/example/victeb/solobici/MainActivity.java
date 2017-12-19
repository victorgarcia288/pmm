package com.example.victeb.solobici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bJuego;
    private Button bPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bJuego = (Button) findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new OnclickListener(){
            public void onClick(View view){
                lanzarJuego();
            }
                                  });

        bPreferencias = (Button) findViewById(R.id.Boton02);



    }

    void lanzarJuego(){
        Intent miIntent = new Intent(MainActivity.this, Juego.class)
    }
}
