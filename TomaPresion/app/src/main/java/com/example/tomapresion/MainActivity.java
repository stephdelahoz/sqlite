package com.example.tomapresion;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
ControladorBaseD control;
    EditText sist,diast;
    Button btnguardar, btnlist;
    String fecha, hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sist = findViewById(R.id.edtsistolico);
        diast = findViewById(R.id.edtdiastolico);
        btnguardar = findViewById(R.id.btnguardar);
        btnlist = findViewById(R.id.btnlistado);



        control = new ControladorBaseD(getApplicationContext());

        btnguardar.setOnClickListener(this);
        btnlist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnguardar:

                try {
                    // fecha
                    Date date = new Date();
                    SimpleDateFormat f = new SimpleDateFormat("d,MMMM 'del', yyyy");
                    final String fecha=f.format(date);
                    //hora
                    SimpleDateFormat h= new SimpleDateFormat("h:m a");
                    final String hora = h.format(date);
                    //----------
                    int s,d;
                    d=Integer.parseInt(diast.getText().toString());
                    s=Integer.parseInt(sist.getText().toString());
                    if (s>=0 && d>=0 && d<s && s>d){


                    RegPresion toma = new RegPresion(sist.getText().toString(),diast.getText().toString(),fecha,hora);
                    long ret = control.agRegistro(toma);
                    if (ret != -1) {
                        Toast.makeText(v.getContext(), "registro guardado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(v.getContext(), "registro fallido", Toast.LENGTH_SHORT).show();
                    }
                    sist.setText("");
                    diast.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(),"Los numeros deben ser positivos \n " +
                                "y el diastolico debe er menor a siastolico", Toast.LENGTH_SHORT).show();
                    }


                } catch (NumberFormatException numEx) {
                    Toast.makeText(getApplicationContext(), "numero muy grande", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnlistado:
                Intent i = new Intent(this, Listado.class);
                startActivity(i);
                break;
        }
    }




}
