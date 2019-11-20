package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClinicWorkingHours extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference userRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_working_hours);
        
        Spinner daySpinner = findViewById(R.id.daySpinner);
        Spinner startTimeSpinner = findViewById(R.id.startSpinner);
        Spinner endTimeSpinner = findViewById(R.id.endTimeSpinner);

        ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(this, R.array.dayOfTheWeek, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);
        daySpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> startAdapter = ArrayAdapter.createFromResource(this, R.array.timeSlot, android.R.layout.simple_spinner_item);
        startAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startTimeSpinner.setAdapter(startAdapter);
        startTimeSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> endAdapter = ArrayAdapter.createFromResource(this, R.array.timeSlot, android.R.layout.simple_spinner_item);
        endAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        endTimeSpinner.setAdapter(endAdapter);
        endTimeSpinner.setOnItemSelectedListener(this);
    }

    public void onClick(View view){


        TextView textview = (TextView) findViewById(R.id.messageTextView);

       /*for (int i=0; i<7; i++){
            boolean checked = (list[i]).isChecked();
            if (checked == true){
                Hours hour = new Hours (list[i].toString(), starttime.toString(), endtime.toString() );
                userRef.child(MainActivity.getUser().getUsername()).child("clinic").child(MainActivity.getUser().getClinic().getClincName()).child(list[i].toString()).setValue(hour);

            }
        }*/
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
