package com.cev.blablapub.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cev.blablapub.ListaDeNegocios;
import com.cev.blablapub.adapters.GridAdapter;
import com.cev.blablapub.R;
import com.cev.blablapub.modelos.Negocio;
import com.cev.blablapub.modelos.Usuario;

import java.util.ArrayList;

public class VistaDetalleBarActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //1 creamos las variables que vamos a modificar

    /*
    los atribtos de clase llevan en primer lugar la letra de la clase a la que pertenecen, en este caso la v
     */
    ImageView v_imagen;
    TextView v_nomNegocio;
    TextView v_anunNegocio;
    Toolbar v_toolbar;
    ImageView v_imgFlecha;
    GridView v_gridView;
    // creamos un array de usuarios para pasarlos al adapter
    ArrayList<Usuario> usuarios;
    String v_nombrePromocion,v_nomPub;
    int v_imagenList;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_detalle_bar);
        Log.i("bla","/////VISTADETALLE_oncreate");


        //2 asociamos las variables a los campos del xml
        v_imagen = findViewById(R.id.imagenDetalle);  // para mostrar al crearse
        v_anunNegocio = findViewById(R.id.anuncioNegocio);
        v_nomNegocio = findViewById(R.id.nombreNegocio);
        v_imgFlecha = findViewById(R.id.imv_flecha);
        v_gridView = findViewById(R.id.grid_usuarios);
        v_gridView.setOnItemClickListener(this);

        // todo hacer la peticion a la bbdd en vez de a las shared
        shared = getSharedPreferences("blablapub",MODE_PRIVATE);

        // LOGICA DEL ADPATER ///////
        // instancias para el adapter y rrellenado del array
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(R.mipmap.peliroja,"Loca"));
        usuarios.add(new Usuario(R.mipmap.olga,"Conductor"));
        usuarios.add(new Usuario(R.mipmap.peliroja,"Peli Roja"));
        usuarios.add(new Usuario(R.mipmap.olga,"Olga"));
        usuarios.add(new Usuario(R.mipmap.woman,"Woman"));
        usuarios.add(new Usuario(R.mipmap.rubio,"Rubio"));
        usuarios.add(new Usuario(R.mipmap.loco,"Loco"));
        usuarios.add(new Usuario(R.mipmap.el_gafas,"Chulo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        usuarios.add(new Usuario(R.mipmap.barbas,"Bagabundo"));
        // todo solucionar este listado para que lo coja de la base de datos

        // creamos el objeto adapter y le ponemos un onClickListener
        GridAdapter miAdapter = new GridAdapter(this,R.layout.grid_layout,usuarios);
        v_gridView.setAdapter(miAdapter);


        // recibo del activity prueba el src
        Intent intent = getIntent();
        String texto = intent.getStringExtra("javi");
        //Toast.makeText(this, texto, Toast.LENGTH_LONG).show();

        // compruebo el contenido del inten
        v_imagenList = intent.getIntExtra("imagenList", 0);
        v_nomPub = intent.getStringExtra("nombreList");
        v_nombrePromocion = intent.getStringExtra("nombrePromocion");
        v_imagen.setImageResource(v_imagenList);
        v_nomNegocio.setText(v_nomPub);
        v_anunNegocio.setText(v_nombrePromocion);
    }

    /*
    metodo para volver al HomeActivity
     */

    public void volverHome(View v){
        finish();

    }

    // Metodo para poner un onclickListener a el grid
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        /*
        paso  el mismo diseño a el activity chat
         */
        Intent intent = new Intent(this, Chat_usuariosActivity.class);
        intent.putExtra("anuncio",v_nombrePromocion);
        intent.putExtra("nomPub",v_nomPub);
        intent.putExtra("imagenlist",v_imagenList);
        intent.putExtra("imagen_usuario",usuarios.get(i).getImagen());
        intent.putExtra("nick_usuario",usuarios.get(i).getNick());


        startActivity(intent);
    }
}
