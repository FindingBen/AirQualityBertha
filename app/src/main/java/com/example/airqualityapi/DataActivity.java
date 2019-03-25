package com.example.airqualityapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataActivity extends AppCompatActivity {
    public static final String DATA = "Data from sensor";
    private Data sensorData;
   // private EditText nameView, tempView, pressureView, humidityView,noiseView,utcView,pm10View,pm25View,co2View,o3View,latitude,longtitude,deviceIdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Intent intent = getIntent();
        sensorData = (Data) intent.getSerializableExtra(DATA);

        TextView headingView = findViewById(R.id.data_heading_textview);
        headingView.append("User Id=" + sensorData.getUserId());

        TextView tempView = findViewById(R.id.data_temp_textview);
        tempView.setText("Temperature: "+sensorData.getTemp());

        TextView pressureView=findViewById(R.id.data_pressure_textview);
        pressureView.setText("Pressure: "+sensorData.getPressure());

        TextView humdidityView=findViewById(R.id.data_humidity_textview);
        humdidityView.setText("Humidity: "+sensorData.getHumidity());

        TextView noiseView=findViewById(R.id.data_noise_textview);
        noiseView.setText("Noise level: "+sensorData.getNoise());

        TextView utcView=findViewById(R.id.data_utc_textview);
        utcView.setText("UTC: "+sensorData.getUtc());

        TextView pm10View=findViewById(R.id.data_pm10_textview);
        pm10View.setText("PM10: "+sensorData.getPm10());

        TextView pm25View=findViewById(R.id.data_pm25_textview);
        pm25View.setText("PM25: "+sensorData.getPm25());

        TextView co2View=findViewById(R.id.data_co2_textview);
        co2View.setText("CO2: "+sensorData.getCo2());

        TextView o3View=findViewById(R.id.data_o3_textview);
        o3View.setText("O3: "+sensorData.getO3());

        TextView latitutdeView=findViewById(R.id.data_latitude_textview);
        latitutdeView.setText("Latitude: "+ sensorData.getLatitude());

        TextView longtitudeView=findViewById(R.id.data_longtitude_textview);
        longtitudeView.setText("Longtitude: "+sensorData.getLongtitude());

        TextView deviceIDView=findViewById(R.id.data_device_textview);
        deviceIDView.setText("Device ID: "+String.valueOf(sensorData.getDeviceId()));


    }

    public void back(View view) {
        finish();

    }


}

