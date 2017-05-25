package com.example.carlo.gasstaion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private EditText editKm,editLitri;
    public final static String PARAM_CONSUMO="param_consumo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Graphic Component link
        editKm=(EditText)findViewById(R.id.editKm);
        editLitri=(EditText)findViewById(R.id.editLitri);
    }
    public void calcolaConsumo(View view){
        int km,litri;
        double consumo;
        Toast errorToast;
        try{
            km=Integer.parseInt(editKm.getText().toString());
        }catch (NumberFormatException exc){
            Log.d("MainActivity","Eccezione numerica "+exc);
            errorToast=Toast.makeText(getApplicationContext(),"Inserisci un numero valido",Toast.LENGTH_LONG);
            errorToast.show();
            return;
        }
        try{
            litri=Integer.parseInt(editLitri.getText().toString());
        }catch (NumberFormatException exc){
            Log.d("MainActivity","Eccezione numerica "+exc);
            errorToast=Toast.makeText(getApplicationContext(),"Inserisci un numero valido",Toast.LENGTH_LONG);
            errorToast.show();
            return;
        }
        consumo=(1.0*km)/litri;
        consumo=Math.round(10.0*consumo)/10.0;

        // Second Activity Opening
        Intent intent=new Intent(this,ConsumoActivity.class);
        intent.putExtra(PARAM_CONSUMO,consumo);
        startActivity(intent);

    }
}
