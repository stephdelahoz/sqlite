package com.example.tomapresion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControladorBaseD {
    private BaseDatos basedatos;

    public ControladorBaseD (Context context){
        this.basedatos =  new BaseDatos(context, ModBD.Nombre_db,null,1);
    }

    public long agRegistro (RegPresion presion){

            SQLiteDatabase database = basedatos.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put(ModBD.col_sistotico, presion.getSistotico());
            val.put(ModBD.col_diastotico, presion.getDiastotico());
            val.put(ModBD.col_fecha, presion.getFecha());
            val.put(ModBD.col_hora,presion.getHora());
            return database.insert(ModBD.Nombre_Tabla,null,val);

    }
    public int actRegistro(RegPresion tomas) {
        try {
            SQLiteDatabase database = basedatos.getWritableDatabase();
            ContentValues VA = new ContentValues();
            VA.put(ModBD.col_sistotico, tomas.getSistotico());
            VA.put(ModBD.col_diastotico, tomas.getDiastotico());
            VA.put(ModBD.col_fecha, tomas.getFecha());
            VA.put(ModBD.col_hora, tomas.getHora());

            String CA = ModBD.col_codigo + " = ?";
            String[] AC = {String.valueOf(tomas.getId())};

            return database.update(ModBD.Nombre_Tabla, VA, CA, AC);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarRegistro(RegPresion tomas) {
        try {
            SQLiteDatabase database = basedatos.getWritableDatabase();
            String[] arg = {String.valueOf(tomas.getId())};
            return database.delete(ModBD.Nombre_Tabla, ModBD.col_codigo + " = ?", arg);
        } catch (Exception e) {
            return 0;
        }
    }
    public ArrayList<RegPresion> obtTomas() {
        ArrayList<RegPresion> tomas = new ArrayList<>();
    SQLiteDatabase database = basedatos.getReadableDatabase();
    String[] colBuscar = {ModBD.col_codigo,ModBD.col_sistotico,ModBD.col_diastotico,ModBD.col_fecha,ModBD.col_hora};

        Cursor c = database.query(ModBD.Nombre_Tabla,colBuscar,null,null,null,null,null);
        if (c==null){
            return tomas;
        }
        if (!c.moveToFirst()){
            return tomas;
        }
        do {

            RegPresion tom = new RegPresion(c.getInt(0),c.getString(1),
                    c.getString(2),c.getString(3),c.getString(4));
            tomas.add(tom);
        } while (c.moveToNext());
        c.close();
        return tomas;
    }
}
