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

    public void goToDeleteUser(View view){
        Intent intent = new Intent(getApplicationContext(), DeleteUser.class);
        startActivity(intent);
    }
    public void goToAddService(View view){
        Intent intent = new Intent(getApplicationContext(), AddService.class);
        startActivity(intent);
    }

    public void goToDeleteService(View view){
        Intent intent = new Intent(getApplicationContext(), DeleteService.class);
        startActivity(intent);
    }

    public void goToEditService(View view){
        Intent intent = new Intent(getApplicationContext(), EditService.class);
        startActivity(intent);
    }



}
