package com.example.usuario.sendmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.usuario.sendmessage.pojo.Message;

/**
 * Esta clase recibe un mensjae de un usuario y se muestra en pantalla
 * @author Alejandro Galvez Baena
 */

public class ViewMessageActivity extends AppCompatActivity {

    private TextView txvViewMessage;
    private TextView txvViewUser;
    private static final String TAG="com.example.sendmessage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        txvViewMessage=(TextView)findViewById(R.id.txvViewMessage);
        txvViewUser=(TextView)findViewById(R.id.txvViewUser);

        /*
        RECOGER LAS VARIABLES DEL ACTIVITY SendMessage
        //1. Recoger el Intent que se ha enviado
        Intent intent=getIntent();
        //2.Recoger el mensaje de Bundle
        Bundle bundle=intent.getExtras();
        //3.Mostrar mensaje
        txvViewMessage.setText(bundle.getString("message"));
        txvViewUser.setText(String.format(getResources().getString(R.string.txvViewUser),bundle.getString("user")));
        //Para refactorizar podriamos unir los tres pasos:
        txvViewMessage.setText(getIntent().getExtras().getString("message"));
        */

        //Metodo Parcelable
        Message miMensaje=(Message)getIntent().getExtras().getParcelable("message");
        txvViewMessage.setText(miMensaje.getMessage());
        txvViewUser.setText(miMensaje.getUser());


        Log.d(TAG, "SendMessage: onCreate");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessage: onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessage: onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessage: onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessage: onStart");
    }

}
