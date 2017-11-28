package com.example.victeb.spinner;

/**
 * Created by victeb on 28/11/17.
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
