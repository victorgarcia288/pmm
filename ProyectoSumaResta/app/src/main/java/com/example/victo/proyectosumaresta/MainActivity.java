package com.example.victo.proyectosumaresta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.tv_resultado);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.op_Radiogroup);
        final RadioButton rB1 = (RadioButton) findViewById(R.id.sumaRB);
        final RadioButton rB2 = (RadioButton) findViewById(R.id.resta_RB);
        final EditText editText1 = (EditText) findViewById(R.id.num1_ET);
        final EditText editText2 = (EditText) findViewById(R.id.num2_ET);
        final Button calcular = (Button) findViewById(R.id.calcularB);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado;
                double numero1 = 0, numero2 = 0;

                try {
                    numero1 = Double.parseDouble(editText1.getText().toString());
                    numero2 = Double.parseDouble(editText2.getText().toString());
                } catch (NumberFormatException ex) {

                }

                if (rB1.isChecked()) {
                    resultado = sumar(numero1, numero2);
                } else {
                    resultado = restar(numero1, numero2);
                }

                textView.setText(resultado);
            }
        });
    }

    public String sumar(double a, double b) {
        return Double.toString(a + b);
    }

    public String restar(double a, double b) {
        return Double.toString(a - b);
    }
}
