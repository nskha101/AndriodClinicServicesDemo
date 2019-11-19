package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmployeeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_screen);
    }
    public void goToDeleteEmployeeService(View view){
        Intent intent = new Intent(getApplicationContext(), DeleteEmployeeService.class);
        startActivity(intent);
    }
    public void goToAddEmployeeService(View view){
        Intent intent = new Intent(getApplicationContext(), AddEmployeeService.class);
        startActivity(intent);
    }

    public void goToCreateClinic(View view){
        Intent intent = new Intent(getApplicationContext(), CreateClinic.class);
        startActivity(intent);
        finish();
    }

    /*public void goToClinicHours(View view){
        Intent intent = new Intent(getApplicationContext(), ClinicHours.class);
        startActivity(intent);
    }

    public void goToEmployeeHours(View view){
        Intent intent = new Intent(getApplicationContext(), EmployeeHours.class);
        startActivity(intent);
    }*/
}
