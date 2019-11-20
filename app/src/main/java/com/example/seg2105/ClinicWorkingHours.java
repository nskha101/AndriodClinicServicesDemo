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

import org.w3c.dom.Text;

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

        TextView errorTextView= findViewById(R.id.messageTextView);

        Spinner daySpinner = findViewById(R.id.daySpinner);
        Spinner startTimeSpinner = findViewById(R.id.startSpinner);
        Spinner endTimeSpinner = findViewById(R.id.endTimeSpinner);

        String dayString = daySpinner.getSelectedItem().toString();
        String startString = startTimeSpinner.getSelectedItem().toString();
        String endString = endTimeSpinner.getSelectedItem().toString();

        
        String startTime = startString.substring(0,1) + startString.substring(3,4);
        int startInt = Integer.parseInt(startTime);
        String endTime = startString.substring(0,1) + startString.substring(3,4);
        int endInt = Integer.parseInt(endTime);

        if(startInt >= endInt){
            errorTextView.setText("You can't have a start time lower then end time!");
        }
        else{
            userRef.child(MainActivity.getUser().getUsername()).child("clinic").setValue(new Hours(dayString,startString,endString));
            errorTextView.setText("Time added to the list!");
        }
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
