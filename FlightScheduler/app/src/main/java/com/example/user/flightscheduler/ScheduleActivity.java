package com.example.user.flightscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        ListView finalSchedule=(ListView)findViewById(R.id.finalSchedule);

        ArrayList<String> schedule=new ArrayList<>();

        for(int i=0;i<MainActivity.n;i++) {
            schedule.add(MainActivity.pnrfinal[i]+" - "+MainActivity.arrfinal[i]);
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,schedule);
        finalSchedule.setAdapter(arrayAdapter);
    }
}
