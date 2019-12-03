package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClinicProfile extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference clinicsRef = database.getReference().child("clinics");
    DatabaseReference userRef = database.getReference().child("users");
//    final ArrayList<Clinic> clinics = new ArrayList<>();
    private Boolean alreadyWaiting;
    private final ArrayList<Hours> hours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_profile);

        alreadyWaiting = false;

        getClinicHours();

        RatingBar ClinicRating = (RatingBar) findViewById(R.id.rate);
        RatingBar userRating = (RatingBar) findViewById(R.id.setrate);

        TextView clinicname = findViewById(R.id.clinicname);
        TextView address = findViewById(R.id.address);
        TextView phonenumber = findViewById(R.id.phonenumber);
        TextView insurancetype = findViewById(R.id.insureancetype);
        TextView paymentmethod = findViewById(R.id.paymentmethod);
        TextView waitingTime = findViewById(R.id.waittime);

        Clinic clinic = PatientScreen.getCurrentClinic();

        clinicname.setText(clinic.getClinicName());
        address.setText(clinic.getClinicAdress());
        phonenumber.setText(clinic.getClinicPhoneNum());
        insurancetype.setText(clinic.getClinicInsurance());
        paymentmethod.setText(clinic.getClinicPayment());
        waitingTime.setText((clinic.getWaiting()*15) + " Minutes");
        ClinicRating.setNumStars(clinic.getNumrated());

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


    public void waitingListClick(View view){
        Clinic clinic = PatientScreen.getCurrentClinic();
        TextView waitingTime = findViewById(R.id.waittime);
        TextView errorText = findViewById(R.id.errorText);

        if(!alreadyWaiting){
            clinic.setWaiting(clinic.getWaiting()+1);
            waitingTime.setText((clinic.getWaiting()*15) + "Minutes");
            clinicsRef.child(clinic.getClinicName()).setValue(new Clinic(clinic.getClinicName(),clinic.getClinicAdress(),clinic.getClinicPhoneNum(),clinic.getClinicInsurance(),clinic.getClinicPayment(),clinic.getCreator(),clinic.getWaiting()));
            userRef.child(clinic.getCreator()).child("clinic").child(clinic.getClinicName()).setValue(new Clinic(clinic.getClinicName(),clinic.getClinicAdress(),clinic.getClinicPhoneNum(),clinic.getClinicInsurance(),clinic.getClinicPayment(),clinic.getCreator(),clinic.getWaiting()));
            for(int i =0; i< hours.size(); i++){
                clinicsRef.child(clinic.getClinicName()).child("hours").child(hours.get(i).getDay()).setValue(new Hours(hours.get(i).getDay(),hours.get(i).getStartTime(),hours.get(i).getEndTime()));
            }
            alreadyWaiting = true;
        }
        else{
            errorText.setText("You are already in the waiting list for this clinic!");
        }

    }

    public void getClinicHours(){
        Clinic clinic = PatientScreen.getCurrentClinic();
        clinicsRef.child(clinic.getClinicName()).child("hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fetch all the child of Services
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {

                    Hours currentChild = child.getValue(Hours.class);
                    hours.add(currentChild);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
