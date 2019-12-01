package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClinicProfile extends AppCompatActivity {

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference clinicsRef = database.getReference();
//    final DatabaseReference userRef = database.getReference("clinics");
//    final ArrayList<Clinic> clinics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_profile);


        RatingBar ClinicRating = (RatingBar) findViewById(R.id.rate);
        RatingBar userRating = (RatingBar) findViewById(R.id.setrate);

        TextView address = findViewById(R.id.address);
        TextView phonenumber = findViewById(R.id.phonenumber);
        TextView insurancetype = findViewById(R.id.insureancetype);
        TextView paymentmethod = findViewById(R.id.paymentmethod);

        TextView clinicname = findViewById(R.id.clinicname);
        Clinic clinicNamePlaceHolder = PatientScreen.getCurrentClinic();

        getClinicInfo();



    }
    private void getClinicInfo(){
//        clinicsRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //fetch all the child of Services
//                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
//                for (DataSnapshot child: children) {
//
//                    Clinic currentChild = child.getValue(Clinic.class);
//                    currentChild.print();
//                    clinics.add(currentChild);
//                    System.out.println(clinics.size());
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        }

}
