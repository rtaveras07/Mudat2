package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.View.ListAdapters.AnuncioListAdapter;

import com.itla.mudat.View.ListAdapters.UsuarioListAdapter;
import com.itla.mudat.dao.anuncioDbo;
import com.itla.mudat.dao.usuarioDbo;

import java.io.Serializable;

public class ConsultaAnuncioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_anuncio);


        anuncioDbo anunciodbo = new anuncioDbo(this);
        ListView listview = findViewById(R.id.ListaAununcio); //asignar la lista a una variable local tipo listview
        AnuncioListAdapter listaAdaptador = new AnuncioListAdapter(anunciodbo.buscarAnuncio(MainActivity.usuarioActual.getIdUsuario().toString()), ConsultaAnuncioActivity.this);//instanciando el listadapter
        listview.setAdapter(listaAdaptador);//se le pasa el listadapter a listview de la actividad

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Anuncio anuncio = (Anuncio) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(ConsultaAnuncioActivity.this, RegistroAnuncioActivity.class);
                intent.putExtra("param", anuncio);
                startActivity(intent);
            }
        });
    }

    public void bntRegistroAnuncio(View view) {
        startActivity(new Intent(this, RegistroAnuncioActivity.class));

    }
}
