package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.View.ListAdapters.UsuarioListAdapter;
import com.itla.mudat.dao.anuncioDbo;
import com.itla.mudat.dao.usuarioDbo;

public class RegistroAnuncioActivity extends AppCompatActivity {


    EditText fecha;
    EditText condicion;
    EditText precio;
    EditText titulo;
    EditText ubicacion;
    EditText detalle;
    EditText idusuario;
    Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_anuncio);


        //capturando los campos de la actividad
        fecha = (EditText) findViewById(R.id.txtfecha);
        condicion = (EditText) findViewById(R.id.txtCondicion);
        precio = (EditText) findViewById(R.id.txtPrecio);
        titulo = (EditText) findViewById(R.id.txtTitulo);
        ubicacion = (EditText) findViewById(R.id.txtUbicacion);
        detalle = (EditText) findViewById(R.id.txtDetalle);
        idusuario = (EditText) findViewById(R.id.txtIdUsuario);

        anuncioDbo a = new anuncioDbo(this);
        a.buscarAnuncio();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            anuncio = (Anuncio) bundle.getSerializable("parametros");
            fecha.setText(anuncio.getFecha());
            condicion.setText(anuncio.getCondicion());
            precio.setText(anuncio.getPrecio().toString());
            titulo.setText(anuncio.getTitulo());
            ubicacion.setText(anuncio.getUbicacion());
            detalle.setText(anuncio.getDetalle());

        }




    }

    public void btnAgregarAnuncio_click(View view) {
        //instanciando la clase usuario
        Anuncio a= new Anuncio();
        //asignando los campos a las variables
        fecha.setText(fecha.getText().toString());
        condicion.setText(condicion.getText().toString());
        precio.setText(precio.getText().toString());
        titulo.setText(titulo.getText().toString());
        ubicacion.setText(ubicacion.getText().toString());
        detalle.setText(detalle.getText().toString());
        idusuario.setText(idusuario.getText().toString());
        // Log.i(LOG_T, "Registrando usuario:" + usuario.toString());
        anuncioDbo db = new anuncioDbo(this);


          if(  db.crear(a)==false){
              Toast.makeText(this,"Se creó correctamente",Toast.LENGTH_LONG).show();

          }else {Toast.makeText(this,"Se produjo un Error por favor verificar",Toast.LENGTH_LONG).show();}


}

    public void regAnuncio(View view) {
        startActivity(new Intent(this,RegistroAnuncioActivity.class));
    }



}