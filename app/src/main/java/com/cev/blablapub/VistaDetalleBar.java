package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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



        //2 asociamos las variables a los campos del xml
        imagen = findViewById(R.id.imagenDetalle);  // para mostrar al crearse
        anunNegocio = findViewById(R.id.anuncioNegocio);
        nomNegocio = findViewById(R.id.nombreNegocio);




        // recibo del activity prueba el src
        Intent intent = getIntent();
        String texto = intent.getStringExtra("javi");
        Toast.makeText(this,texto,Toast.LENGTH_LONG).show();

        // variable para la imagen que viene de prueba2
        int imagenList = intent.getIntExtra("imagenList",0);
        // compruebo el contenido del inten
        Log.d("milista","contenido recivido: "+imagenList);
        //imagen.setImageResource(imagenList);




    }

    //3 metodo de prueba para cambiar la imagen
    public void cambiarImagen(View view)
    {
        //4 llenamos la variables con el valor que queremos
        imagen.setImageResource(R.drawable.conil);
        nomNegocio.setText("disco javi");
        anunNegocio.setText("gratis las rayas");

    }
}
