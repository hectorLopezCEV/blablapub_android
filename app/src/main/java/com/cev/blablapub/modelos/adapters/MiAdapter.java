package com.cev.blablapub.modelos.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cev.blablapub.R;
import com.cev.blablapub.views.view.activitys.Comentarios_del_negocio;
import com.cev.blablapub.views.view.activitys.VistaDetalleBarActivity;
import com.cev.blablapub.modelos.Negocio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/*
    Adapter para el home
    donde vamos a definir todas las acciones
    que van a hacer los usuarios en el Home, como megustas,comentarios...
 */

public class MiAdapter extends ArrayAdapter {

    Context context;
    int intemLayout;
    Negocio[] negocios; // referencia a mi clase
    int numero_me_gusta = 0;

    // estos parametro se lo pasaremos en el activity prueba2
    public MiAdapter(@NonNull Context context, int resource, @NonNull Negocio[] objects) {
        super(context, resource, objects);

       this.context = context;
       this.intemLayout= resource;
       this.negocios = objects;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull  ViewGroup parent) {
        if(convertView == null) {
            Log.d("mi adapter", "elemento numero " + position);

            // para construir la vista necesitamos el metodo inflater y le pasamos nuestro layout creado
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(intemLayout, parent, false);
        }
        // ahora que tenemos la vista solo nos queda rellenarla con nuestra vista y nuestro array cogemos el texto y lo rellenamos
        TextView textView = convertView.findViewById(R.id.txv_nombre_establecimiento);
        textView.setText(negocios[position].getTexto());


        // hacemos lo mismo con la vista la busdcamos en nuestro layout y le pasamos nuestra imagen
        // le ponemos el onclicklistener solo a la vista
        ImageView imageView = convertView.findViewById(R.id.imageItem);
        imageView.setImageResource(negocios[position].getImagen());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((ListView) parent).performItemClick(view, position, 0);
                Log.i("bla","estas en el adapter");
                Intent intent = new Intent(getContext(),VistaDetalleBarActivity.class);
                intent.putExtra("imagenList",negocios[position].getImagen());
                intent.putExtra("nombreList",negocios[position].getTexto());
                intent.putExtra("nombrePromocion",negocios[position].getPromocion().titulo);
                context.startActivity(intent);
            }
        });

        // ponemos un onclickListener a cada elemento
        final TextView total_de_megustas = convertView.findViewById(R.id.txv_home_numeros_megusta);
        TextView meGusta = convertView.findViewById(R.id.txv_meGusta);
        meGusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numero_me_gusta = +1; // de esta manera solo pueden sumar uno cada usuario //todo hacer que esta cantidad venga de la bbdd
                total_de_megustas.setText(Integer.toString(numero_me_gusta));

            }
        });

        // ponemos un onclick a los comentarios
        TextView comentarios = convertView.findViewById(R.id.txv_comentarios);
        comentarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Comentarios_del_negocio.class);
                intent.putExtra("imageNegocio",negocios[position].getImagen());
                intent.putExtra("nombreList",negocios[position].getTexto());
                intent.putExtra("nombrePromocion",negocios[position].getPromocion().titulo);
                context.startActivity(intent);
            }
        });


        return convertView;
    }

}

