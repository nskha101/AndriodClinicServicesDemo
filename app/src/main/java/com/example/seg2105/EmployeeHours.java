package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EmployeeHours extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference servicesRef = database.getReference();

    final DatabaseReference userRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_hours);
    }
    public void goToEmployeeScreen(View view){
        Intent intent = new Intent(getApplicationContext(), EmployeeScreen.class);
        startActivity(intent);
    }
    public void goToEmployeeEditHours(View view){
        Intent intent = new Intent(getApplicationContext(), EmployeeEditHours.class);
        startActivity(intent);
    }

}
