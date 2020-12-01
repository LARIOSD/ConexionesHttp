package com.example.sitioturistico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SitioAdapter extends ArrayAdapter<Sitios> {
    public SitioAdapter(@NonNull Context context, @NonNull ArrayList<Sitios> sitios) {
        super(context, 0, sitios);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Sitios st = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_sitios,parent,false);
        }

        TextView sitio = (TextView) convertView.findViewById(R.id.txtsitio);
        TextView municipio = (TextView) convertView.findViewById(R.id.txtmunicipio);
        TextView descripcion = (TextView) convertView.findViewById(R.id.txtdescripcion);
        TextView tipo = (TextView) convertView.findViewById(R.id.txttipo);

        sitio.setText(st.getNombresitio());
        municipio.setText(st.getNombremunicipio());
        descripcion.setText(st.getDescripcion());
        tipo.setText(st.getTipo());

        return convertView;
    }
}
