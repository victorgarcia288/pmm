package com.example.victo.proyectofinal2;


import android.content.ContentValues;
import android.database.Cursor;

public class Pizza {
    private String name;
    private String ingredients;
    private double price;
    private int photoId;

    public Pizza(String name, String ingredients, float price, int photoId) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.photoId = photoId;
    }

    public Pizza(Cursor cursor) {
        this.name = cursor.getString(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_NAME));
        this.ingredients = cursor.getString(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_INGREDIENTS));
        this.price = cursor.getFloat(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_PRICE));
        this.photoId = cursor.getInt(cursor.getColumnIndex(DBContract.PizzaEntry.KEY_PHOTO_ID));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(DBContract.PizzaEntry.KEY_NAME, name);
        values.put(DBContract.PizzaEntry.KEY_INGREDIENTS, ingredients);
        values.put(DBContract.PizzaEntry.KEY_PRICE, price);
        values.put(DBContract.PizzaEntry.KEY_PHOTO_ID, photoId);
        return values;
    }
}
