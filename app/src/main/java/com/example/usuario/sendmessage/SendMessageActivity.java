package com.example.usuario.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                Bundle bundle=new Bundle();
                bundle.putString("message", edtMessage.getText().toString() );
                bundle.putString("user", edtUser.getText().toString());
                //3. Crear un objeto Intent
                Intent intent =new Intent(SendMessageActivity.this, ViewMessageActivity.class);
                //3.1. Añadir el bundler
                intent.putExtras(bundle);
                //4. Iniciar la Activity ViewMessage
                startActivity(intent);
            }
        });


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
