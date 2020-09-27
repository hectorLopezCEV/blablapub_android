package com.cev.blablapub;

import android.os.AsyncTask;

import com.cev.blablapub.activitys.MainActivity;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.OkHttpClient;
import okhttp3.MultipartBody;

public class LoginService extends AsyncTask<HashMap<String, String>, Void, JWToken> {

    private String loginRoute;

    /**
     * WeakReference<BandsActivity> bandsActivity: Actividad principal en la que se mostrará la
     * información obtenida del endpoint (Se hace una WeakReference, por si se sale de la vista no
     * haya fallos de perdidas de información)
     */
    private WeakReference<MainActivity> mainActivity;

    /**
     * Se instancian las rutas que se quieran crear en el constructor
     */
    public LoginService(MainActivity mainActivity) {
        this.mainActivity = new WeakReference<>(mainActivity);
        this.loginRoute = mainActivity.getString(R.string.app_url) + "login";
    }

    @Override
    protected JWToken doInBackground(HashMap... parametersArray) {
        HashMap<String, String> parameters = parametersArray[0];
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", parameters.get("email") == null ? "" : parameters.get("email"))
                .addFormDataPart("password", parameters.get("password") == null ? "" : parameters.get("email"))
                .build();
        Request request = new Request.Builder()
                .url(this.loginRoute)
                .post(requestBody)
                .build();

        JWToken token = new JWToken();
        try {
            // Se ejecuta la petición GET y con la respuesta, se transforma de JSON al objeto
            // BandsList
            Response response = okHttpClient.newCall(request).execute();
            token.fromJson(response.body().string());
        } catch (Exception e) {
            // Si diera error al ejecutarse la llamada o al transformar el JSON se devuelve una
            // lista de grupos nula para poder manejar el mostrar el mensaje de error
            token = null;
        }
        return token;
    }

    @Override
    protected void onPostExecute(JWToken jwToken) {
        MainActivity mainActivity;
        if (this.mainActivity.get() != null) {
            mainActivity = this.mainActivity.get();
        } else {
            return;
        }

        if (jwToken == null) {
            return;
        } else {
            // TODO: mostrar la nueva vista cuando se termine la ejecución de manera correcta
            // mainActivity.startActivity(mapsIntent);
        }
    }
}
