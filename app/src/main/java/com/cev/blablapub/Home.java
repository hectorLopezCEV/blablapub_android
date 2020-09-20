package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Home extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // 1 // POSIBLE INTENTO DE UN ARRAYLIST PARA UNA LISTA DINAMICA////

    ListView listView;
    Pub[] negocios = new Pub[4];
    //1 ArrayList<Elemento> bares;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.i("bla","//////HOME_oncreate");

        /*
        logica para nuestro toolbar, le metemos un if como capa de seguridad
         */
        Toolbar toolbar = findViewById(R.id.mitoolbar);
        if (toolbar!=null){
            toolbar.setTitle(R.string.app_name);
            toolbar.setTitleTextColor(getResources().getColor(R.color.base));
            toolbar.setBackgroundColor(getResources().getColor(R.color.blanco));
            toolbar.inflateMenu( R.menu.menu_main);
        }




        // rellenamos el array de los bares/*
        negocios[0]= new Pub("BAR PLAZA",R.drawable.camarero, new Promocion("Promoción 2x1"));
        negocios[1]= new Pub("BAR ROLLING",R.drawable.rolling, new Promocion("Descuento del 10%"));
        negocios[2]= new Pub("BAR AVENIDA",R.drawable.brew, new Promocion("Barra libre de 21 a 22"));
        negocios[3]= new Pub("BAR CENTRAL", R.drawable.conil, new Promocion("Segunda persona entra gratis"));

        // asociamos la imagen a nuestro template
        listView = findViewById(R.id.lisv_listaImagenes);
        listView.setOnItemClickListener(this);

        // juntamos los datos de las imagenes y el listview con mi adapter
        MiAdapter miAdapter = new MiAdapter(this,R.layout.item,negocios);
        // le pasamos a la lista el adapter
        listView.setAdapter(miAdapter);
    }

    // click para la vista detalle
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(this,VistaDetalleBar.class);
        intent.putExtra("imagenList",this.negocios[i].imagen);
        intent.putExtra("nombreList",this.negocios[i].texto);
        intent.putExtra("nombrePromocion",this.negocios[i].promocion.titulo);
        startActivity(intent);
    }




}

