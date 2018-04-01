package com.example.user.flightscheduler;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlaneActivity extends AppCompatActivity {
    EditText pnrr;
    EditText arrival;
    EditText fuel;
    CheckBox emergency;
    public static int a[]=new int[10];
    String arr[]=new String[10];
    public static int ext[]=new int [10];
    public static String pnr[]=new String[10];
    public static int emergfactor[]=new int[10];
    public static int fuelstatus[]=new int[10];
    int c[]=new int[10];

    public void added(View view) {
        MainActivity.n++;
        int i=(MainActivity.n)-1;
        pnr[i]=pnrr.getText().toString();
        arr[i]=arrival.getText().toString();
        fuelstatus[i]=Integer.parseInt(fuel.getText().toString());
        ext[i]=30;
        if(emergency.isChecked()) {
            emergfactor[i]=1;
        }
        else {
            emergfactor[i]=0;
        }

        int h=Integer.parseInt(arr[i].substring(0, 2));
        int m=Integer.parseInt(arr[i].substring(3, 5));

        a[i]=h*60+m;

        Toast.makeText(this, "Plane Added!", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plane);
        pnrr=(EditText)findViewById(R.id.pnr);
        arrival=(EditText)findViewById(R.id.arrival);
        fuel=(EditText)findViewById(R.id.fuel);
        emergency=(CheckBox)findViewById(R.id.emergency);
    }
}
