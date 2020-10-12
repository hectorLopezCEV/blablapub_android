package com.cev.blablapub.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cev.blablapub.R;
import com.cev.blablapub.modelos.Usuario;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
    Este adpater es para el chat
 */
public class ChatAdapter extends ArrayAdapter {
    private Context context;
    private int layout;
    private List<Usuario> usuarios;
    public SharedPreferences shared;



    // metodo para añadir un mesaje
    public void anadirMensaje(Usuario mensaje){

    }

    public ChatAdapter(@NonNull Context context, int layout, @NonNull List<Usuario> objects) {
        super(context, layout, objects);

        this.context = context;
        this.layout = layout;
        this.usuarios = objects;
    }


    // metodo inflador de la vista

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        // inflamos la vista con una capa de seguridad añadiendo el if
        if (convertView == null){

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layout,parent,false);
        }

        // ahora que ya tenemos la vista inflada, entramos en ella y inflamos el contenido
        // todo aqui tenemos que buscar en la base de datos el nombre  del usuario para pasrlo al inflador de momento lo harcodeo

        // en la imagen del layout metemos la imagen del usuario
        ImageView imageView = convertView.findViewById(R.id.img_chat_usuario);
        imageView.setImageResource(usuarios.get(position).getImagen());

        // hacemos lo mismo con el mensaje del usuario
        TextView textView = convertView.findViewById(R.id.txv_texto_mensaje_recibido);
        textView.setText(usuarios.get(position).getMensaje());




        return convertView;

    }


    public void addMensaje (Usuario mensaje){
        usuarios.add(mensaje);
    }



}
