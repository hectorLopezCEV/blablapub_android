package com.cev.blablapub.modelos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cev.blablapub.R;
import com.cev.blablapub.modelos.Usuario;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class ChatEnviadoAdapter extends ArrayAdapter {

    // adapter para la logica de los mensajes enviados por el usuario
    private Context context;
    private int layout;
    private List<Usuario> usuarios;

    public ChatEnviadoAdapter(@NonNull Context context, int resource, @NonNull List<Usuario> usuarios) {
        super(context, resource, usuarios);

        this.context = context;
        this.layout = resource;
        this.usuarios = usuarios;
    }

    // metodo inflador de la vista

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // inflamos la vista que nos llega por parametro
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout,parent,false);
        }

        // entramos en el textview del layout y le metemos el texto del usuario
        TextView textView = convertView.findViewById(R.id.txv_texto_mensaje_enviado);
        textView.setText(usuarios.get(position).getMensaje().toString());


        return convertView;
    }

    // metodo para añadir mensajes
    public void addMensaje (Usuario mensaje){
        usuarios.add(mensaje);
    }

}
