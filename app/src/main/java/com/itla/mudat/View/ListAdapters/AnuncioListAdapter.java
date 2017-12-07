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
        this.context = context;//campos que se desplegaran en la consulta.
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        return null;
    }

    public String getItemTitulo(int i){
        return anuncio.get(i).getTitulo();

    }

    public String getItemDetalle(int i){
        return anuncio.get(i).getDetalle();


    }}
