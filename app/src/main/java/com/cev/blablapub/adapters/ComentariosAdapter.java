package com.cev.blablapub.adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cev.blablapub.ListaDeNegocios;
import com.cev.blablapub.R;
import com.cev.blablapub.modelos.Negocio;
import com.cev.blablapub.modelos.Usuario;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ComentariosAdapter extends ArrayAdapter {

    /*
    Adapter para la lista de comentarios de cada negocio

     */
    Context context;
    int layout;
    List<Usuario> usuarios;

    public ComentariosAdapter(@NonNull Context context, int resource, @NonNull List<Usuario> usuarios) {
        super(context, resource, usuarios);

        this.context = context;
        this.layout = resource;
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // inflamos la vista
        if (convertView == null){
            LayoutInflater inflador = LayoutInflater.from(context);
            convertView = inflador.inflate(layout,parent,false);
        }


        // inflamos los mensajes accediendo a el layout y sus vistas/////////////////////////////////////
        TextView comentarios = convertView.findViewById(R.id.txv_texto_comentario_recibido);
        comentarios.setText(usuarios.get(position).getMensaje());

        // ahora la imagen del usuario // todo cogerla de la bbdd
        if (usuarios.get(position).getImagen() == 0){
            ImageView imagen = convertView.findViewById(R.id.img_comentarios_usuario);
            imagen.setImageResource(usuarios.get(position).getImagen_por_defecto());
        }else {
            ImageView imagen = convertView.findViewById(R.id.img_comentarios_usuario);
            imagen.setImageResource(usuarios.get(position).getImagen());
        }
        // todo quitar cuando ya tengamos el de la bbdd
        if (usuarios.get(position).getNick() == null){
            TextView apodo = convertView.findViewById(R.id.txv_comentarios_apodo);
            apodo.setText("blablaPub");
        }else{
            // el apodo todo cogerlo de la bbdd
            TextView apodo = convertView.findViewById(R.id.txv_comentarios_apodo);
            apodo.setText(usuarios.get(position).getNick());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////

        return convertView;
    }



    public void addMensaje(Usuario mensaje){
        usuarios.add(mensaje);
    }
}
