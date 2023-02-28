package com.example.tp4bis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<Sensor> deviceSensors0 = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        for (Sensor sensor : deviceSensors) {
            Log.i("lala",sensor.getName());
            Log.d("lal", String.valueOf(sensor.getMinDelay()));
        }
    }

}