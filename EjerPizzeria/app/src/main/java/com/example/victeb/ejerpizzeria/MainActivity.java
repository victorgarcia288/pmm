package com.example.victeb.ejerpizzeria;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Pizza[] pizza = {
            new Pizza("Margarita", "jamon/tomate", 12, R.drawable.pizza1),
            new Pizza("Tres Quesos", "queso1/queso2", 15, R.drawable.pizza2),
            new Pizza("Barbacoa", "carne/tomate", 12, R.drawable.pizza3)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}

class AdaptadorPizza extends ArrayAdapter<Pizza> {
    Pizza[] pizza;

    Activity a;
    AdaptadorPizza(Activity b, Pizza[] pizza) {
        super(b, R.layout.activity_spinner,  pizza);
        this.a = b;
        this.pizza = pizza;
    }

    public View getDropDownView (int position, View convertView, ViewGroup parent){
        return getView (position, convertView, parent);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = a.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_spinner, null);

        final TextView zonaSpinner = (TextView)item.findViewById(R.id.nombre);
        zonaSpinner.setText(pizza[position].getNombre());

        final TextView continenteSpinner = (TextView)item.findViewById(R.id.descripcion);
        continenteSpinner.setText(pizza[position].getDescripción());

        final TextView precioSpinner = (TextView)item.findViewById(R.id.precio);
        precioSpinner.setText(Double.toString(pizza[position].getPrecio()));

        return(item);
    }
}
