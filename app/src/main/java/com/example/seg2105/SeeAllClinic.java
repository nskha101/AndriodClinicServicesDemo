package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SeeAllClinic extends AppCompatActivity {

    final ArrayList<Clinic> clinics = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference clinicRef = database.getReference().child("clinics");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_clinic);

        getAllClinic();
    }

    private void getAllClinic() {
        clinicRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fetch all the child of Services
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {

                    Clinic currentChild = child.getValue(Clinic.class);
                    currentChild.print();
                    clinics.add(currentChild);

                }
                showClinic();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void showClinic(){

        Button newBtn;
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayoutScrollView);
        for (int i = 0; i < clinics.size(); i++) {
            newBtn = new Button(this);
            newBtn.setText("Name: " + clinics.get(i).getClinicName() + "\r\nAddress: " + clinics.get(i).getClinicAdress() + "\nPhone number: " + clinics.get(i).getClinicPhoneNum());
            newBtn.setId(i);
            System.out.println(newBtn.getId());
            newBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int buttonid = v.getId();
                    Intent intent = new Intent(getApplicationContext(), ClinicProfile.class);
                    PatientScreen.setCurrentCinic(clinics.get(buttonid));
                    startActivity(intent);


                }
            });
            buttons.add(newBtn);
            layout.addView(newBtn);
        }

    }



}
