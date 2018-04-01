package com.example.user.flightscheduler;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPlaneActivity extends AppCompatActivity {
    EditText pnrr;
    Spinner pnrspinner;
    NumberPicker hourpicker;
    NumberPicker minutepicker;
    SeekBar fuel;
    CheckBox emergency;
    public static int a[]=new int[10];
    public static int ext[]=new int [10];
    public static String pnr[]=new String[10];
    public static int emergfactor[]=new int[10];
    public static int fuelstatus[]=new int[10];
    int c[]=new int[10];

    public void added(View view) {
        MainActivity.n++;
        int i=(MainActivity.n)-1;
        pnr[i]=pnrspinner.getSelectedItem().toString()+pnrr.getText().toString();
        fuelstatus[i]=fuel.getProgress()*10;
        Log.i("fuel",fuelstatus[i]+"");

        ext[i]=30;
        if(emergency.isChecked()) {
            emergfactor[i]=1;
        }
        else {
            emergfactor[i]=0;
        }

        int h=hourpicker.getValue();
        int m=minutepicker.getValue();

        a[i]=h*60+m;

        Toast.makeText(this, "Plane Added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plane);
        pnrr=(EditText)findViewById(R.id.pnr);
        fuel=(SeekBar)findViewById(R.id.seekBar);
        emergency=(CheckBox)findViewById(R.id.emergency);
        pnrspinner=(Spinner)findViewById(R.id.pnrspinner);
        hourpicker=(NumberPicker) findViewById(R.id.numberPicker);
        minutepicker=(NumberPicker) findViewById(R.id.numberPicker2);

        hourpicker.setMinValue(0);
        hourpicker.setMaxValue(23);
        minutepicker.setMinValue(0);
        minutepicker.setMaxValue(59);

        ArrayList<String> pnrprefix=new ArrayList<String>();
        pnrprefix.add("MF");
        pnrprefix.add("AI");
        pnrprefix.add("6E");
        pnrprefix.add("9W");
        pnrprefix.add("G8");
        pnrprefix.add("SG");
        pnrprefix.add("UK");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,pnrprefix);
        pnrspinner.setAdapter(arrayAdapter);

        ArrayList<String> hours=new ArrayList<String>();
        for(int i=0;i<24;i++) {
            if(i<10)
                hours.add("0"+i);
            else {
                hours.add(""+i);
            }
        }
        /*
        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,hours);
        hourspinner.setAdapter(arrayAdapter2);

        ArrayList<String> minutes=new ArrayList<String>();
        for(int i=0;i<59;i++) {
            if(i<10)
                minutes.add("0"+i);
            else {
                minutes.add(""+i);
            }
        }
        ArrayAdapter<String> arrayAdapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,minutes);
        minutespinner.setAdapter(arrayAdapter3);
        */

    }
}
