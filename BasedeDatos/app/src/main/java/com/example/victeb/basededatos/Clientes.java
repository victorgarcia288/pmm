package com.example.victeb.basededatos;

/**
 * Created by victeb on 16/01/18.
 */

public class Clientes {
    private String nombre;
    private String telefono;

    public Clientes(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
