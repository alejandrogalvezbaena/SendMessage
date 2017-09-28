package com.example.usuario.sendmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Esta clase recibe un mensjae de un usuario y se muestra en pantalla
 * @author Alejandro Galvez Baena
 */

public class ViewMessageActivity extends AppCompatActivity {

    private TextView txvViewMessage;
    private TextView txvViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        txvViewMessage=(TextView)findViewById(R.id.txvViewMessage);
        txvViewUser=(TextView)findViewById(R.id.txvViewUser);
        //1. Recoger el Intent que se ha enviado
        Intent intent=getIntent();
        //2.Recoger el mensaje de Bundle
        Bundle bundle=intent.getExtras();
        //3.Mostrar mensaje
        txvViewMessage.setText(bundle.getString("message"));
        //Para refactorizar podriamos unir los tres pasos:
        //txvViewMessage.setText(getIntent().getExtras().getString("message"));
        txvViewUser.setText(String.format(getResources().getString(R.string.txvViewUser),bundle.getString("user")));




    }

}
