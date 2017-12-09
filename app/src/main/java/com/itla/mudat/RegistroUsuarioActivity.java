package com.itla.mudat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.mudat.Entity.TipodeUsuario;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.dao.usuarioDbo;

import static com.itla.mudat.dao.DbConection.LOG_T;

public class RegistroUsuarioActivity extends AppCompatActivity {


    EditText nombre;
    Spinner tipouser;
    EditText ididentificacion;
    EditText email;
    EditText telefono;
    EditText clave;

    Usuario usuario;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        usuario = new Usuario();
        llenarSpiner();

        //opteniendo los objetos campos
        nombre = (EditText) findViewById(R.id.txtNombres);
        ididentificacion = (EditText) findViewById(R.id.txtidentificacion);
        email = (EditText) findViewById(R.id.txtemail);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        clave = (EditText) findViewById(R.id.txtClave);

        // usuarioDbo u = new usuarioDbo(this);
        //u.buscar();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            usuario = (Usuario) bundle.getSerializable("param");
            // usuario = (Usuario) bundle.getSerializable(Usuario.class.getSimpleName());
            nombre.setText(usuario.getNombre().toString());
            tipouser.setSelection(adapter.getPosition(usuario.getTipoUsuario()));
            ididentificacion.setText(usuario.getIdIdentificacion().toString());
            email.setText(usuario.getEmail().toString());
            telefono.setText(usuario.getTelefono().toString());
            clave.setText(usuario.getClave().toString());

        }


    }

    private void llenarSpiner() {
        tipouser=findViewById(R.id.tipoUser);

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,TipodeUsuario.values());
        tipouser.setAdapter(adapter);
    }

    public void Aceptar(View view) {


        //instanciando la clase usuario
        //asignando los campos a las variables

        usuario.setNombre(nombre.getText().toString());


        usuario.setIdIdentificacion(ididentificacion.getText().toString());
        usuario.setClave(clave.getText().toString());
        usuario.setTipoUsuario((TipodeUsuario)adapter.getItem(tipouser.getSelectedItemPosition()));
        usuario.setTelefono(telefono.getText().toString());
        usuario.setEmail(email.getText().toString());

        //  Log.i(LOG_T, "Registrando usuario:" +  usuario.getIdIdentificacion());
        usuarioDbo db = new usuarioDbo(this);


        Boolean paso = false;
        if (null == usuario.getIdUsuario()) {
            paso = db.crear(usuario);
        } else {
            paso = db.editar(usuario);

        }

        if (paso)
            Toast.makeText(this, "Se guardó correctamente ", Toast.LENGTH_LONG).show();


    }


}
