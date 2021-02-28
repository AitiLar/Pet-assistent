package com.HUAWEI.pet_assistent;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.view.View.OnClickListener;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements OnClickListener {
    private static final String TAG = "MapViewDemoActivity";
    WebView web;
    Button button1, button3;
    private LocationManager locationManager;
    public static boolean geolocationEnabled = false;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        checkLocationServiceEnabled();
    }


    @Override
    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, BrowserOne.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, MapActivity.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent1 = new Intent(this, BrowserTwo.class);
                startActivity(intent1);
                break;
        }
    }


    private boolean checkLocationServiceEnabled() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            geolocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }
        return buildAlertMessageNoLocationService(geolocationEnabled);
    }

    private boolean buildAlertMessageNoLocationService(boolean network_enabled) {
        String msg = !network_enabled ? getResources().getString(R.string.permis) : null;

        if (msg != null) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false)
                    .setMessage(msg)
                    .setPositiveButton("Включить", new DialogInterface.OnClickListener() {
                        public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        return false;
    }
}