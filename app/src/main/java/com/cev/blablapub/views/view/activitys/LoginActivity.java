package com.cev.blablapub.views.view.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.cev.blablapub.views.view.views.DialogoLogin;
import com.cev.blablapub.R;
import com.cev.blablapub.modelos.RecuperarCon;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.cev.blablapub.com.cev.blablapub.views.activitys.views.com.cev.blablapub.com.cev.blablapub.views.activitys.views.activitys.activitys.RegisterActivity.MESSAGE";


    Button login;
    Button registro;
    Button recovery;
    ImageView imagenTarta;
    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;

    //todo quitar cuando tengamos el logeo a la bbdd terminada
    SharedPreferences shared;
    SharedPreferences.Editor editor;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i("bla","////////LOGIN_oncreate");

        /*
        logica de la Toolbar
        declaramos la Toolbar que hemos creado para manejarla en cada Activity
        la metemos dentro de un if para añadir una pequeña capa de seguridad
         */
        Toolbar toolbar = findViewById(R.id.mitoolbar);
        if (toolbar!=null){
            toolbar.setTitle(R.string.app_name);
        }

        // Se establecen las propiedades de este objeto
        login = findViewById(R.id.btn_login);
        registro = findViewById(R.id.btn_registro);
        recovery = findViewById(R.id.recovery);
        imagenTarta = findViewById(R.id.img_copa_recuperar_con);
        loginEmail = findViewById(R.id.edt_mail);
        loginPassword = findViewById(R.id.edt_password);
        loginButton = findViewById(R.id.loginButton);




    }

    // navigación desde pantalla main a pantalla home, falta poner condiciones antes de pasar de una pantalla a otra (login real)
    public void loginOnClick(View view){

        // todo sustituir por la base de datos
        // hacer que lo que introduzca el usuario se vaya a la bbdd
        // de momento solo harcodeo el login del usuario
        // y en el adapter del chat lo valido por el id, pudiendo sustituir el login como parametro de validacion


        // todo llamar a la bbdd y hacer la comprobacion del login
        // si el loin de la bbdd no es correcto mostramos el dialog yo lo harcodeo de momento con el null

            if (loginEmail.getText().toString().isEmpty()){ // si el login esta vacio mostramos el dialog

                DialogoLogin dialog = new DialogoLogin();
                dialog.show(getSupportFragmentManager(),"dialogo_login");

                Log.i("bla","///entra en el if y mostramos el dialog");
                // todo cambiar el boton de cancelar para que no nos lleve al Home
            }else{      // guardamos lo que hay escrito en la bd en este caso en la shared
                shared = getSharedPreferences("blablapub",MODE_PRIVATE);
                editor = shared.edit();
                editor.putString("login",loginEmail.getText().toString());
                editor.apply();
                this.startActivity(new Intent(this, Home.class));
                Log.i("bla","entra en el else y el valor del login enviando es = "+loginEmail.getText().toString());

            }


    }

    // metodo para navegar al Activiti recuperar contraseña
    public void recuperarCon (View view){
        Intent intent = new Intent(this, RecuperarCon.class);
        startActivity(intent);
    }


    // todo realizar un layout para esta pantalla
}