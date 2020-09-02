package com.cev.blablapub;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.LinearLayout;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {
    public static final String EXTRA_MESSAGE = "com.cev.blablapub.RegisterActivity.MESSAGE";

    Button login;
    Button registro;
    Button recovery;
    ImageView imagenTarta;

    LinearLayout vistaLogin;
    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se establecen las propiedades de este objeto
        login = findViewById(R.id.login);
        registro = findViewById(R.id.registro);
        recovery = findViewById(R.id.recovery);
        imagenTarta = findViewById(R.id.imagenApp);

        vistaLogin = findViewById(R.id.vistaLogin);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);



    }
    /*
    metodo llamado al hacer click en el login
     */
    // todo preguntar a Hector si esto esta funcional o creamos un activity nuevo
    public void abrirLogin(View vista) {
        login.setVisibility(View.GONE);
        registro.setVisibility(View.GONE);

        vistaLogin.setVisibility(View.VISIBLE);

        loginEmail.setText("");
        loginPassword.setText("");
    }

    public void backToMain(View vista) {
        login.setVisibility(View.VISIBLE);
        registro.setVisibility(View.VISIBLE);

        vistaLogin.setVisibility(View.GONE);
    }

    public void login(View view) {
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("email", this.loginEmail.getText().toString());
        parameters.put("password", this.loginPassword.getText().toString());

        LoginService loginService = new LoginService(this);

        loginService.execute(parameters);
    }

    /*
    Oculta la presentación y visualiza los campos de entrada de datos
     */
    public void abrirRegistro(View vista) {
        //login.setVisibility(View.GONE);
        //registro.setVisibility(View.GONE);

        Intent intent = new Intent(this,RegisterActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "message");
        startActivity(intent);
    }

    // metodo para navegar al Activiti recuperar contraseña
    public void recuperarCon (View view){
        Intent intent = new Intent(this,RecuperarCon.class);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        //TODO: hacer lo que sea cuando se cambie el checkbox
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        //TODO: hacer lo que sea cuando se cambie el checkbox
    }

    // navigación desde pantalla main a pantalla home, falta poner condiciones antes de pasar de una pantalla a otra (login real)
    public void loginOnClick(View view){

        this.startActivity(new Intent(this, Prueba2.class));

    }



    public void prueba2(View view){
        Intent intent = new Intent(this,Prueba2.class);
        startActivity(intent);
    }
}
