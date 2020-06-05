package com.example.exsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class TestSensorActivity extends AppCompatActivity implements SensorEventListener {
private TextView tvalor;
private SensorManager sensorManager;
private Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sensor);

        int position =getIntent().getIntExtra("position",0);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor>sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        sensor=sensorList.get(position);
        tvalor=(TextView)findViewById(R.id.txtValor);
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }
}
