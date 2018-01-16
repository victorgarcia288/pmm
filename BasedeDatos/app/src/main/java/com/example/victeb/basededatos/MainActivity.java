package com.example.victeb.basededatos;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abrimos la base de datos en modo escritura
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos
        if (bd != null) {
            //Introducimos 3 clientes de ejemplo
            for (int cont = 1; cont <= 3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }
        }
            /*Ejemplo Select
            String[] args3 = new String[]{"cli1"};
            Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);*/

            //Ejemplo Select2
            String[] campos = new String[]{"nombre", "telefono"};
            String[] args4 = new String[]{"cli1"};
            Cursor c = bd.query("Clientes", campos, null, null, null, null,null);


            //Nos aseguramos de que exista al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    String nombreCli = c.getString(0);
                    String telefonoCli = c.getString(1);
                    String datos = nombreCli + "  " + telefonoCli;
                    Toast.makeText(this, datos, Toast.LENGTH_SHORT).show();
                } while (c.moveToNext());


                //Cerramos la base de datos
                bd.close();
            } //del if
        }


    }

    class AdaptadorSpinnerClientes extends ArrayAdapter{

    Activity context;

    AdaptadorSpinnerClientes(Activity context){
        super(context, R.layout.spinner_clientes_layout);
        this.context = context;
    }

    public View getDropDown
    }

