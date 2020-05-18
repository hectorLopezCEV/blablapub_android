package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Prueba extends AppCompatActivity {

    //1 variable para la id de una imagen
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        // 2 asociamos la imagen a una de la app
        imageView = findViewById(R.id.imagenPrueba);

    }

    // para navegar a la vista detalle y usar de prueba para una lista
    public void  prueba(View view){
        Intent intent = new Intent(this,VistaDetalleBar.class);
        intent.putExtra("javi","hola este es un mensaje que prueba el intent de la vista Prueba");
        startActivity(intent);


    }


}
