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
    Elemento[] negocios = new Elemento[5];
    //1 ArrayList<Elemento> bares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba2);

        // rellenamos el array de los bares/*
        negocios[0]= new Elemento("BAR PLAZA",R.drawable.camarero);
        negocios[1]= new Elemento("BAR ROLLING",R.drawable.rolling);
        negocios[2]= new Elemento("BAR AVENIDA",R.drawable.brew);
        negocios[3]= new Elemento("BAR CENTRAL", R.drawable.conil);




        // asociamos la imagen a nuestro template
        listView = findViewById(R.id.listaImagenes);
        listView.setOnItemClickListener(this);

        // juntamos los datos de las imagenes y el listview con mi adapter
        MiAdapter miAdapter = new MiAdapter(this,R.layout.item,negocios);
        // le pasamos a la lista el adapter
        listView.setAdapter(miAdapter);

/*      1
        bares = new ArrayList<Elemento>();
        bares.add(new Elemento("BAR OVIDIO",R.drawable.rolling));
        bares.add(new Elemento("BAR HECTOR",R.drawable.coche));
        bares.add(new Elemento("BAR GABRIELA",R.drawable.android));
        bares.add(new Elemento("DISCO CONIL",R.drawable.coche));
        bares.add(new Elemento("DISCO ALCALA",R.drawable.coche));
        bares.add(new Elemento("DISCO MOLA",R.drawable.coche));
        MiAdapter adapter = new MiAdapter(this,R.layout.item,bares);
        listView.setAdapter(adapter);
*/
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(this,VistaDetalleBar.class);
        intent.putExtra("imagenList",this.negocios[i].imagen);
        intent.putExtra("nombreList",this.negocios[i].texto);
        startActivity(intent);
        Log.d("milista","onclik funiona en prueba2"+i);
    }




}

