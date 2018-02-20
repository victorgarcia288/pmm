package com.example.victo.proyectofinal2;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterSpinnerPizza extends CursorAdapter {

    public AdapterSpinnerPizza(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.pizza_detail, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameText = view.findViewById(R.id.pizza_detail_name);
        TextView ingredientsText = view.findViewById(R.id.pizza_detail_ingredients);
        TextView descriptionText = view.findViewById(R.id.pizza_detail_price);
        ImageView priorityImage = view.findViewById(R.id.pizza_detail_photo);

        String name = cursor.getString(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_NAME));
        String ingredients = cursor.getString(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_INGREDIENTS));
        double price = cursor.getDouble(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_PRICE));
        int photo = cursor.getInt(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_PHOTO_ID));

        nameText.setText(name);
        ingredientsText.setText(ingredients);
        descriptionText.setText(Double.toString(price) + " €");
        priorityImage.setImageResource(photo);
    }
}
