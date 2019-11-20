package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangeEmployeeInfo extends AppCompatActivity{


    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference UserRef = database.getReference("users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_info_screen);

        EditText clinicnametextfield = findViewById(R.id.clinicNameEditText);
        EditText clinicaddresstextfield = findViewById(R.id.clinicAddressEditText);
        EditText phonenumtextfield = findViewById(R.id.phoneNumberEditText);
        EditText insurancetypestextfield = findViewById(R.id.insuranceEditText); //convert to sha256
        EditText paymenttypestextfeild = findViewById(R.id.paymentEditText);

        clinicnametextfield.setText("");
        clinicaddresstextfield.setText("");
        phonenumtextfield.setText("");
        insurancetypestextfield.setText("");
        paymenttypestextfeild.setText("");
    }

    public void onClick(View view) {
        //fields to make: String username,String email, String password, String name, String familyName
        EditText clinicnametextfield = findViewById(R.id.clinicNameTextView);
        EditText clinicaddresstextfield = findViewById(R.id.clinicAddressTextView);
        EditText insurancetypestextfield = findViewById(R.id.insuranceTextView); //convert to sha256
        EditText paymenttypestextfeild = findViewById(R.id.paymentTextView);


        //add radiobutton functionality for patient/employee pick (if patient radiobutton is picked, make role string = Patient, etc

        String name = clinicnametextfield.getText().toString();
        String address = clinicaddresstextfield.getText().toString();
        String insurance = insurancetypestextfield.getText().toString();
        String payment = paymenttypestextfeild.getText().toString();


//test
        if (!validate(name, address, insurance, payment)){
            clinicnametextfield.setText("");
            clinicaddresstextfield.setText("");
            insurancetypestextfield.setText("");
            paymenttypestextfeild.setText("");

            errorView.setText("Please fill out all required information");

        } else {
            UserRef.child(MainActivity.getUser().getUsername()).setValue(new User(username, email, password, name, familyName, patientorEmployee));
            finish();
        }
    }



    private boolean validate(String n, String a, String i, String s){
        if (n.equals("")) {
            return false;
        }
        if (a.equals("")) {
            return false;
        }
        if (i.equals("")) {
            return false;
        }
        if (s.equals("")) {
            return false;
        }
        return true;
    }



}
