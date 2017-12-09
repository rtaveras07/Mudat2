package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.View.ListAdapters.AnuncioListAdapter;
import com.itla.mudat.dao.anuncioDbo;

public class MainActivity extends AppCompatActivity {

   public static Usuario usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        anuncioDbo anunciodbo = new anuncioDbo(this);
        ListView listview = findViewById(R.id.ListaAununcio); //asignar la lista a una variable local tipo listview
        AnuncioListAdapter listaAdaptador = new AnuncioListAdapter(anunciodbo.buscarAnuncio(), MainActivity.this);//instanciando el listadapter
        listview.setAdapter(listaAdaptador);//se le pasa el listadapter a listview de la actividad
    }

    public void panelmainclic(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }
}
