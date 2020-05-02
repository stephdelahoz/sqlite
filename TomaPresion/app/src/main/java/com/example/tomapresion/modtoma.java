package com.example.tomapresion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class modtoma extends AppCompatActivity implements View.OnClickListener{
    ControladorBaseD control;
    EditText sist,diast;
    Button btnguardar;
    String fecha, hora;
    int ind;
    long cod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificartoma);


        sist = findViewById(R.id.edtsistolico);
        diast = findViewById(R.id.edtdiastolico);
        btnguardar = findViewById(R.id.btnguardar);




        control = new ControladorBaseD(getApplicationContext());

        Intent i = getIntent();
        ind = i.getIntExtra("indice",0);

        ArrayList<RegPresion> lista = control.obtTomas();

        RegPresion toma = lista.get(ind);
        cod = toma.getId();

        sist.setText(toma.getSistotico());
        diast.setText(toma.getDiastotico());
        btnguardar.setOnClickListener(this);
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


                        RegPresion toma = new RegPresion(cod,sist.getText().toString(),diast.getText().toString(),fecha,hora);
                        long ret = control.actRegistro(toma);
                        if (ret == 1) {
                            Toast.makeText(v.getContext(), "actualizado", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(v.getContext(), "registro actilizacion", Toast.LENGTH_SHORT).show();
                        }
                        sist.setText("");
                        diast.setText("");
                        Intent i = new Intent(this, MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Los numeros deben ser positivos \n " +
                                "y el diastolico debe er menor a siastolico", Toast.LENGTH_SHORT).show();
                    }


                } catch (NumberFormatException numEx) {
                    Toast.makeText(getApplicationContext(), "numero muy grande", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }
}