package com.cev.blablapub;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cev.blablapub.activitys.Home;
import com.cev.blablapub.activitys.RegisterActivity;
import com.cev.blablapub.modelos.Usuario;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoLogin extends DialogFragment {



    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2 creamos un inflador de xml
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // creamos la vista
        View dialogView = inflater.inflate(R.layout.dialogo_login,null);

        TextView titulo = dialogView.findViewById(R.id.txv_login_titulo);
        TextView mensaje = dialogView.findViewById(R.id.txv_login_mensaje);
        Button btnRegistro = dialogView.findViewById(R.id.btn_login_registro);
        Button btnCancelar = dialogView.findViewById(R.id.btn_login_cancelar);

        builder.setView(dialogView);
            btnRegistro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),RegisterActivity.class);
                    startActivity(intent);
                    dismiss();
                }
            });
            btnCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Home.class);
                    startActivity(intent);
                    dismiss();
                }
            });

        return builder.create();
    }
}
