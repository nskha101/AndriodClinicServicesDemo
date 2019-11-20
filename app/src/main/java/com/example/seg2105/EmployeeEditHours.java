package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeEditHours extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference servicesRef = database.getReference();

    final DatabaseReference userRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_edit_hours);
    }
    public void goToEmployeeHours(View view){
        Intent intent = new Intent(getApplicationContext(), EmployeeHours.class);
        startActivity(intent);
    }
    public void onClick(View v) {
        TextView hourStart = findViewById(R.id.newStart);
        TextView dayChange = findViewById(R.id.newDay);
        TextView hourEnd = findViewById(R.id.newEnd);
        userRef.child(MainActivity.getUser().getUsername()).child("Shift").child(dayChange.toString()).setValue(new Hours(dayChange.toString(),hourStart.toString(),hourEnd.toString()));
    }
}
