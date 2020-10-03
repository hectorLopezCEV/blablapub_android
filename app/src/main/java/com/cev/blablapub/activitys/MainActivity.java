package com.cev.blablapub.activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.CompoundButton;

import com.cev.blablapub.LoginService;
import com.cev.blablapub.R;
import com.cev.blablapub.activitys.LoginActivity;
import com.cev.blablapub.activitys.RegisterActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {
    public static final String EXTRA_MESSAGE = "com.cev.blablapub.activitys.RegisterActivity.MESSAGE";

    Button login;
    Button registro;
    Button recovery;
    ImageView imagenTarta;

    LinearLayout vistaLogin;
    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;



    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // añadimos el splash
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("bla","/////////////////MainActivity");

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

        //vistaLogin = findViewById(R.id.vistaLogin);
        loginEmail = findViewById(R.id.edt_mail);
        loginPassword = findViewById(R.id.edt_password);
        loginButton = findViewById(R.id.loginButton);



    }




    // metodo para ir al Activity Login

    public void irLogin(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    /*
   Oculta la presentación y visualiza los campos de entrada de datos
    */
    public void abrirRegistro(View vista) {

        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "message");
        startActivity(intent);
    }




    public void login(View view) {
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("email", this.loginEmail.getText().toString());
        parameters.put("password", this.loginPassword.getText().toString());

        LoginService loginService = new LoginService(this);

        loginService.execute(parameters);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        //TODO: hacer lo que sea cuando se cambie el checkbox
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        //TODO: hacer lo que sea cuando se cambie el checkbox
    }

    // TODO hay que conseguir un tamaño de la copa para cada dispositivo


}
