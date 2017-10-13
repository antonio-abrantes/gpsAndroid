package com.example.m2.testegps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.txt_resposta);

    }

    public void visualizarGPS(View v) {

        Intent intent = new Intent(this, gps.class);
        startActivityForResult(intent, 2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            String r = data.getStringExtra("resposta");

            if(!r.equals("")){
                resultado.setText(r);
            }
        }catch (Exception ex){
            //Não faz nada
        }

        String resposta = data.getStringExtra("resultado");
        Toast.makeText(this,"Mensagem Recebida da SegundaActivity:\n" + resposta, Toast.LENGTH_LONG).show();
    }
}
