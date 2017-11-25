package com.itla.mudat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.itla.mudat.Entity.TipodeUsuario;
import com.itla.mudat.Entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {


    EditText nombre;
    EditText tipoUsuario;
    EditText identificacion;
    EditText email;
    EditText telefono;
    EditText clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);




    }


    public void Aceptar(View view) {
        //opteniendo los objetos campos
        nombre = (EditText) findViewById(R.id.txtNombres);
        tipoUsuario = (EditText) findViewById(R.id.txtTipoUsuario);
        identificacion=(EditText) findViewById(R.id.txtidentificacion);
        email=(EditText) findViewById(R.id.txtemail);
        telefono=(EditText) findViewById(R.id.txtTelefono);
        clave=(EditText) findViewById(R.id.txtClave);
        //instanciando la clase usuario
        Usuario usuario=new Usuario();
        //asignando los campos a las variables
        usuario.setNombre(nombre.getText().toString());
        //tipo de usuario cliente
        usuario.setTipoUsuario(TipodeUsuario.CLIENTE);
        usuario.setIdIdentificacion(Integer.parseInt(identificacion.getText().toString()));
        usuario.setClave(clave.getText().toString());
        usuario.setTelefono(telefono.getText().toString());
        usuario.setEmail(email.getText().toString());


    }






}
