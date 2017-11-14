package com.example.victeb.menucontextual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos las referencias a los controles
        lblMensaje = (TextView)findViewById(R.id.LblMensaje);
//Asociamos los menús contextuales a los controles
        registerForContextMenu(lblMensaje);
    }
}
