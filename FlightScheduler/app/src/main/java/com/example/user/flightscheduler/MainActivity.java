package com.example.user.flightscheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static int n=0;
    int p[]=new int[10];
    int pr[]=new int[10];
    int i,j;
    int flag[]=new int[10];
    int flag1[]=new int[10];
    public static  String pnrfinal[]=new String[10];
    public static  String arrfinal[]=new String[10];
    int y=0;
    String time;

    public void addPlane(View view) {
        Intent intent=new Intent(getApplicationContext(),AddPlaneActivity.class);
        startActivity(intent);
    }

    public void checkSchedule(View view) {
        if(n==0) {
            Toast.makeText(this, "No plane added!", Toast.LENGTH_SHORT).show();
        }
        else {
            p = Arrays.copyOf(AddPlaneActivity.a, n);

            Arrays.sort(p);

            int start = p[0];

            pr = MainActivity.priority(AddPlaneActivity.emergfactor, AddPlaneActivity.fuelstatus, AddPlaneActivity.pnr, n);

            int sum = n * 30;

            for (i = start; i < (start + sum); ) {
                for (j = 0; j < n; j++) {
                    if (AddPlaneActivity.a[j] <= i && flag1[j] != 1) {
                        flag[j] = 1;
                    }
                }
                int k = 0;
                int max = -1, t = 0;
                for (j = 0; j < n; j++) {
                    if (pr[j] > max && flag[j] == 1 && flag1[j] != 1) {
                        max = pr[j];
                        t = j;
                    }
                }
                pnrfinal[y] = AddPlaneActivity.pnr[t];

                int hour_of_landing = (i / 60);
                int min_of_landing = (i % 60);
                if (min_of_landing / 10 == 0)
                    time = hour_of_landing + ":0" + min_of_landing;
                else
                    time = hour_of_landing + ":" + min_of_landing;
                arrfinal[y] = time;
                i += AddPlaneActivity.ext[t];

                flag1[t] = 1;
                y++;
                Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
                startActivity(intent);
            }
        }
    }

    static int[] priority(int emergfact[], int fuelstatus[], String pnr[], int n )
    {
        int pr1[]=new int[10];
        int i=0;

        for(i=0;i<n;i++)
        {

            if(emergfact[i]==1)
                pr1[i]=999;

            pr1[i]+=100-fuelstatus[i];

            if(pnr[i].startsWith("MF")) //MF stands for military flight
                pr1[i]+=31;
            if(pnr[i].startsWith("AI")) //AI stands for Indian Airlines
                pr1[i]+=30;
            if(pnr[i].startsWith("6E")) //6E stands for Indigo
                pr1[i]+=29;
            if(pnr[i].startsWith("9W")) //9W stands for Jet Airways
                pr1[i]+=28;
            if(pnr[i].startsWith("G8")) //G8 stands for Go Air
                pr1[i]+=27;
            if(pnr[i].startsWith("SG")) //G8 stands for Spice Jet
                pr1[i]+=26;
            if(pnr[i].startsWith("UK")) //UK stands for Vistara
                pr1[i]+=25;
        }
        return pr1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
