package com.example.tomapresion;

public class RegPresion {
    private long id;
    private String sistotico;
    private String diastotico;
    private String fecha;
    private String hora;

    public RegPresion(String sistotico, String diastotico, String fecha, String hora) {
        this.sistotico = sistotico;
        this.diastotico = diastotico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public RegPresion(long id, String sistotico, String diastotico, String fecha, String hora) {
        this.id = id;
        this.sistotico = sistotico;
        this.diastotico = diastotico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSistotico() {
        return sistotico;
    }

    public void setSistotico(String sistotico) {
        this.sistotico = sistotico;
    }

    public String getDiastotico() {
        return diastotico;
    }

    public void setDiastotico(String diastotico) {
        this.diastotico = diastotico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
