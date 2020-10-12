package com.cev.blablapub.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.ArrayLinkedVariables;

import android.content.Intent;
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
        usuarios.add(new Usuario(R.mipmap.barbas,"Barbas",texto.getText().toString()));
        usuarios.add(new Usuario(R.mipmap.el_gafas,"Gafas",texto.getText().toString()));
        usuarios.add(new Usuario(R.mipmap.rubio,"rubio",texto.getText().toString()));

         */


        // implementamos las vistas


        /*
        logica para el diseño del activity del chat
        cogemos lo que nos llega de vista detalle , foto,promocion,local,imagen...
        y se lo pasamos al diseño
         */
        Intent intent = getIntent();
        int imagenList = intent.getIntExtra("imagen", 0);
        String nombreList = intent.getStringExtra("nomPub");
        String nombrePromocion = intent.getStringExtra("anuncio");
        final int imagenUsuario = intent.getIntExtra("imagen_usuario",0);
        final String nick = intent.getStringExtra("nick_usuario");

        imageView.setId(imagenList); // todo esta imagen hay que cogerla de la base de datos
        nomPub.setText(nombreList);
        anuncioPub.setText(nombrePromocion);





        final ChatAdapter chatAdapter = new ChatAdapter(this,R.layout.layout_chat_recibido,usuarios);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // le paso al metodo del adapter el mensaje del usuario
                // como no tengo imagenes de usuarios en la bbdd los cojo del drawable
              chatAdapter.addMensaje(new Usuario(imagenUsuario,nick,texto.getText().toString()));
              texto.setText("");
              // todo hacer que el display del texto desaparezca cuando ya he escrito el texto

            }
        });



        listView.setDivider(null);
        listView.setAdapter(chatAdapter);
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
