package com.cev.blablapub;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VistaDetalleBar extends AppCompatActivity {
    //1 creamos las variables que vamos a modificar
    ImageView imagen;
    TextView nomNegocio;
    TextView anunNegocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_detalle_bar);
        Log.i("bla","/////VISTADETALLE_oncreate");

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }


        //2 asociamos las variables a los campos del xml
        imagen = findViewById(R.id.imagenDetalle);  // para mostrar al crearse
        anunNegocio = findViewById(R.id.anuncioNegocio);
        nomNegocio = findViewById(R.id.nombreNegocio);


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
}
