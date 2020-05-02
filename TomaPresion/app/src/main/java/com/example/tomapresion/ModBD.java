package com.example.tomapresion;

public class ModBD {

    public static final String Nombre_db = "PresionArterial";
    public static final String Nombre_Tabla = "tomas";
    public static final String col_codigo = "codigo";
    public static final String col_sistotico = "sistotico";
    public static final String col_diastotico = "diastotico";
    public static final String col_fecha = "fecha";
    public static final String col_hora = "hora";

    public static final String CREAR_TABLA_TOMAS = "CREATE TABLE " +
            ""+ Nombre_Tabla +" ( "+col_codigo+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " " + col_sistotico + " TEXT, "+ col_diastotico + " TEXT, "
            +  col_fecha +" TEXT, "+col_hora +" TEXT)";
}
