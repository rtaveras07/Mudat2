package com.itla.mudat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.Entity.TipodeUsuario;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.dao.usuarioDbo;

import static com.itla.mudat.dao.DbConection.LOG_T;

public class RegistroUsuarioActivity extends AppCompatActivity {


    EditText nombre;
    EditText tipoUsuario;
    EditText  idIdentificacion;
    EditText email;
    EditText telefono;
    EditText clave;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //opteniendo los objetos campos
        nombre = (EditText) findViewById(R.id.txtNombres);
        tipoUsuario = (EditText) findViewById(R.id.txtTipoUsuario);
        idIdentificacion =  findViewById(R.id.txtidentificacion);
        email = (EditText) findViewById(R.id.txtemail);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        clave = (EditText) findViewById(R.id.txtClave);

        usuarioDbo u = new usuarioDbo(this);
        u.buscar();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            usuario = (Usuario) bundle.getSerializable("param");
            nombre.setText(usuario.getNombre());
            tipoUsuario.setText(usuario.getTipoUsuario().toString());
            idIdentificacion.setText(idIdentificacion.getText().toString());
            email.setText(usuario.getEmail());
            telefono.setText(usuario.getTelefono());
            clave.setText(usuario.getClave());

        }


    }

    public void Aceptar(View view) {


        //instanciando la clase usuario
        usuario = new Usuario();
        //asignando los campos a las variables
        usuario.setNombre(nombre.getText().toString());
        //tipo de usuario cliente
        usuario.setTipoUsuario(TipodeUsuario.CLIENTE);
       usuario.setIdIdentificacion(Integer.parseInt(idIdentificacion.getText().toString()));
        usuario.setClave(clave.getText().toString());
        usuario.setTelefono(telefono.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setTipoUsuario(TipodeUsuario.CLIENTE);
       // Log.i(LOG_T, "Registrando usuario:" + usuario.toString());
        usuarioDbo db = new usuarioDbo(this);


       /*  if(null == usuario.getIdUsuario()){
             db.crear(usuario);
         }
         else {
             db.editar(usuario);
         }
*/

       if(db.crear(usuario)==false){

           Toast.makeText(this,"Datos insertados correctamente",Toast.LENGTH_LONG).show();
       }else {

           Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
       }


    }


}
