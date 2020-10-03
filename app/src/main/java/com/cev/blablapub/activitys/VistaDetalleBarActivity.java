package com.cev.blablapub.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cev.blablapub.adapters.GridAdapter;
import com.cev.blablapub.R;
import com.cev.blablapub.modelos.Usuario;

import java.util.ArrayList;

public class VistaDetalleBarActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //1 creamos las variables que vamos a modificar

    /*
    los atribtos de clase llevan en primer lugar la letra de la clase a la que pertenecen, en este caso la v
    aquellos atributos de otra clase que quiera usar empezaran por la letra de su clase ejem en la clase Home los atributos llevaran la h
     */
    ImageView v_imagen;
    TextView v_nomNegocio;
    TextView v_anunNegocio;
    Toolbar v_toolbar;
    ImageView v_imgFlecha;
    GridView v_gridView;
    // creamos un array de usuarios para pasarlos al adapter
    ArrayList<Usuario> usuarios;

    String h_nombrePromocion,h_nomPub;
    int h_imagenList;

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

        // creamos el objeto adapter y le ponemos un onClickListener
        GridAdapter miAdapter = new GridAdapter(this,R.layout.grid_layout,usuarios);
        v_gridView.setAdapter(miAdapter);


        // recibo del activity prueba el src
        Intent intent = getIntent();
        String texto = intent.getStringExtra("javi");
        //Toast.makeText(this, texto, Toast.LENGTH_LONG).show();

        // compruebo el contenido del inten
        h_imagenList = intent.getIntExtra("imagenList", 0);
        h_nomPub = intent.getStringExtra("nombreList");
        h_nombrePromocion = intent.getStringExtra("nombrePromocion");
        v_imagen.setImageResource(h_imagenList);
        v_nomNegocio.setText(h_nomPub);
        v_anunNegocio.setText(h_nombrePromocion);






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

        Intent intent = new Intent(this, Chat_usuariosActivity.class);
        intent.putExtra("anuncio",h_nombrePromocion);
        intent.putExtra("nomPub",h_nomPub);
        intent.putExtra("imagen",v_imagen.getId());

        startActivity(intent);
    }
}
