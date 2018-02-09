package com.example.victeb.examenvictorgarcia;

import android.app.Fragment;
import android.content.Context;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragmento extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int mParam1_num;

    TextView registro1;
    TextView tarea1;
    TextView lugar1;
    TextView importancia1;
    TextView descripcion1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1_num = getArguments().getInt(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v;
        v = inflater.inflate(R.layout.fragment, container, false);
        registro1 = (TextView) v.findViewById(R.id.registro);
        tarea1 = (TextView) v.findViewById(R.id.tarea);
        lugar1  = (TextView) v.findViewById(R.id.lugar);
        importancia1 = (TextView) v.findViewById(R.id.importancia);
        descripcion1  = (TextView) v.findViewById(R.id.descripcion);



        return v;
    }

    public void rellenardatos(){

        registro1.getText().toString();
        tarea1.getText().toString();
        lugar1.getText().toString();
        importancia1.getText().toString();
        descripcion1.getText().toString();

        try{
            MainActivity.mDbHelper.open();
            MainActivity.mDbHelper.insertItem(registro1,tarea1 ,lugar1,integer.parseInt(importancia1,descripcion1);
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }


    }

    public static Fragmento newInstance(int param1) {
        Fragmento fragment = new Fragmento();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
}