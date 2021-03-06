package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText nombre;
    EditText apellidos;
    EditText edad;
    EditText email;
    RadioGroup sexo;
    RadioButton hombre;
    RadioButton mujer;
    RadioButton na;
    CheckBox siHaAceptadoPoliticaUso;
    Button registrarme;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        Log.i("bla","/////////////REGISTERACTIVITY_oncreate");



        email = findViewById(R.id.txv_email_recu_con);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellido);
        edad = findViewById(R.id.edad);
        sexo = findViewById(R.id.sexo);
        siHaAceptadoPoliticaUso = findViewById(R.id.aceptarCondiciones);
        registrarme = findViewById(R.id.btn_registro);
        password = findViewById(R.id.password);
        hombre = findViewById(R.id.hombre);
        mujer = findViewById(R.id.mujer);
        na = findViewById(R.id.na);
    }
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
        // todo revisar esta logica porque sale un Toast que no deveria de salir
        todoDatosOK = (nombre.getText().length() > 0) && (apellidos.getText().length() > 0) && (edad.getText().length() > 0)
                && (hombre.isChecked() || mujer.isChecked()) &&
                ((siHaAceptadoPoliticaUso.isChecked()) ||
                        (siHaAceptadoPoliticaUso.isChecked() == false));

        todoOK = todoDatosOK && edadOK;
        //Si tod o bien guardar
        if (todoOK) {
             toastOK.show();
        }
        if (!todoDatosOK) {
            toastKO.show();
        }
        if (todoDatosOK && !edadOK) {
            toastMenorEdad.show();
        }

        //
        if(todoOK){
            PetitionsPost petitionsPost = new PetitionsPost(this);
            String url = getString(R.string.app_url)+"user";
            String name = nombre.getText().toString()+" "+ apellidos.getText().toString();
            petitionsPost.execute(url,name,email.getText().toString(),password.getText().toString(),edad.getText().toString(),hombre.isChecked()?"hombre":"mujer");

            // navegamos a la pantalla de login
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }else{
            toastKO.show();
            Log.i("bla","////no entra en el if y no navegamos a login");
        }

    }

    // todo realizar un layout en horizontal para esta pantalla

}
