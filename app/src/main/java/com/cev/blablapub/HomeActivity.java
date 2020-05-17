package com.cev.blablapub;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class HomeActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ListView menulateral;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.home_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        menulateral = findViewById(R.id.navView);
        menulateral.setOnItemClickListener(this);

        cambiarPantalla(0);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        drawerToggle.onOptionsItemSelected(item);

        return true;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cambiarPantalla(position);
    }

    public void cambiarPantalla (int i){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (i){
            case 0:
                setTitle("Inicio");
                 transaction.replace(R.id.contenido, new FragmentInicio());
                break;
            case 1:
                setTitle("Perfil");
                transaction.replace(R.id.contenido, new FragmentPerfil());
                break;
            case 2:
                setTitle("Ajustes");
                // transaction.replace(R.id.contenido, new FragmentAjustes());      ACTIVAR CUANDO SE HAYAN CREADO LOS FRAGMENTS
                break;

        }
        transaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
