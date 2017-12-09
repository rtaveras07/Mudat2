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
import com.itla.mudat.View.ListAdapters.UsuarioListAdapter;
import com.itla.mudat.dao.anuncioDbo;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RegistroAnuncioActivity extends AppCompatActivity {


    String fecha;
    EditText condicion;
    EditText precio;
    EditText titulo;
    EditText ubicacion;
    EditText detalle;
    Integer idusuario;
    Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_anuncio);
        Date curDate = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        String DateToStr = format.format(curDate);


        //capturando los campos de la actividad
        fecha = DateToStr.toString();
        condicion = (EditText) findViewById(R.id.txtCondicion);
        precio = (EditText) findViewById(R.id.txtPrecio);
        titulo = (EditText) findViewById(R.id.txtTitulo);
        ubicacion = (EditText) findViewById(R.id.txtUbicacion);
        detalle = (EditText) findViewById(R.id.txtDetalle);
        idusuario = 1234;

        //anuncioDbo a = new anuncioDbo(this);
        //a.buscarAnuncio();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            anuncio = (Anuncio) bundle.getSerializable("param");
           //fecha.setText(anuncio.getFecha().toString());
        condicion.setText(anuncio.getCondicion().toString());
            precio.setText(anuncio.getPrecio().toString());
            titulo.setText(anuncio.getTitulo().toString());
            ubicacion.setText(anuncio.getUbicacion().toString());
            detalle.setText(anuncio.getDetalle().toString());
        // idusuario.setText((anuncio.getIdusuario().toString()));

        }


    }

    public void btnAgregarAnuncio_click(View view) {

        //asignando los campos a las variables
        anuncio.setFecha(fecha);
        anuncio.setCondicion(condicion.getText().toString());
        anuncio.setPrecio(Double.parseDouble(precio.getText().toString()));
        anuncio.setTitulo(titulo.getText().toString());
        anuncio.setUbicacion(ubicacion.getText().toString());
        anuncio.setDetalle(detalle.getText().toString());
        anuncio.setIdusuario(MainActivity.usuarioActual.getIdUsuario());

        anuncioDbo db = new anuncioDbo(this);




        Boolean paso = false;
        if (null==anuncio.getId()) {
            paso = db.crear(anuncio);
        } else {
            paso =    db.editarrAnuncio(anuncio);

        }

        if (paso)
            Toast.makeText(this, "Se guardó correctamente ", Toast.LENGTH_LONG).show();







    }

    public void regAnuncio(View view) {
        startActivity(new Intent(this, RegistroAnuncioActivity.class));
    }


}