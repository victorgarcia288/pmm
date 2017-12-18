package com.example.victo.spinner;

/**
 * Created by victo on 30/11/2017.
 */

public class Mueble {
    private String nombre;
    private int precio;

    public Mueble(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

}
