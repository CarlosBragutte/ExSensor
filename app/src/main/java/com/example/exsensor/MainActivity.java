package com.example.exsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
private SensorManager sensorManager;
private List<Sensor>sensorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String>nomes=new ArrayList<String>();
        for (Sensor s: sensorList){

            nomes.add(s.getName()+ "-" + s.getVendor() + "-" +s.getType());

        }
        ListView listView = (ListView)findViewById(R.id.lstsensores);
        listView.setOnClickListener(this);
        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<String>adaptator = new ArrayAdapter<String>(this,layout,nomes);
        listView.setAdapter(adaptator);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Sensor sensor =sensorList.get(position);
        String msg = sensor.getName()+ "-"+ sensor.getVendor();
        Toast.makeText(getApplicationContext(),msg ,Toast.LENGTH_SHORT).show();
        Intent intent = new intent(this, TestSensorActivity.class);
        intent.putExtra("position",position);
        startActivity(intent);

    }
}
