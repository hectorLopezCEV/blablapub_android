package com.cev.blablapub.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.ArrayLinkedVariables;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cev.blablapub.R;
import com.cev.blablapub.adapters.ChatAdapter;
import com.cev.blablapub.modelos.Usuario;

import java.util.ArrayList;

public class Chat_usuariosActivity extends AppCompatActivity  {

    // declaraciones
    private ImageView flecha;
    private ListView listView;
    private ImageView imageView;
    private TextView nomPub;
    private TextView anuncioPub;
    private ImageView imagenPorDefecto;
    private ArrayList<Usuario> usuarios;
    private EditText texto;
    private ImageButton boton;

    // todo eliminar cuando hayamos validado los datos con la bbdd
    SharedPreferences shared;
    SharedPreferences.Editor editor;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_usuarios);
        Log.i("bla","////////Chat usuatios");

        // instancias
        flecha = findViewById(R.id.img_chat_flecha);
        listView = findViewById(R.id.lisv_chat);
        imageView = findViewById(R.id.img_chat_imagenDetalle);
        anuncioPub = findViewById(R.id.txv_chat_anuncioNegocio);
        nomPub = findViewById(R.id.txv_chat_nombreNegocio);
        texto = findViewById(R.id.edt_chat_mensaje);
        boton = findViewById(R.id.btn_imageButton);

        usuarios = new ArrayList<Usuario>();



        /*
        logica para el diseño del activity del chat
        cogemos lo que nos llega de vista detalle , foto,promocion,local,imagen...
        y se lo pasamos al diseño
         */
        Intent intent = getIntent();
        int imagenList = intent.getIntExtra("imagenlist", 0);
        String nombreList = intent.getStringExtra("nomPub");
        String nombrePromocion = intent.getStringExtra("anuncio");
        final int imagenUsuario = intent.getIntExtra("imagen_usuario",0);
        final String nick = intent.getStringExtra("nick_usuario");

        imageView.setImageResource(imagenList);
        nomPub.setText(nombreList);
        anuncioPub.setText(nombrePromocion);
        // todo logica para el chat, eliminar cuando este la bdd
        /* logica para mostrar el layout del usuario en el chat o el de las personas que hay en el local
        si el id de la bbdd coincide con el del usuario mandamos el layout del usuario
        de lo contrario lanzamos el de las personas del local
        de momento saco los datos harcodeados de las shared
         */
        shared = getSharedPreferences("blablapub",MODE_PRIVATE);
        String usuario = shared.getString("login","defaul");
        Log.d("negocios","el usuario es igual a = "+usuario);

        if (usuario != "yo"){  //

            final ChatAdapter chatAdapter = new ChatAdapter(this,R.layout.layout_chat_recibido,usuarios);

            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // le paso al metodo del adapter el mensaje del usuario
                    // como no tengo imagenes de usuarios en la bbdd los cojo del drawable
                    chatAdapter.addMensaje(new Usuario(imagenUsuario,texto.getText().toString()));
                    // todo hacer que el display del texto desaparezca cuando ya he escrito el texto
                    listView.setAdapter(chatAdapter);


                }
            });

        }else{
            if ( usuario == "yo"){
                final ChatAdapter chatAdapter = new ChatAdapter(this,R.layout.layout_chat_enviado,usuarios);

                boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // esta vez le paso el layout del usuario
                        chatAdapter.addMensaje(new Usuario(texto.getText().toString()));
                        listView.setAdapter(chatAdapter);

                    }
                });
            }

        }

        texto.setText(""); // limpio las letras del usuario
        listView.setDivider(null);
    }

    public ImageView getFecla() {
        return flecha;
    }

    public void setFecla(ImageView fecla) {
        this.flecha = fecla;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getNomPub() {
        return nomPub;
    }

    public void setNomPub(TextView nomPub) {
        this.nomPub = nomPub;
    }

    public TextView getAnuncioPub() {
        return anuncioPub;
    }

    public void setAnuncioPub(TextView anuncioPub) {
        this.anuncioPub = anuncioPub;
    }

    public ImageView getImagenPorDefecto(){
        return imagenPorDefecto;
    }
    // todo hacer que todos tengan una imagen por defecto que sacaremos de la base de datos




    public void volverVistaDetalle(View v){
        finish();
    }
}
