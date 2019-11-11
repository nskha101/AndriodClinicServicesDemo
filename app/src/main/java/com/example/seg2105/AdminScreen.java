package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
    }

    public void goToAddService(View view){
        Intent intent = new Intent(getApplicationContext(), addService.class);
        startActivity(intent);
    }

    public void goToDeleteService(View view){
        Intent intent = new Intent(getApplicationContext(), deleteService.class);
        startActivity(intent);
    }

    public void goToEditService(View view){
        Intent intent = new Intent(getApplicationContext(), editService.class);
        startActivity(intent);
    }

    public void goToDeleteUser(View view){
        Intent intent = new Intent(getApplicationContext(), DeleteUser.class);
        startActivity(intent);
    }
    public void goToDeleteUser(View view){
        Intent intent = new Intent(getApplicationContext(), DeleteUser.class);
        startActivity(intent);
    }

}
