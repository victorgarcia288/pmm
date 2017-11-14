package com.example.victeb.dibujos3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by victeb on 3/11/17.
 */

public class VistaDibujo extends View {
    private ShapeDrawable miDrawable;

    public VistaDibujo(Context c) {
        super(c);
        Context ctx;
        this.ctx =contexto;
    }

    public VistaDibujo(Context C, AttributeSet attrs) {

        super(c, attrs);
    }

    protected void onDraw(Canvas canvas) {
        Paint pincel = new Paint();
        pincel.setColor(Color.RED);
        pincel.setStrokeWidth(15);
        pincel.setStyle(Paint.Style.STROKE);

        for (int i = 0; i < 10; i++)
            canvas.drawRect(50 + i * 100, 500 + i * 100, 300 + i * 100, 800 + i * 100, pincel);
        pincel.setColor(Color.BLUE);
        for (int i = 0; i < 10; i++)
            canvas.drawCircle(50 + i * 100, 500 + i * 100, 300 + i * 100, pincel);

        BitmapDrawable imagen;
        Resources res = ctx.getResources();
        imagen = (BitmapDrawable) res.getDrawable(R.drawable.imagenchina);
        imagen.setBounds(new Rect(50, 800, 500, 1200));
        imagen.draw(canvas);
    }
}
