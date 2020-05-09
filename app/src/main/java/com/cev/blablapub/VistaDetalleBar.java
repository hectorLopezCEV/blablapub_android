package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class VistaDetalleBar extends AppCompatActivity {
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_detalle_bar);

        imagen = findViewById(R.id.imagenDetalle);
    }

    // metodo de prueba para cambiar la imagen
    public void cambiarImagen(View view){
        imagen.setImageResource(R.drawable.interior);
    }
}
