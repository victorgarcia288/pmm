package com.example.victeb.spinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
    }
}

public class AdaptadorMueble extends ArrayAdapter<Mueble>{

    Activity a;
    AdaptadorMueble(Activity b){
        super(b,R.layout.spinner_layout);
        this.a = b;

    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        View vistaDesplegada = getView(position, convertView, parent),
                return vistaDesplegada;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = a.getLayoutInflater();
        View item = inflater.inflate(R.layout.spinner_layout, null);
    }
}



