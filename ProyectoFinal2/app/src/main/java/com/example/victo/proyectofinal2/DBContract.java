package com.example.victo.proyectofinal2;


import android.provider.BaseColumns;

public class DBContract {
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String FOREIGN_KEY = " FOREIGN KEY";
    private static final String UNIQUE = " UNIQUE ";
    private static final String REFERENCES = " REFERENCES ";
    private static final String ON_DELETE = " ON DELETE";
    private static final String ON_UPDATE = " ON UPDATE";
    private static final String CASCADE = " CASCADE";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String TEXT_TYPE = " TEXT";
    private static final String NOT_NULL = " NOT NULL";
    private static final String COMA_SEP = ", ";
    
    private DBContract() {}

    public static final String[] CREATE_TABLE_ARRAY = {
            PizzaEntry.CREATE_TABLE,
    };
    
    public static final String[] DROP_TABLE_ARRAY = {
            PizzaEntry.DROP_TABLE,
    };

    public static final class PizzaEntry implements BaseColumns {
        public static final String TABLE_NAME = "pizza";
        public static final String KEY_NAME = "name";
        public static final String KEY_INGREDIENTS = "ingredients";
        public static final String KEY_PRICE = "price";
        public static final String KEY_PHOTO_ID = "photo_id";

        private PizzaEntry() {}
        
        public static final String[] KEY_ARRAY = {
                KEY_NAME,
                KEY_INGREDIENTS,
                KEY_PRICE,
                KEY_PHOTO_ID
        };

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + _ID + INTEGER_TYPE + PRIMARY_KEY + COMA_SEP
                + KEY_NAME + TEXT_TYPE + NOT_NULL + COMA_SEP
                + KEY_INGREDIENTS + TEXT_TYPE + NOT_NULL + COMA_SEP
                + KEY_PRICE + REAL_TYPE + NOT_NULL + COMA_SEP
                + KEY_PHOTO_ID + INTEGER_TYPE + COMA_SEP
                + UNIQUE + "(" + KEY_NAME + ")"
                + ")";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
