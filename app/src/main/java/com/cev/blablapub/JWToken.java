package com.cev.blablapub;

import com.google.gson.Gson;

public class JWToken {

    /**
     * Propiedades de la clase:
     * <p>
     * String access_token: token de acceso
     * String token_type: tipo de token recibido
     * String expires_in: tiempo de duración del token en segundos
     */
    String access_token;
    String token_type;
    int expires_in;

    /**
     * Constructor base para crear un objeto grupo vacío
     */
    public JWToken() {

    }

    /**
     * Constructor secundario en el que se pasan todos los parámetros de la clase
     *
     * @param access_token: token de acceso
     * @param token_type:   tipo de token recibido
     * @param expires_in:   tiempo de duración del token en segundos
     */
    public JWToken(String access_token, String token_type, int expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    /**
     * {@link JWToken#access_token}
     *
     * @return token de acceso
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     * {@link JWToken#access_token}
     *
     * @param access_token: token de acceso
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     * {@link JWToken#token_type}
     *
     * @return tipo de token recibido
     */
    public String getToken_type() {
        return token_type;
    }

    /**
     * {@link JWToken#token_type}
     *
     * @param token_type: tipo de token recibido
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    /**
     * {@link JWToken#expires_in}
     *
     * @return tiempo de duración del token en segundos
     */
    public int getExpires_in() {
        return expires_in;
    }

    /**
     * {@link JWToken#expires_in}
     *
     * @param expires_in: tiempo de duración del token en segundos
     */
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    /**
     * Transforma el objeto JWToken en un String JSON
     *
     * @return devuelve un JSON de la clase JWToken
     */
    public String toJson() {
        return new Gson().toJson(this);
    }

    /**
     * Transforma el JSON y guarda la información en JWToken
     *
     * @param json String de un JSON de token
     */
    public void fromJson(String json) {
        JWToken token = new Gson().fromJson(json, this.getClass());
        this.setAccess_token(token.access_token);
        this.setToken_type(token.token_type);
        this.setExpires_in(token.expires_in);
    }
}
