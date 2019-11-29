package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PatientScreen extends AppCompatActivity{

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference userRef = database.getReference("users");
    final ArrayList<Clinic> clinic = new ArrayList<>();
    private static Clinic userClinic = new Clinic("","","","","");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_screen);
        Spinner roleSpinner = findViewById(R.id.searchTypeSpinner);

        ArrayList<String> searchTypeChoices = new ArrayList<>();
        searchTypeChoices.add("Address");
        searchTypeChoices.add("Working Hours");
        searchTypeChoices.add("Services Provided");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, searchTypeChoices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);
        roleSpinner.setOnItemSelectedListener(this);
    }
}
