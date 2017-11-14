package com.example.victeb.dibujos2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        Context ctx;
        public EjemploView(Context contexto) {
            super(contexto);
            this.ctx =contexto;
        }

        protected void onDraw(Canvas canvas) {
            Paint pincel = new Paint();
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);

            for(int i=0; i < 10; i++)
            canvas.drawRect(50+i*100,500+i*100,300+i*100,800+i*100, pincel);
            pincel.setColor(Color.BLUE);
            for(int i=0; i < 10; i++)
            canvas.drawCircle(50+i*100, 500+i*100,300+i*100, pincel);

            BitmapDrawable imagen;
            Resources res = ctx.getResources();
            imagen = (BitmapDrawable)res.getDrawable(R.drawable.descarga);
            imagen.setBounds(new Rect(50,800,500,1200));
            imagen.draw(canvas);


        }
    }
}
