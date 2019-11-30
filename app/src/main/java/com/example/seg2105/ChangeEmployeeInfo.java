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

public class
ChangeEmployeeInfo extends AppCompatActivity{


    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference UserRef = database.getReference("users");
    final DatabaseReference Ref = database.getReference("clinics");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_info_screen);

        EditText clinicnametextfield = findViewById(R.id.clinicNameEditText);
        EditText clinicaddresstextfield = findViewById(R.id.clinicAddressEditText);
        EditText phonenumtextfield = findViewById(R.id.phoneNumberEditText);
        EditText insurancetypestextfield = findViewById(R.id.insuranceEditText); //convert to sha256
        EditText paymenttypestextfeild = findViewById(R.id.paymentEditText);

        Clinic clinic = EmployeeScreen.getUserClinic();

        clinicnametextfield.setText(clinic.getClinicName());
        clinicaddresstextfield.setText(clinic.getClinicAdress());
        phonenumtextfield.setText(clinic.getClinicPhoneNum());
        insurancetypestextfield.setText(clinic.getClinicInsurance());
        paymenttypestextfeild.setText(clinic.getClinicPayment());


    }

    public void onClick(View view) {
        //fields to make: String username,String email, String password, String name, String familyName
        EditText clinicnametextfield = findViewById(R.id.clinicNameEditText);
        EditText clinicaddresstextfield = findViewById(R.id.clinicAddressEditText);
        EditText clinicphonenumtextfield = findViewById(R.id.phoneNumberEditText);
        EditText clinicinsurancetypestextfield = findViewById(R.id.insuranceEditText); //convert to sha256
        EditText clinicpaymenttypestextfeild = findViewById(R.id.paymentEditText);
        TextView errorView = findViewById(R.id.errorView);


        //add radiobutton functionality for patient/employee pick (if patient radiobutton is picked, make role string = Patient, etc

        String name = clinicnametextfield.getText().toString();
        String address = clinicaddresstextfield.getText().toString();
        String phonenum = clinicphonenumtextfield.getText().toString();
        String insurance = clinicinsurancetypestextfield.getText().toString();
        String payment = clinicpaymenttypestextfeild.getText().toString();



        if (!validate(phonenum, address, name, insurance, payment)){
            Clinic clinic = EmployeeScreen.getUserClinic();
            clinicaddresstextfield.setText(clinic.getClinicAdress());
            clinicphonenumtextfield.setText(clinic.getClinicPhoneNum());
            clinicinsurancetypestextfield.setText(clinic.getClinicInsurance());
            clinicpaymenttypestextfeild.setText(clinic.getClinicPayment());

            Toast.makeText(ChangeEmployeeInfo.this, "One or more fields contain invalid data", Toast.LENGTH_LONG).show();
        } else {
            UserRef.child(MainActivity.getUser().getUsername()).child("clinic").child(EmployeeScreen.getUserClinic().getClinicName()).removeValue();
            Ref.child(EmployeeScreen.getUserClinic().getClinicName()).removeValue();
            UserRef.child(MainActivity.getUser().getUsername()).child("clinic").child(name).setValue(new Clinic(name, address, phonenum, insurance, payment));
            Ref.child(name).setValue(new Clinic (name,address,phonenum,insurance,payment, MainActivity.getUser().getUsername()));
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

    public static boolean validatename(String name){
        return !name.equals("");
    }



    public boolean validate(String phonenum, String address, String name, String insurance, String payment) {
        return phonenum !="" && address != "" && name != "" && insurance != "" && payment != "";

    }



}


