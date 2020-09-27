package com.cev.blablapub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cev.blablapub.R;
import com.cev.blablapub.modelos.Usuario;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GridAdapter extends ArrayAdapter {
    Context context;
    int layout;
    List<Usuario> usuarios;

    // constructor del adapter
    public GridAdapter(@NonNull Context context, int resource, @NonNull List<Usuario> objects) {
        super(context, resource, objects);

        this.context = context;
        this.layout = resource;
        this.usuarios = objects;
    }

    // metodo para inflar la vista

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // capa de seguridad por si viene vacio la vista
        if ( convertView == null){
            LayoutInflater inflador = LayoutInflater.from(context);
            convertView = inflador.inflate(layout,parent,false);
        }

        /*
        ahora que ya tenemos el Layout inflado ya podemos introducir las vistas
        pero antes hay que inflarlas
        */
        ImageView fotoUsuario = convertView.findViewById(R.id.img_circular);
        fotoUsuario.setImageResource(usuarios.get(position).getImagen());

        // hacemos lo mismo con el nick
        TextView nick = convertView.findViewById(R.id.nick);
        nick.setText(usuarios.get(position).getNick());

        return convertView;
    }
}
