package com.example.victeb.ejerciciorecopilatorio;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by victeb on 16/11/17.
 */

public class AdaptadorZona extends ArrayAdapter<Zona> {
    public Activity miActividad;

    public AdaptadorZona(Activity laActividad){
        super(laActividad, R.layout.item);
        this.miActividad = laActividad;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        View vistaDesplegada = getView(position, convertView, parent);
        return vistaDesplegada;
    }

    public View get

}
