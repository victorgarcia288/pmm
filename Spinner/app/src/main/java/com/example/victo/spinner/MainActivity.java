package com.example.victo.spinner;

import android.app.Activity;
import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Mueble[] muebles = new Mueble[]{
            new Mueble("cama", 150),
            new Mueble("estanteria", 70),
            new Mueble("lampara", 60)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner miSpiner = (Spinner) findViewById(R.id.spinnermueble);
        AdaptadorMueble miAdaptador = new AdaptadorMueble(this);
        miSpiner.setAdapter(miAdaptador);

        miSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String mensaje = "";
                mensaje = "Item clicked =>" + muebles[position];
                showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    class AdaptadorMueble extends ArrayAdapter<Mueble> {

        Activity a;

        AdaptadorMueble(Activity b) {
            super(b, R.layout.spinner_layout);
            this.a = b;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent),
            return vistaDesplegada;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = a.getLayoutInflater();
            View item = inflater.inflate(R.layout.spinner_layout, null);


            TextView lblNombre = (TextView) item.findViewById(R.id.nombre);
            lblNombre.setText(muebles[position].getNombre());


            TextView lblPrecio = (TextView) item.findViewById(R.id.precio);
            lblPrecio.setText(muebles[position].getPrecio());

            return item;
        }
    }
}
