package com.example.carlo.gasstaion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class ConsumoActivity extends AppCompatActivity {


    private TextView txtConsumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo);
        //Legge i parametri ricevuti
        Intent intent=getIntent();
        double consumo=intent.getDoubleExtra(MainActivity.PARAM_CONSUMO,0);
        txtConsumo=(TextView)findViewById(R.id.txtConsumo);
        txtConsumo.setText(""+consumo);



    }
}
