package com.example.seg2105;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchClinicByAddress extends AppCompatActivity {


    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference Ref = database.getReference("clinics");
    final ArrayList<Clinic> clinics = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clinic_by_address);

        getAllClinic();
    }



    public void onSearchClick(View view){

        EditText address = findViewById(R.id.addressEditText);

        boolean found = false;

        for (Clinic clinic:clinics){
            if (clinic.getClinicAdress().equals(address)){
                PatientScreen.setCurrentCinic(clinic);
                Intent intent = new Intent(getApplicationContext(), ClinicProfile.class);
                startActivity(intent);
            }

        }
        if (!found){Toast.makeText(getApplicationContext(),"No clinic found with that address", Toast.LENGTH_SHORT).show();}
    }


    public void getAllClinic(){

        Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    System.out.println("Test2");
                    Clinic currentChild = child.getValue(Clinic.class);
                    currentChild.print();
                    clinics.add(currentChild);

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void onBackClick(){
        Intent intent = new Intent(getApplicationContext(), PatientScreen.class);
        startActivity(intent);
        finish();
    }
}
