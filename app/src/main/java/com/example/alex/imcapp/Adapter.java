package com.example.alex.imcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Alex on 17/01/2017.
 */

public class Adapter extends BaseAdapter{

    private Context _context;
    private String[] _infoclasificacion;
    private String[] _inforatio;
    private int _id_layout_celda;

    public Adapter(Context context, String[] infoclasificacion, String[] inforatio, int id_layout_celda) {
        this._context = context;
        this._infoclasificacion = infoclasificacion;
        this._inforatio = inforatio;
        this._id_layout_celda = id_layout_celda;
    }

    @Override
    public int getCount() {
        return _inforatio.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){//Si es la primera vez que se va a mostrar se infla
            LayoutInflater layoutInflater = LayoutInflater.from(_context);
            v = layoutInflater.inflate(_id_layout_celda, null);
        }

        //Variables con los datos que se van a crear
        String infoclasificacion = _infoclasificacion[position];
        String inforatio = _inforatio[position];

        //Creamos objetos textView del XML fila
        TextView textView_infoclasificacion = (TextView) v.findViewById(R.id.infoclasificacion);
        TextView textView_inforatio = (TextView) v.findViewById(R.id.inforatio);

        textView_infoclasificacion.setText(infoclasificacion);
        textView_inforatio.setText(inforatio);


        return v;
    }
}
