package com.example.victeb.preferencias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Preferencias extends AppCompatActivity {
    private Button btnPreferencias;
    private Button btnObtenerPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        btnPreferencias = (Button) findViewById(R.id.BtnPreferencias);
        btnObtenerPreferencias = (Button) findViewById(R.id.BtnobtenerPreferencias);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Preferencias.this,
                        PantallaOpciones.class));
            }
        });

        btnObtenerPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Preferencias.this,
                        PantallaOpciones.class));
            }
        });
    }
}
