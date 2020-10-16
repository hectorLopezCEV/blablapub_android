package com.cev.blablapub.modelos;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellidos;
    private int imagen;
    private String nick;
    private String login;
    private int id;
    private String email;
    private String password;
    private String confirmarPassword;
    private boolean hombre;
    private boolean mujer;
    private boolean n_a;
    private int edad;
    private boolean conectado;
    private int imagen_por_defecto;
    private String mensaje;


    // todo valorar con Hector si hacemos la validacion con el login o con el id?
    // ya sea para el chat o para el resto de cosas de momento lo harcodeo con el login de las sahred

    // constructor para el Registro
    public Usuario(String nombre,String apellidos, int id, String email, String password,String confirmarPassword,boolean hombre,boolean mujer,boolean n_a, int imagen_por_defecto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.email = email;
        this.password = password;
        this.hombre = hombre;
        this.mujer = mujer;
        this.n_a = n_a;
        this.confirmarPassword = confirmarPassword;
        this.imagen_por_defecto = imagen_por_defecto;
    }

    // constructor solo para los mensajes
    public Usuario(String mensaje) {
        this.mensaje = mensaje;
    }

    // constructor
    public Usuario() {
    }

    // constructor para el layout de los demas usuario siii le ponemos un nick( que no es que me guste mucho)
    public Usuario(int imagen, String nick,String mensaje){
        this.imagen = imagen;
        this.nick = nick;
        this.mensaje = mensaje;
    }  // constructor


    public Usuario(int imagen, String mensaje){
        this.imagen = imagen;
        this.mensaje = mensaje;
    }

    // constructor


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getImagen_por_defecto() {
        return imagen_por_defecto;
    }

    public void setImagen_por_defecto(int imagen_por_defecto) {
        this.imagen_por_defecto = imagen_por_defecto;
    }

    // lo paso a String con tojson
    public String toJson(Gson gson){
        Gson gson1 = new Gson();
        String json = gson1.toJson(this);
        return json;
    }

    // lo paso a objeto con fromJson
    public Usuario fromJson(String json){
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(json,Usuario.class);
        return usuario;
    }




}

////// preguntar a Hector si quiere aqui la logica o en el servidor del backend
