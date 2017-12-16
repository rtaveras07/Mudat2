package com.itla.mudat.View.ListAdapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Owner on 12/04/2017.
 */

public class AnuncioListAdapter extends BaseAdapter {

    private List<Anuncio> anuncio;
    private Activity context;

    public AnuncioListAdapter(List<Anuncio> anuncio, Activity context) {
        this.anuncio = anuncio;
        this.context = context;
    }

    @Override
    public int getCount() {
        return anuncio.size();
    }

    @Override
    public Object getItem(int i) {
        return anuncio.get(i);
    }

    @Override
    public long getItemId(int i) {
        return anuncio.get(i).getId();
    }


    public String getItemTitulo(int i){
        return anuncio.get(i).getTitulo();
    }

    public Double getItemPrecio(int i){
        return anuncio.get(i).getPrecio();
    }

    public String getItemUbicacion(int i){
        return anuncio.get(i).getUbicacion();
    }

    public String getItemDetalle(int i){
        return anuncio.get(i).getDetalle();

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view=View.inflate(context.getApplicationContext(), R.layout.lista_anuncio_row,null);
        }

        TextView tituloview=view.findViewById(R.id.luTitulo);
        TextView detalleview=view.findViewById(R.id.luDetalle);
       // TextView direccion=view.findViewById(R.id.txtDireccion);
        TextView precio=view.findViewById(R.id.txtPrecio);
        TextView estado=view.findViewById(R.id.txtEstado);

        tituloview.setText(getItemTitulo(i));
        detalleview.setText(getItemDetalle(i));
       // direccion.setText(getItemUbicacion(i));
        precio.setText(getItemPrecio(i).toString());
        estado.setText(getItemUbicacion(i));

        return view;
    }


}
