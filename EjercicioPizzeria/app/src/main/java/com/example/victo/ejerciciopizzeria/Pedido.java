package com.example.victo.ejerciciopizzeria;

import java.util.ArrayList;

/**
 * Created by victo on 20/12/2017.
 */

public class Pedido {
    ArrayList<Pizza> pizzas = new ArrayList();
    boolean envio = false; // true si el pedido es a domicilio o false si es en local.
    double precioTotal = 0;

    public Pedido(){

    }

    public void setPizzas(ArrayList pizzas) {
        this.pizzas = pizzas;
    }

    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ArrayList getPizzas() {
        return pizzas;
    }

    public boolean getEnvio(){
        return envio;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void anyadirPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void quitarPizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public void calcularPrecioTotal() {
        for (int i = 0; i < pizzas.size(); i++) {
            precioTotal += pizzas.get(i).getPrecioTotal();
        }
        if (envio == true) {
            precioTotal += precioTotal * 0.1;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < pizzas.size(); i++) {
            s += pizzas.get(i).toString();
        }
        return s;
    }
}
