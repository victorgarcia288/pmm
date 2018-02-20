package com.example.victo.proyectofinal2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {
    ArrayList<Pizza> pizzas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinnerPizza = findViewById(R.id.activity_main_pizza_spinner);
        final RadioGroup lugar = findViewById(R.id.luga_radioGroup);
        final RadioButton local1 = findViewById(R.id.local_rb);
        final RadioButton domicilio1 = findViewById(R.id.domicilio_rb);
        final EditText unidades1 = findViewById(R.id.unidades_text);
        final Button button = findViewById(R.id.calculos);


        final Bundle paso_datos = new Bundle();

        DBHelper dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.getAllPizzas();

        final AdapterSpinnerPizza adapter = new AdapterSpinnerPizza(this, cursor);
        spinnerPizza.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String cantidad = unidades1.getText().toString();
                paso_datos.putString("CANTIDAD", cantidad, pizzas);
                int canti = Integer.parseInt(cantidad);
                Cursor cursor = (Cursor) spinnerPizza.getSelectedItem();
                Pizza pizza = new Pizza(cursor);
                pizzas.add(pizza);
                int cont =0;

                int paso1 = añadido(cont);
                String comple = Integer.toString(paso1);
                paso_datos.putString("EXTRAS", comple);
                int paso2 = cantidad(canti);
                double total = envio(paso2 + paso1);

                String resultado = Double.toString(total);
                String tipoeenvio = envios();
                paso_datos.putString("TOTAL", resultado);
                paso_datos.putString("ENVIO", tipoeenvio);

                Intent miIntent = new Intent(ActivityMain.this, Resultado.class);
                miIntent.putExtras(paso_datos);
                startActivity(miIntent);


            }
        });


    }

    final CheckBox grande1 = findViewById(R.id.grande_cbox);
    final CheckBox ingrediente = findViewById(R.id.ingred_cbox);
    final CheckBox queso1 = findViewById(R.id.queso_cbox);

    int cont =0;
    public int añadido(int cont) {
        if (grande1.isChecked())
            cont++;
        if (ingrediente.isChecked())
            cont++;
        if (queso1.isChecked())
            cont++;
        return cont;
    }

    final RadioButton local1 = findViewById(R.id.local_rb);
    final RadioButton domicilio1 = findViewById(R.id.domicilio_rb);

    public double envio(int precio) {
        double total = 0;
        if (local1.isChecked()){
            total = precio + precio * 0.1;
            return total;}
        else
            return precio;

    }

    public String envios() {
        String x = "";
        if (local1.isChecked()) {
            x = "En el local";
        } else if (domicilio1.isChecked()) {
            x = "Envio domicilio";
        }
        return x;


    public int cantidad(int numero) {
        for (int i = 0; i < pizzas ; i++){
            int total = numero * pizzas[i].getPrecio;
            return total;
        }

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.AcercaDe:
                Intent acerca = new Intent(ActivityMain.this, Acercade.class);
                startActivity(acerca);
                return true;
            case R.id.Noticias:
                Intent noticias = new Intent(ActivityMain.this, Noticias.class);
                startActivity(noticias);


        }
        return super.onOptionsItemSelected(item);
    }









}
