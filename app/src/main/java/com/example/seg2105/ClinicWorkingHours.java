package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClinicWorkingHours extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference userRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_working_hours);
    }

    public void onClick(View view){
        RadioButton[] list = new RadioButton[7];

        RadioButton monday = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton tuesday = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton wednesday = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton thursday = (RadioButton) findViewById(R.id.radioButton5);
        RadioButton friday = (RadioButton) findViewById(R.id.radioButton6);
        RadioButton saturday = (RadioButton) findViewById(R.id.radioButton7);
        RadioButton sunday = (RadioButton) findViewById(R.id.radioButton8);

        EditText starttime = (EditText) findViewById(R.id.starttime);
        EditText endtime = (EditText) findViewById(R.id.starttime);

        list[0]=monday;
        list[1]=tuesday;
        list[2]=wednesday;
        list[3]=thursday;
        list[4]=friday;
        list[5]=saturday;
        list[6]=sunday;

        TextView textview = (TextView) findViewById(R.id.textView44);

       for (int i=0; i<7; i++){
            boolean checked = (list[i]).isChecked();
            if (checked == true){
                Hours hour = new Hours (list[i].toString(), starttime.toString(), endtime.toString() );
                userRef.child(MainActivity.getUser().getUsername()).child("clinic").child(MainActivity.getUser().getClinic()).child(list[i].toString()).setValue(hour);

            }
        }

       


    }
}
