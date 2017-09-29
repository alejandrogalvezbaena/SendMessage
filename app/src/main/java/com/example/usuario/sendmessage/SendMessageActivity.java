package com.example.usuario.sendmessage;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Esta clase envia un mensjae de un usuario a otro
 * @author Alejandro Galvez Baena
 * Conceptos Aprendidos:
 * <ul>
 *     <li>Concepto Context</li>
 *     <li>Paso de parametros mediante el objeto @see android.os.Bundle</li>
 *     <li>Paso de mensajes entre dos actividades mediante la clase @see android.content.Intent</li>
 *     <li></li>
 *
 * </ul>
 */

public class SendMessageActivity extends AppCompatActivity {

    private EditText edtMessage;
    private EditText edtUser;
    private Button btnOK;
    private static final String TAG="com.example.sendmessage";
    com.example.usuario.sendmessage.pojo.Message miMensaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        edtMessage=(EditText) findViewById(R.id.edtMessage);
        edtUser=(EditText)findViewById(R.id.edtUser);
        btnOK=(Button)findViewById(R.id.btnOK);
        //1.Registrar un Listener o Escuchador OnClickListener
        btnOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                /*
                RECOGER LOS DATOS DE LOS COMPONENTES Y AÑADIRLOS AL BUNDLE
                //1. Crear objeto Bundle
                Bundle bundle=new Bundle();
                //2. Añadir al Bundle las variables
                bundle.putString("message", edtMessage.getText().toString() );
                bundle.putString("user", edtUser.getText().toString());
                //3. Crear un objeto Intent
                Intent intent =new Intent(SendMessageActivity.this, ViewMessageActivity.class);
                //3.1. Añadir el bundler
                intent.putExtras(bundle);
                */

                //METODO PARA RECOGER LOS DATOS Y AÑADIRLOS AL BUNDLE MEDIANTE UN OBJETO (por Parcelable)
                //Recoger las variables al pulsar el botón
                miMensaje = new com.example.usuario.sendmessage.pojo.Message(edtMessage.getText().toString(),edtUser.getText().toString());
                Bundle bundle=new Bundle();
                //Método Parcelable para pasar un objeto a otro Activity
                bundle.putParcelable("message", miMensaje);
                //Crear un objeto Intent
                Intent intent =new Intent(SendMessageActivity.this, ViewMessageActivity.class);
                //Añadir el bundler
                intent.putExtras(bundle);

                //Iniciar la Activity ViewMessage
                startActivity(intent);
            }
        });
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
        Log.d(TAG,"SendMessage: onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessage: onStart");
    }
//Metodología para asociar el metodo getOnClick a un botón en XML.
    /*
    public void  getOnClick(View view){
        switch (view.getId()){
            case R.id.btnOK:
                //1.Recoger el Mensaje
                //2. Crear un objeto Bundle y añadir el mensaje
                Bundle bundle=new Bundle();
                bundle.putString("message", edtMessage.getText().toString() );
                bundle.putString("user", edtUser.getText().toString());
                //3. Crear un objeto Intent
                Intent intent =new Intent(SendMessageActivity.this, ViewMessageActivity.class);
                //3.1. Añadir el bundler
                intent.putExtras(bundle);
                //4. Iniciar la Activity ViewMessage
                startActivity(intent);
                break;
        }
    }*/

}
