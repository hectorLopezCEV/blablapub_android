package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.cev.blablapub.RegisterActivity.MESSAGE";


    Button login;
    Button registro;
    Button recovery;
    ImageView imagenTarta;


    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Se establecen las propiedades de este objeto
        login = findViewById(R.id.btn_login);
        registro = findViewById(R.id.btn_registro);
        recovery = findViewById(R.id.recovery);
        imagenTarta = findViewById(R.id.img_copa);


        loginEmail = findViewById(R.id.edt_mail);
        loginPassword = findViewById(R.id.edt_password);
        loginButton = findViewById(R.id.loginButton);



    }

    // navigación desde pantalla main a pantalla home, falta poner condiciones antes de pasar de una pantalla a otra (login real)
    public void loginOnClick(View view){

        this.startActivity(new Intent(this, Prueba2.class));

    }






    // metodo para navegar al Activiti recuperar contraseña
    public void recuperarCon (View view){
        Intent intent = new Intent(this,RecuperarCon.class);
        startActivity(intent);
    }

    // todo realizar un layout para esta pantalla
}
