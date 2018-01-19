package com.example.victo.ejerciciopizzeria;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Actividad1 extends AppCompatActivity {
    static class ViewHolderPizzas {
        TextView nombre;
        TextView ingredientes;
        TextView precio;
        ImageView imagen;
    }

    static class ViewHolderPedido {
        TextView nombre;
        TextView ingredientes;
        TextView precio;
        ImageView imagen;
    }

    private Pizza[] pizzas = new Pizza[]{
            new Pizza("Margarita", "jamon/tomate", 12, R.drawable.pizza1),
            new Pizza("Tres quesos", "queso1/queso2", 14, R.drawable.pizza2),
            new Pizza("Barbacoa", "carne/tomate", 15, R.drawable.pizza3),

    };

    private Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        final TextView titulo = (TextView) findViewById(R.id.textView);
        final Spinner spinnerPizzas = (Spinner) findViewById(R.id.spinner);
        final Spinner spinnerPedido = (Spinner) findViewById(R.id.spinner2);
        final ImageView logo = (ImageView) findViewById(R.id.foto);
        final RadioButton local =(RadioButton) findViewById(R.id.local);
        final RadioButton domicilio = (RadioButton) findViewById(R.id.domicilio);
        final CheckBox grandeCB = (CheckBox) findViewById(R.id.grande);
        final CheckBox ingredCB = (CheckBox) findViewById(R.id.ingred);
        final CheckBox quesoCB = (CheckBox) findViewById(R.id.queso);
        final EditText unidades = (EditText) findViewById(R.id.unidadesText);
        final Button anyadir = (Button) findViewById(R.id.anyadir);
        final Button resultado = (Button) findViewById(R.id.calculos);

        class AdaptadorSpinnerPizzas extends ArrayAdapter {

            Activity context;

            AdaptadorSpinnerPizzas(Activity context) {
                super(context, R.layout.spinner_pizza_layout, pizzas);
                this.context = context;
            }

            public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
                return getView(posicion, convertView, parent);
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                View item = convertView;
                ViewHolderPizzas holder;

                if (item == null) {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.spinner_pizza_layout, null);

                    holder = new ViewHolderPizzas();
                    holder.nombre = item.findViewById(R.id.nombre);
                    holder.ingredientes = item.findViewById(R.id.ingredientes);
                    holder.precio = item.findViewById(R.id.precio);
                    holder.imagen = item.findViewById(R.id.imagen);

                    item.setTag(holder);

                } else {
                    holder = (ViewHolderPizzas) item.getTag();
                }

                holder.nombre.setText(pizzas[position].getNombre());
                holder.ingredientes.setText(pizzas[position].getIngredientes());
                String a = Double.toString(pizzas[position].getPrecioBase());
                holder.precio.setText(a);
                holder.imagen.setImageResource(pizzas[position].getImagen());

                return (item);
            }

        }
        class AdaptadorSpinnerPedido extends ArrayAdapter {

            Activity context;

            AdaptadorSpinnerPedido(Activity context) {
                super(context, R.layout.spinner_pedido_layout, pizzas);
                this.context = context;
            }

            public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
                return getView(posicion, convertView, parent);
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                View item = convertView;
                ViewHolderPedido holder;

                if (item == null) {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.spinner_pedido_layout, null);

                    holder = new ViewHolderPedido();
                    holder.nombre = item.findViewById(R.id.nombre);
                    holder.ingredientes = item.findViewById(R.id.ingredientes);
                    holder.precio = item.findViewById(R.id.precio);
                    holder.imagen = item.findViewById(R.id.imagen);

                    item.setTag(holder);

                } else {
                    holder = (ViewHolderPedido) item.getTag();
                }
                /*
                holder.nombre.setText(pizzas[position].getNombre());
                holder.ingredientes.setText(pizzas[position].getDescripcion());
                String a = Double.toString(pizzas[position].getPrecio());
                holder.precio.setText(a);
                holder.imagen.setImageResource(pizzas[position].getImagen());
                */
                return (item);
            }

        }

        AdaptadorSpinnerPizzas adaptadorSpinnerPizzas = new AdaptadorSpinnerPizzas(this);
        spinnerPizzas.setAdapter(adaptadorSpinnerPizzas);

        AdaptadorSpinnerPedido adaptadorSpinnerPedido = new AdaptadorSpinnerPedido(this);
        spinnerPedido.setAdapter(adaptadorSpinnerPedido);

        anyadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = spinnerPizzas.getSelectedItemPosition();
                int nUnidades = Integer.parseInt(unidades.getText().toString());
                pedido = new Pedido();

                if (grandeCB.isChecked()) {
                    pizzas[posicion].anyadirExtra("Grande");
                    pizzas[posicion].incrementrarPrecioExtras();
                }

                if (quesoCB.isChecked()) {
                    pizzas[posicion].anyadirExtra("Queso");
                    pizzas[posicion].incrementrarPrecioExtras();
                }

                if (ingredCB.isChecked()) {
                    pizzas[posicion].anyadirExtra("Ingrediente extra");
                    pizzas[posicion].incrementrarPrecioExtras();
                }

                pizzas[posicion].calcularPrecioTotal();
                if ( nUnidades >= 1) {
                    for (int i = 0; i < nUnidades; i++) {
                        pedido.anyadirPizza(pizzas[posicion]);
                    }
                }
            }
        });

        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (domicilio.isChecked()) {
                    pedido.setEnvio(true);
                }

                pedido.calcularPrecioTotal();



            }
        });




    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.AcercaDe:
                Intent acerca = new Intent(Actividad1.this, Acercade.class);
                startActivity(acerca);
                return true;
            case R.id.Dibujo:
                Intent dibujo = new Intent(Actividad1.this, Dibujo.class);
                startActivity(dibujo);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
