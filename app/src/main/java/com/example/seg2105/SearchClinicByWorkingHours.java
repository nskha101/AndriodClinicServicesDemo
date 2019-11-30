package com.example.seg2105;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchClinicByWorkingHours extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clinic_by_hours);

        Spinner daySpinner = (Spinner) findViewById(R.id.daySpinner);
        daySpinner.setOnItemSelectedListener(this);

        Spinner startTimeSpinner = (Spinner) findViewById(R.id.startTimeSpinner);
        daySpinner.setOnItemSelectedListener(this);

        Spinner endTimeSpinner = (Spinner) findViewById(R.id.endTimeSpinner);
        daySpinner.setOnItemSelectedListener(this);

        List<String> days = new ArrayList<>();
        days.add("--Please select a day--");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        List<String> startTimes = new ArrayList<>();
        startTimes.add("-Start Time-");
        startTimes.add("0:00");
        startTimes.add("1:00");
        startTimes.add("2:00");
        startTimes.add("3:00");
        startTimes.add("4:00");
        startTimes.add("5:00");
        startTimes.add("6:00");
        startTimes.add("7:00");
        startTimes.add("8:00");
        startTimes.add("9:00");
        startTimes.add("10:00");
        startTimes.add("11:00");
        startTimes.add("12:00");
        startTimes.add("13:00");
        startTimes.add("14:00");
        startTimes.add("15:00");
        startTimes.add("16:00");
        startTimes.add("17:00");
        startTimes.add("18:00");
        startTimes.add("19:00");
        startTimes.add("20:00");
        startTimes.add("21:00");
        startTimes.add("22:00");
        startTimes.add("23:00");

        List<String> endTimes = new ArrayList<>();
        endTimes.add("-End Time-");
        endTimes.add("0:00");
        endTimes.add("1:00");
        endTimes.add("2:00");
        endTimes.add("3:00");
        endTimes.add("4:00");
        endTimes.add("5:00");
        endTimes.add("6:00");
        endTimes.add("7:00");
        endTimes.add("8:00");
        endTimes.add("9:00");
        endTimes.add("10:00");
        endTimes.add("11:00");
        endTimes.add("12:00");
        endTimes.add("13:00");
        endTimes.add("14:00");
        endTimes.add("15:00");
        endTimes.add("16:00");
        endTimes.add("17:00");
        endTimes.add("18:00");
        endTimes.add("19:00");
        endTimes.add("20:00");
        endTimes.add("21:00");
        endTimes.add("22:00");
        endTimes.add("23:00");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dataAdapter);

    }

    public void onSearchClick(){
        //search
    }

    public void onBackClick(){
        Intent intent = new Intent(getApplicationContext(), PatientScreen.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
