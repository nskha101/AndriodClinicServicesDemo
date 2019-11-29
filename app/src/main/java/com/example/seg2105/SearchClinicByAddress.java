package com.example.seg2105;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SearchClinicByAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clinic_by_address);
    }

    public void onSearchClick(){
        //search
    }

    public void onBackClick(){
        Intent intent = new Intent(getApplicationContext(), PatientScreen.class);
        startActivity(intent);
        finish();
    }
}
