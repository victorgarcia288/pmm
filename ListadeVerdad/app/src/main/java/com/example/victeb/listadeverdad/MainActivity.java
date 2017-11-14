package com.example.victeb.listadeverdad;

import android.app.Activity;
import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Prototipo", "Ford", R.drawable.ford),
            new Titular("Prototipo", "BMW", R.drawable.bmw),
            new Titular("Prototipo", "Dodge", R.drawable.descarga)
    };

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        ImageView imagen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo:" + datos[position].getTitulo() + "Subtitulo" + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

        });
    }

    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;


            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);
                holder= new ViewHolder();
                holder.titulo = (TextView)item.findViewById(R.id.tvTitulo);
                holder.subtitulo = (TextView)item.findViewById(R.id.tvSubtitulo);
                holder.imagen = (ImageView) item.findViewById(R.id.ivImagen);
                item.setTag(holder);
            }

            else
            { holder = (ViewHolder)item.getTag(); }
            holder.titulo.setText(datos[i].getTitulo());
            holder.subtitulo.setText(datos[i].getSubtitulo());
            holder.imagen.setImageResource(datos[i].getImagen());

            return item;

        }

    }
}
