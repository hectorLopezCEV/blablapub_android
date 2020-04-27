package com.cev.blablapub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {

    Button login;
    Button registro;
    Button recovery;
    ImageView imagenTarta;

    LinearLayout vistaLogin;
    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;

    LinearLayout vistaRegistro;
    EditText nombre;
    EditText apellidos;
    EditText edad;
    RadioGroup sexo;
    RadioButton hombre;
    RadioButton mujer;
    CheckBox siHaAceptadoPoliticaUso;
    Button registrarme;


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

        vistaRegistro = findViewById(R.id.vistaRegistro);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);
        sexo = findViewById(R.id.sexo);
        siHaAceptadoPoliticaUso = findViewById(R.id.aceptarCondiciones);
        registrarme = findViewById(R.id.registrarse);

        siHaAceptadoPoliticaUso.setOnCheckedChangeListener(this);
    }

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

    /*
    Oculta la presentación y visualiza los campos de entrada de datos
     */
    public void abrirRegistro(View vista) {
        login.setVisibility(View.GONE);
        registro.setVisibility(View.GONE);

        vistaRegistro.setVisibility(View.VISIBLE);

        nombre.setText("");
        apellidos.setText("");
        edad.setText("");
        sexo.clearCheck();

        siHaAceptadoPoliticaUso.setChecked(false);
    }

    /*
    Oculta los campos de datos y visualiza la presentación
     */
    public void ocultaRegistro(View vista) {
        imagenTarta.setVisibility(View.VISIBLE);
        registro.setVisibility(View.VISIBLE);

        vistaRegistro.setVisibility(View.GONE);
    }


    /*
    Comprueba si todos los datos necesarios se han rellenado
    y si es así muestra el Toast correspondiente y oculta los campos de datos
    y visualiza la presntación para permitir otro registro
     */
    public void inscribirse(View vista) {
        Toast toastKO = Toast.makeText(this, "Faltan datos. Por favor complete la información solicitada",
                Toast.LENGTH_LONG);
        Toast toastOK = Toast.makeText(this, "Gracias " + nombre.getText() + " ¡La inscripción se ha hecho con éxito!",
                Toast.LENGTH_LONG);

        Toast toastMenorEdad = Toast.makeText(this, "Los participantes deben ser mayores de edad",
                Toast.LENGTH_LONG);

        int edadConcursante = 0;
        boolean edadOK = false;
        if (edad.getText().length() > 0) {
            edadConcursante = Integer.parseInt(edad.getText().toString());
        }
        if (edadConcursante >= 18) {
            edadOK = true;
        }

        boolean todoOK = false;
        boolean todoDatosOK = false;

        todoDatosOK = (nombre.getText().length() > 0) && (apellidos.getText().length() > 0) && (edad.getText().length() > 0)
                && (hombre.isChecked() || mujer.isChecked()) &&
                ((siHaAceptadoPoliticaUso.isChecked()) ||
                        (siHaAceptadoPoliticaUso.isChecked() == false));

        todoOK = todoDatosOK && edadOK;
        //Si tod o bien guardar
        if (todoOK) {
            toastOK.show();
            ocultaRegistro(vista);
        }
        if (!todoDatosOK) {
            toastKO.show();
        }
        if (todoDatosOK && !edadOK) {
            toastMenorEdad.show();
        }

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
}
