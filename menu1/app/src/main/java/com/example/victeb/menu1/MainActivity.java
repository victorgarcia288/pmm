package com.example.victeb.menu1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                ;
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada!");
                ;
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }


}
