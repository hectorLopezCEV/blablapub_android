package com.cev.blablapub.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cev.blablapub.R;
import com.cev.blablapub.adapters.ComentariosAdapter;
import com.cev.blablapub.modelos.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comentarios_del_negocio extends AppCompatActivity {

    // diseño del negocio, imagen, promocion y nombre
    // lo cogemos del adapter de Home con los intent
    private TextView c_nombreDeNegocio;
    private TextView c_promoiconDeNegocio;
    private ImageView c_imagenNegocio;
    private ListView c_listView;
    private EditText c_texto;
    private ImageButton c_boton;
    private ArrayList<Usuario> c_usuarios;
    private ComentariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_del_negocio);

        //logica para el diseño de la imagen del negocio,nombre,promoicon
        // implantamos los atributos////////////////////////////////////////////////////////////////////////
        c_nombreDeNegocio = findViewById(R.id.txv_comentarios_nombreNegocio);
        c_promoiconDeNegocio = findViewById(R.id.txv_comentarios_anuncioNegocio);
        c_imagenNegocio = findViewById(R.id.img_comentarios_imagenNegocio);
        c_texto = findViewById(R.id.edt_comentarios_mensaje);
        c_boton = findViewById(R.id.btn_imageButton_comentarios);
        c_listView = findViewById(R.id.lisv_comentarios);
        c_usuarios = new ArrayList<Usuario>();


        // cogemos los intent
        Intent getIntent = getIntent();
        String nombreNegocio = getIntent.getStringExtra("nombreList");
        String promocion = getIntent.getStringExtra("nombrePromocion");
        int imagenNegocio = getIntent.getIntExtra("imageNegocio",0);

        // se los asociamos a la vista del cliente en comentarios
        c_nombreDeNegocio.setText(nombreNegocio);
        c_promoiconDeNegocio.setText(promocion);
        c_imagenNegocio.setImageResource(imagenNegocio);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////



        // mostramos la lista ////////////////////////////////////////////////////////////////////////
        //Collections.reverse(c_usuarios);
        // todo pasar los usuarios de la bbdd
        adapter = new ComentariosAdapter(this,R.layout.comentarios_recibidos,c_usuarios);
        c_listView.setAdapter(adapter);
        c_listView.setDivider(null);
        //////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void addComentario(View v){
        if(!c_texto.getText().toString().isEmpty()){
            // todo pasar los usuarios de la bbdd mas la imagen del usuario
            adapter.addMensaje(new Usuario(c_texto.getText().toString()));
            c_listView.setSelection(c_usuarios.size() -1); // hace que la lista vaya hacia arriba
            c_texto.setText("");
        }
    }

    // volver a la pantalla de Home
    public void volverHome(View v){
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
        finish();
    }


}
