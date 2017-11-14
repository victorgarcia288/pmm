package com.example.victeb.dibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View{
        public EjemploView(Context contexto){
            super(contexto);
        }

        protected void onDraw(Canvas canvas){
            Paint pincel = new Paint();
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150,150, 200, pincel);
        }
    }


}
