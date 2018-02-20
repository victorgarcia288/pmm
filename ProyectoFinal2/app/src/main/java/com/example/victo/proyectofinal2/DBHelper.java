package com.example.victo.proyectofinal2;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    private static final Pizza[] MOCK_PIZZA_ARRAY = {
            new Pizza("Barbacoa", "Carne, salsa barbacoa", 8, R.drawable.pizza_barbacoa),
            new Pizza("CuatroQuesos", "Queso1, queso2", 6, R.drawable.pizza2),
            new Pizza("Peperoni", "Pepperoni, queso", 5, R.drawable.pizza3),
            new Pizza("Vegetal", "Pimiento, tomate", 7, R.drawable.pizza4)
    };

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.PizzaEntry.CREATE_TABLE);
        mockData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DBContract.PizzaEntry.DROP_TABLE);
    }

    public long mockPizza(SQLiteDatabase sqLiteDatabase, Pizza task) {
        return sqLiteDatabase.insert(
                DBContract.PizzaEntry.TABLE_NAME,
                null,
                task.toContentValues()
        );
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        for (Pizza pizza : MOCK_PIZZA_ARRAY) {
            mockPizza(sqLiteDatabase, pizza);
        }
    }

    public Cursor getAllPizzas() {
        return getReadableDatabase().query(
                DBContract.PizzaEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor getPizzasByName(String name) {
        return getReadableDatabase().query(
                DBContract.PizzaEntry.TABLE_NAME,
                null,
                DBContract.PizzaEntry.KEY_NAME + " LIKE ?",
                new String[]{name},
                null,
                null,
                null
        );
    }

    public long insertPizza(Pizza pizza) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                DBContract.PizzaEntry.TABLE_NAME,
                null,
                pizza.toContentValues());
    }

    public int deletePizza(String name) {
        return getWritableDatabase().delete(
                DBContract.PizzaEntry.TABLE_NAME,
                DBContract.PizzaEntry.KEY_NAME + " LIKE ?",
                new String[]{name});
    }
}
