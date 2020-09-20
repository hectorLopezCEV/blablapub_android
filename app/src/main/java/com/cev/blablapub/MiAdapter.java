package com.cev.blablapub;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MiAdapter extends ArrayAdapter {

    Context context;
    int intemLayout;
    Pub[] datos; // referencia a mi clase

    // estos parametro se lo pasaremos en el activity prueba2
    public MiAdapter(@NonNull Context context, int resource, @NonNull Pub[] objects) {
        super(context, resource, objects);

       this.context = context;
       this.intemLayout= resource;
       this.datos = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            Log.d("mi adapter", "elemento numero " + position);
            // para construir la vista necesitamos el metodo inflater y le pasamos nuestro layout creado
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(intemLayout, parent, false);
        }
        // ahora que tenemos la vista solo nos queda rellenarla con nuestra vista y nuestro array cogemos el texto y lo rellenamos
        TextView textView = convertView.findViewById(R.id.txv_nombre_establecimiento);
        textView.setText(datos[position].texto);

        // hacemos lo mismo con la vista la busdcamos en nuestro layout y le pasamos nuestra imagen
        ImageView imageView = convertView.findViewById(R.id.imageItem);
        imageView.setImageResource(datos[position].imagen);

        return convertView;
    }
}

