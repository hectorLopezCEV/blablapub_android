package com.cev.blablapub.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cev.blablapub.R;

public class Chat_usuariosActivity extends AppCompatActivity  {

    // declaraciones
    private ImageView fecla;
    private ListView listView;
    private ImageView imageView;
    private TextView nomPub;
    private TextView anuncioPub;


    public ImageView getFecla() {
        return fecla;
    }

    public void setFecla(ImageView fecla) {
        this.fecla = fecla;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_usuarios);
        Log.i("bla","////////Chat usuatios");

        // instancias
        fecla = findViewById(R.id.img_chat_flecha);
        listView = findViewById(R.id.lisv_chat);
        imageView = findViewById(R.id.img_chat_imagenDetalle);
        anuncioPub = findViewById(R.id.txv_chat_anuncioNegocio);
        nomPub = findViewById(R.id.txv_nombre_establecimiento);

        // implementamos las vistas

        // compruebo el contenido del inten
        Intent intent = getIntent();
        int imagenList = intent.getIntExtra("imagen", 0);
        String nombreList = intent.getStringExtra("nomPub");
        String nombrePromocion = intent.getStringExtra("anuncio");
        //imageView.setImageResource(imagenList); // todo esta imagen hay que cogerla de la base de datos
        //nomPub.setText("nombreList");
        //anuncioPub.setText("nombrePromocion");

    }




    public void volverVistaDetalle(View v){
        finish();
    }
}
