package com.cev.blablapub;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VistaDetalleBar extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //1 creamos las variables que vamos a modificar
    ImageView imagen;
    TextView nomNegocio;
    TextView anunNegocio;
    Toolbar toolbar;
    ImageView imgFlecha;
    GridView gridView;
    // creamos un array de usuarios para pasarlos al adapter
    ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_detalle_bar);
        Log.i("bla","/////VISTADETALLE_oncreate");

        /*
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

         */
        //2 asociamos las variables a los campos del xml
        imagen = findViewById(R.id.imagenDetalle);  // para mostrar al crearse
        anunNegocio = findViewById(R.id.anuncioNegocio);
        nomNegocio = findViewById(R.id.nombreNegocio);
        imgFlecha = findViewById(R.id.imv_flecha);
        gridView = findViewById(R.id.grid_usuarios);
        gridView.setOnItemClickListener(this);

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

        // creamos el objeto adapter y le ponemos un onClickListener
        GridAdapter miAdapter = new GridAdapter(this,R.layout.grid_layout,usuarios);
        gridView.setAdapter(miAdapter);


        // recibo del activity prueba el src
        Intent intent = getIntent();
        String texto = intent.getStringExtra("javi");
        //Toast.makeText(this, texto, Toast.LENGTH_LONG).show();

        // variable para la imagen que viene de prueba2
        int imagenList = intent.getIntExtra("imagenList", 0);
        String nombreList = intent.getStringExtra("nombreList");
        // compruebo el contenido del inten
        String nombrePromocion = intent.getStringExtra("nombrePromocion");
        imagen.setImageResource(imagenList);
        nomNegocio.setText(nombreList);
        anunNegocio.setText(nombrePromocion);



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

        Intent intent = new Intent(this,Chat_usuariosActivity.class);

        startActivity(intent);
    }
}
