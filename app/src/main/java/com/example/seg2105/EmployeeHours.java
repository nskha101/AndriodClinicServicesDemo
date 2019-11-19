package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmployeeHours extends AppCompatActivity {

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
