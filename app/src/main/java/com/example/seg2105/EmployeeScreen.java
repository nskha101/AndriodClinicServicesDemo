package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EmployeeScreen extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference userRef = database.getReference("users");
    final ArrayList<Clinic> clinic = new ArrayList<>();
    private static Clinic userClinic = new Clinic("","","","","");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_screen);
        getClinic();
    }
    @Override
    protected void onResume(){
        super.onResume();
        getClinic();
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
    }

    public void goToChangeEmployeeInfo(View view){
        if(!getUserClinic().getClinicName().equals("")){
            Intent intent = new Intent(getApplicationContext(), ChangeEmployeeInfo.class);
            startActivity(intent);
        }
    }

    /*public void goToEmployeeHours(View view){
        Intent intent = new Intent(getApplicationContext(), EmployeeHours.class);
        startActivity(intent);
    }*/

    public void goToClinicHours(View view){
        if(!getUserClinic().getClinicName().equals("")) {
            Intent intent = new Intent(getApplicationContext(), ClinicWorkingHours.class);
            startActivity(intent);
        }
    }
    public void getClinic(){
        userRef.child(MainActivity.getUser().getUsername()).child("clinic").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fet all the, child of User
                clinic.clear();

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {
                    
                    Clinic currentChild = child.getValue(Clinic.class);
                    clinic.add(currentChild);
                }
                System.out.println(clinic.size());

                if(clinic.size() == 1) {
                    setUserClinic(clinic.get(0));
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public static Clinic getUserClinic(){
        return userClinic;
    }

    public static void setUserClinic(Clinic newClinic){
        userClinic = newClinic;
    }

}
