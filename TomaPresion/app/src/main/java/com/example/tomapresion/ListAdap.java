package com.example.tomapresion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdap extends ArrayAdapter<RegPresion> {
    private ArrayList<RegPresion> lista;
    private Context cont;
    private int layoutT;

    public ListAdap(@NonNull Context context, int resource, @NonNull ArrayList<RegPresion> objects) {
        super(context, resource, objects);
        this.lista = objects;
        this.cont = context;
        this.layoutT = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if (view == null){
            view= LayoutInflater.from(cont).inflate(layoutT, null);
        }

        RegPresion tomas = lista.get(position);
        TextView txtsist = view.findViewById(R.id.txtsistolico);
        TextView txtdiast = view.findViewById(R.id.txtdiastolico);
        TextView txtfecha = view.findViewById(R.id.txtfecha);
        TextView txthora = view.findViewById(R.id.txthora);

        txtsist.setText(tomas.getSistotico());
        txtdiast.setText(tomas.getDiastotico());
        txtfecha.setText(tomas.getFecha());
        txthora.setText(tomas.getHora());
        return view;

    }
}
