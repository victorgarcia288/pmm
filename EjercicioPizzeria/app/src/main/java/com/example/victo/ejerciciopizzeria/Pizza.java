package com.example.victo.ejerciciopizzeria;

import java.io.Serializable;

/**
 * Created by victo on 20/12/2017.
 */

public class Pizza {
    private String nombre;
    private String ingredientes;
    private String extras = "";
    private double precioBase;
    private double precioExtras = 0;
    private double precioTotal;
    private int imagen;

    public Pizza(String nombre, String ingredientes, double precioBase, int imagen) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precioBase = precioBase;
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setPrecioExtras(double precioExtras) {
        this.precioExtras = precioExtras;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getExtras() {
        return extras;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioExtras() {
        return precioExtras;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public int getImagen() {
        return imagen;
    }

    public void incrementrarPrecioExtras() {
        precioExtras++;
    }

    public void decrementarPrecioExtras() {
        precioExtras--;
    }

    public void calcularPrecioTotal() {
        precioTotal = precioBase + precioExtras;
    }

    public void anyadirExtra(String extra) {
        if (extras.isEmpty()) {
            extras += extra;
        } else {
            extras += "+ " + extra;
        }
    }

    public void quitarExtra(String extra) {
        if (extras.isEmpty()) {
            extras = extras.replace(extra, "");
        } else if (extras.startsWith(extra.substring(0, 1))) {
            extras = extras.replace(extra + " + ", "");
        } else {
            extras = extras.replace(" + " + extra, "");
        }
    }

    @Override
    public String toString() {
        String s;
        s = "Nombre: " + nombre +
                "\nIngredientes: " + ingredientes +
                "\nExtras: " + extras +
                "\nPrecio: " + precioTotal + " €\n";
        return s;
    }
}
