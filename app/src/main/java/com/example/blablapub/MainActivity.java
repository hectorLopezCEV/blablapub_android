package com.example.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public abstract class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {



    Button registro;
    ImageView imagenTarta;

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


        registro = findViewById(R.id.registro);
        imagenTarta = findViewById(R.id.imagenApp);

        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);
        sexo = findViewById(R.id.sexo);
        hombre = findViewById(R.id.hombre);
        mujer = findViewById(R.id.mujer);
        siHaAceptadoPoliticaUso = findViewById(R.id.aceptarCondiciones);
        registrarme = findViewById(R.id.registrarse);

        siHaAceptadoPoliticaUso.setOnCheckedChangeListener(this);
    }

    /*
    Oculta la presentación y visualiza los campos de entrada de datos
     */
    public void abrirRegistro(View vista){

        registro.setVisibility(View.GONE);

        nombre.setVisibility(View.VISIBLE);
        nombre.setText("");
        apellidos.setVisibility(View.VISIBLE);
        apellidos.setText("");
        edad.setVisibility(View.VISIBLE);
        edad.setText("");
        sexo.setVisibility(View.VISIBLE);
        sexo.clearCheck();

        siHaAceptadoPoliticaUso.setVisibility(View.VISIBLE);
        siHaAceptadoPoliticaUso.setChecked(false);
        registrarme.setVisibility(View.VISIBLE);
    }

    /*
    Oculta los campos de datos y visualiza la presentación
     */
    public void ocultaRegistro(View vista){
        imagenTarta.setVisibility(View.VISIBLE);
        registro.setVisibility(View.VISIBLE);

        nombre.setVisibility(View.GONE);
        apellidos.setVisibility(View.GONE);
        edad.setVisibility(View.GONE);
        sexo.setVisibility(View.GONE);
        siHaAceptadoPoliticaUso.setVisibility(View.GONE);
        registrarme.setVisibility(View.GONE);
    }



    /*
    Comprueba si todos los datos necesarios se han rellenado
    y si es así muestra el Toast correspondiente y oculta los campos de datos
    y visualiza la presntación para permitir otro registro
     */
    public void inscribirse(View vista){
        Toast toastKO = Toast.makeText(this,"Faltan datos. Por favor complete la información solicitada",
                Toast.LENGTH_LONG);
        Toast toastOK = Toast.makeText(this,"Gracias "+nombre.getText()+" ¡La inscripción se ha hecho con éxito!",
                Toast.LENGTH_LONG);

        Toast toastMenorEdad = Toast.makeText(this,"Los participantes deben ser mayores de edad",
                Toast.LENGTH_LONG);

        int edadConcursante=0;
        boolean edadOK = false;
        if( edad.getText().length()>0 ) {
            edadConcursante = Integer.parseInt(edad.getText().toString());
        }
        if(edadConcursante <18){
            edadOK = false;
        }else{
            edadOK = true;
        }

        boolean todoOK = false;
        boolean todoDatosOK = false;

        todoDatosOK = (nombre.getText().length() > 0) && (apellidos.getText().length() > 0) && (edad.getText().length() > 0)
                && ( hombre.isChecked() || mujer.isChecked()) &&
                ( (siHaAceptadoPoliticaUso.isChecked() ) ||
                        (siHaAceptadoPoliticaUso.isChecked()==false) );

        todoOK = todoDatosOK && edadOK;
        //Si todo bien guardar
        if(todoOK) {
            toastOK.show();
            ocultaRegistro(vista);
        }
        if(!todoDatosOK){
            toastKO.show();
        }
        if(todoDatosOK && !edadOK){
            toastMenorEdad.show();
        }

    }
}