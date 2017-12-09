package com.itla.mudat;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.View.ListAdapters.CategoricalListAdapter;
import com.itla.mudat.dao.categoriaDbo;

public class ConsultaCategActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_categ);


        final categoriaDbo cat = new categoriaDbo(this);
        ListView listview = findViewById(R.id.listacategoria); //asignar la lista a una variable local tipo listview
        CategoricalListAdapter lisaAdaptor = new CategoricalListAdapter(cat.buscarc(), ConsultaCategActivity.this);//instanciando el listadapter
        listview.setAdapter(lisaAdaptor);//se le pasa el listadapter a listview de la actividad

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Categoria categoria = (Categoria) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(ConsultaCategActivity.this, RegistroAnuncioActivity.class);
                intent.putExtra("parametros", (Parcelable) categoria);
                startActivity(intent);
            }
        });



    }

    public void buscarc(View view) {

        startActivity(new Intent(this, RegistroCategoriaActivity.class));
    }
}


