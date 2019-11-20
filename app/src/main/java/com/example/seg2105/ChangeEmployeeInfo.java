package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        EditText clinicnametextfield = findViewById(R.id.clinicNameEditText);
        EditText clinicaddresstextfield = findViewById(R.id.clinicAddressEditText);
        EditText clinicphonenumfield = findViewById(R.id.phoneNumberEditText);
        EditText insurancetypestextfield = findViewById(R.id.insuranceEditText); //convert to sha256
        EditText paymenttypestextfeild = findViewById(R.id.paymentEditText);
        TextView errorView = findViewById(R.id.errorView);


        //add radiobutton functionality for patient/employee pick (if patient radiobutton is picked, make role string = Patient, etc

        String name = clinicnametextfield.getText().toString();
        String address = clinicaddresstextfield.getText().toString();
        String phonenum = clinicphonenumfield.getText().toString();
        String insurance = insurancetypestextfield.getText().toString();
        String payment = paymenttypestextfeild.getText().toString();



        if (!validate(phonenum, address, name, insurance, payment)){
            clinicnametextfield.setText("");
            clinicaddresstextfield.setText("");
            clinicphonenumfield.setText("");
            insurancetypestextfield.setText("");
            paymenttypestextfeild.setText("");

            Toast.makeText(ChangeEmployeeInfo.this, "Invalid Clinic name", Toast.LENGTH_LONG).show();
        } else {
            UserRef.child(MainActivity.getUser().getUsername()).setValue(new Clinic(name, address, phonenum, insurance, payment));
            finish();
        }
    }



    public static final Pattern VALID_PHONENUM  = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$\n", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_ADDRESS_REGEX = Pattern.compile("[A-Za-z0-9'\\.\\-\\s\\,]", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE);

    public static boolean validatephonenum(String phonenum) {
        Matcher matcher = VALID_PHONENUM.matcher(phonenum);
        return matcher.find();
    }

    public static boolean validateaddress(String address) {
        Matcher matcher = VALID_ADDRESS_REGEX.matcher(address);
        return matcher.find();
    }

    public static boolean validatename(String name) {
        Matcher matcher = VALID_NAME_REGEX.matcher(name);
        return matcher.find();
    }



    public boolean validate(String phonenum, String address, String name, String insurance, String payment) {
        return validatephonenum(phonenum) && validateaddress(address) && validatename(name) && insurance != "" && payment != "";

    }



}


