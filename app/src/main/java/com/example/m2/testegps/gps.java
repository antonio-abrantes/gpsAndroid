package com.example.m2.testegps;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class gps extends AppCompatActivity {

    private TextView Latitude, Longitude;
    private EditText resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        Latitude = (TextView) findViewById(R.id.id_latitude);
        Longitude = (TextView) findViewById(R.id.id_longitude);
        resposta = (EditText) findViewById(R.id.edt_resposta);

        LocationManager lManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener lListener = new LocationListener() {
            public void onLocationChanged(Location locat) {
                updateView(locat);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lListener);

    }

    public void updateView(Location locat){
        Double latitude = locat.getLatitude();
        Double longitude = locat.getLongitude();

        Latitude.setText(latitude.toString());
        Longitude.setText(longitude.toString());

    }

    public void voltar(View view) {
        Intent resp = new Intent();
        //Implementar resposta
        if(!resposta.equals("")){
            resp.putExtra("resposta", resposta.getText().toString());
        }

        resp.putExtra("resultado", "Retorno recebido com sucesso...");
        setResult(RESULT_OK, resp);
        finish();
    }
}
