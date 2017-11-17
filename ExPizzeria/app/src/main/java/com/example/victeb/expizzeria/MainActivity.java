package com.example.victeb.expizzeria;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String nombre, descripcion, precio;

    Coste[] coste = {
            new Coste("Margarita", "jamon/tomate", 12, R.drawable.pizza1),
            new Coste("Tres Quesos", "queso1/queso2", 15, R.drawable.pizza2),
            new Coste("Barbacoa", "carne/tomate", 12, R.drawable.pizza3)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double calcularPrecioTotal(int grande, double ingredienteExtra, double extradequeso) {
        double precioTotal = precioPe(peso);
        switch (zona) {
            case 0: precioTotal += 30;
                break;
            case 1: precioTotal += 20;
                break;
            case 2: precioTotal += 10;
                break;
        }
        if (tarifa) {
            return precioTotal + (precioTotal * 0.3);
        } else {
            return precioTotal;
        }
    }

    public double extraqueso(double extraqueso) {

    }
}


}

class AdaptadorDestino extends ArrayAdapter<Coste> {

    Activity a;
    AdaptadorDestino(Activity b) {
        super(b, R.layout.spinnerlayaut,  coste);
        this.a = b;
    }

    public View getDropDownView (int position, View convertView, ViewGroup parent){
        return getView (position, convertView, parent);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = a.getLayoutInflater();
        View item = inflater.inflate(R.layout.spinnerlayaut, null);

        final TextView zonaSpinner = (TextView)item.findViewById(R.id.nombre);
        zonaSpinner.setText(coste[position].getNombre());

        final TextView continenteSpinner = (TextView)item.findViewById(R.id.descripcion);
        continenteSpinner.setText(coste[position].getDescripción());

        final TextView precioSpinner = (TextView)item.findViewById(R.id.precio);
        precioSpinner.setText(Double.toString(coste[position].getPrecio()));

        return(item);
    }
}
