package com.example.victeb.figurasaleatorias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DrawShapes1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes1);
        mDrawingArea  = (RandomShapeView)findViewById(R.id.drawing_area);
    }

    /** Handles events for the button. Redraws the ShapeView. */
    public void redraw(View clickedButton) {
        mDrawingArea.invalidate();

    }
}
