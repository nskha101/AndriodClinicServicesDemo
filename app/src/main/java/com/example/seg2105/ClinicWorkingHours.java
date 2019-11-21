package com.example.seg2105;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ClinicWorkingHours extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference userRef = database.getReference("users");
    final ArrayList<Hours> hours = new ArrayList<>();


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


        getUserHours();
    }

    public void getUserHours(){
        userRef.child(MainActivity.getUser().getUsername()).child("clinic").child("hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fet all the child of User
                for(int i = 0; i <5; i++){
                    hours.add(i,new Hours("","",""));
                }
                System.out.println("Not working!");
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    System.out.println("Not working!...again");
                    Hours currentChild = child.getValue(Hours.class);

                    switch (currentChild.getDay()){
                        case "Monday": hours.set(0,currentChild);
                            System.out.println("Monday");
                            break;
                        case "Tuesday": hours.set(1,currentChild);
                            System.out.println("Tuesday");
                            break;
                        case "Wednesday": hours.set(2,currentChild);
                            System.out.println("Wednesday");
                            break;

                        case "Thursday": hours.set(3,currentChild);
                            System.out.println("Thursday");
                            break;
                        case "Friday": hours.set(4,currentChild);
                            System.out.println("Friday");
                            break;
                        default:
                            System.out.println("Nothing");
                            break;
                    }

                }
                seeDayHours();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void seeDayHours(){
        TextView monday = findViewById(R.id.mondayLabel);
        TextView tuesday = findViewById(R.id.tuesdayLabel);
        TextView wednesday = findViewById(R.id.wednesdayLabel);
        TextView thursday = findViewById(R.id.thursdayLabel);
        TextView friday = findViewById(R.id.fridayLabel);

        if(hours.get(0).getDay().equals("")){
            monday.setText("Monday:  No time has been added for this day");
        }
        else{
            monday.setText("Monday: from " + hours.get(0).getStartTime() + " to " + hours.get(0).getEndTime());
        }
        if(hours.get(1).getDay().equals("")){
            tuesday.setText("Tuesday: No time has been added for this day");
        }
        else{
            tuesday.setText("Tuesday: from " + hours.get(1).getStartTime() + " to " + hours.get(1).getEndTime());
        }
        if(hours.get(2).getDay().equals("")){
            wednesday.setText("Wednesday: No time has been added for this day");
        }
        else{
            wednesday.setText("Wednesday: from " + hours.get(2).getStartTime() + " to " + hours.get(2).getEndTime());
        }
        if(hours.get(3).getDay().equals("")){
            thursday.setText("Thursday: No time has been added for this day");
        }
        else{
            thursday.setText("Thursday: from " + hours.get(3).getStartTime() + " to " + hours.get(3).getEndTime());
        }
        if(hours.get(4).getDay().equals("")){
            friday.setText("Friday: No time has been added for this day");
        }
        else{
            friday.setText("Friday: from " + hours.get(4).getStartTime() + " to " + hours.get(4).getEndTime());
        }


    }

    public void onClick(View view){

        TextView errorTextView= findViewById(R.id.messageTextView);

        Spinner daySpinner = findViewById(R.id.daySpinner);
        Spinner startTimeSpinner = findViewById(R.id.startSpinner);
        Spinner endTimeSpinner = findViewById(R.id.endTimeSpinner);

        String dayString = daySpinner.getSelectedItem().toString();
        String startString = startTimeSpinner.getSelectedItem().toString();
        String endString = endTimeSpinner.getSelectedItem().toString();
        String startTime;
        String endTime;

        if(startString.length() == 4) {
            startTime = startString.substring(0,1) + startString.substring(2, 4);
        }
        else{
            startTime = startString.substring(0,2) + startString.substring(3, 5);
        }
        if(endString.length() == 4) {
            endTime = endString.substring(0,1) + endString.substring(2, 4);
        }
        else{
            endTime = endString.substring(0,2) + endString.substring(3, 5);
        }
        int startInt = Integer.valueOf(startTime);
        int endInt = Integer.valueOf(endTime);
        if(startInt >= endInt){
            errorTextView.setText("You can't have a start time bigger then end time!");
        }
        else{
            userRef.child(MainActivity.getUser().getUsername()).child("clinic").child("hours").child(dayString).setValue(new Hours(dayString,startString,endString));
            errorTextView.setText("Time added to the list!");
        }
        getUserHours();

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
