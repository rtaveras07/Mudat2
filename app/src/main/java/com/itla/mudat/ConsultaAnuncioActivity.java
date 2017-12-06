package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.View.ListAdapters.UsuarioListAdapter;
import com.itla.mudat.dao.anuncioDbo;
import com.itla.mudat.dao.usuarioDbo;

public class ConsultaAnuncioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_anuncio);

    }
  /*  anuncioDbo u=new anuncioDbo(this);
    ListView list= findViewById(R.id.listaAununcio);
    UsuarioListAdapter a=new UsuarioListAdapter(u.buscar(),this);
        list.setAdapter(a);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Anuncio anuncio = (Anuncio) adapterView.getItemAtPosition(i);

            Intent kk= new Intent(RegistroAnuncioActivity.this,ConsultaAnuncioActivity.class);
            kk.putExtra("param",anuncio);
            startActivity(kk);
        }
    });

*/







    public void bntRegistroAnuncio(View view) {
        startActivity(new Intent(this,RegistroAnuncioActivity.class));

    }
}
