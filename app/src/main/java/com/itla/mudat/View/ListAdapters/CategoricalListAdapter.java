package com.itla.mudat.View.ListAdapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Owner on 12/08/2017.
 */

public class CategoricalListAdapter extends BaseAdapter {
    private List<Categoria> categoria;
    private Activity context;

    public CategoricalListAdapter(List<Categoria> categoria, Activity context) {
        this.categoria = categoria;
        this.context = context;
    }

    @Override
    public int getCount()
    { return categoria.size();
    }

    @Override
    public Object getItem(int i) {
       return categoria.get(i);
    }

    @Override
    public long getItemId(int i) {
        return categoria.get(i).getIdCategoria();
    }


    public String getItemTitulo(int i){
        return categoria.get(i).getNombre();
    }

    public String getitemNombre(int i){
        return categoria.get(i).getNombre();

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view=View.inflate(context.getApplicationContext(), R.layout.lista_categoria_row,null);
        }

        TextView nombre=view.findViewById(R.id.txtvCategoria);


        nombre.setText(getItemTitulo(i));


        return view;
    }

}