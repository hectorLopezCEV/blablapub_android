package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Prueba2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // 1 // POSIBLE INTENTO DE UN ARRAYLIST PARA UNA LISTA DINAMICA////

    ListView listView;
    Elemento[] negocios = new Elemento[4];
    //1 ArrayList<Elemento> bares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba2);

        // rellenamos el array de los bares/*
        negocios[0]= new Elemento("BAR PLAZA",R.drawable.camarero, new Promocion("Promoción 2x1"));
        negocios[1]= new Elemento("BAR ROLLING",R.drawable.rolling, new Promocion("Descuento del 10%"));
        negocios[2]= new Elemento("BAR AVENIDA",R.drawable.brew, new Promocion("Barra libre de 21 a 22"));
        negocios[3]= new Elemento("BAR CENTRAL", R.drawable.conil, new Promocion("Segunda persona entra gratis"));

        // asociamos la imagen a nuestro template
        listView = findViewById(R.id.listaImagenes);
        listView.setOnItemClickListener(this);

        // juntamos los datos de las imagenes y el listview con mi adapter
        MiAdapter miAdapter = new MiAdapter(this,R.layout.item,negocios);
        // le pasamos a la lista el adapter
        listView.setAdapter(miAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(this,VistaDetalleBar.class);
        intent.putExtra("imagenList",this.negocios[i].imagen);
        intent.putExtra("nombreList",this.negocios[i].texto);
        intent.putExtra("nombrePromocion",this.negocios[i].promocion.titulo);
        startActivity(intent);
        Log.d("milista","onclik funiona en prueba2"+i);
    }




}

