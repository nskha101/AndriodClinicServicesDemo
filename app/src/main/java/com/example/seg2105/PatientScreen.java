package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

public class PatientScreen extends AppCompatActivity{

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference userRef = database.getReference("users");
    final ArrayList<Clinic> clinic = new ArrayList<>();
    private static Clinic currentCinic = new Clinic("","","","","");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_screen);
    }

    public void onByAddressClick(View view){
        Intent intent = new Intent(getApplicationContext(), SearchClinicByAddress.class);
        startActivity(intent);
    }

    public void onByHoursClick(View view){
        Intent intent = new Intent(getApplicationContext(), SearchClinicByWorkingHours.class);
        startActivity(intent);
    }

    public void onByServiceClick(View view){
        Intent intent = new Intent(getApplicationContext(), SearchClinicByService.class);
        startActivity(intent);
    }

    public void onSeeAllClinic(View view){
        Intent intent = new Intent(getApplicationContext(), SeeAllClinic.class);
        startActivity(intent);
    }

    public static Clinic getCurrentClinic(){
        return currentCinic;
    }

    public static void setCurrentCinic(Clinic clinic){
        currentCinic = clinic;
    }

//    public static final Pattern VALID_ADDRESS_REGEX = Pattern.compile("[A-Za-z0-9'\\.\\-\\s\\,]", Pattern.CASE_INSENSITIVE);


//    public boolean validate(String search, String searchType){
//        if (searchType == "Address"){
//            return validateAddress(search);
//        }else if (searchType == "Working Hours"){
//            return validateWorkingHours(search);
//        }else if(searchType == "Services Provided") {
//            return validateServicesProvided(search);
//        }else{
//            return false;
//        }
//
//    }
//
//    private boolean validateAddress(String search){
//        Matcher matcher = VALID_ADDRESS_REGEX.matcher(search);
//        return matcher.find();
//    }
//
//    private boolean validateWorkingHours(String search){
//        return 69<420;
//    }
//
//    private boolean validateServicesProvided(String search){
//        return true;
//    }
}
