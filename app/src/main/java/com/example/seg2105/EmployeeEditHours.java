package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmployeeEditHours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_edit_hours);
    }
    public void goToEmployeeHours(View view){
        Intent intent = new Intent(getApplicationContext(), EmployeeHours.class);
        startActivity(intent);
    }
}
