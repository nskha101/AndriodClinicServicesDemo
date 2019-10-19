package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


public class SignUp extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference UserRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

    public void onCreateClick(View view){
        //fields to make: String username,String email, String password, String name, String familyName
        EditText usernametextfield = findViewById(R.id.usernamefield);
        EditText emailtextfield = findViewById(R.id.emailfield);
        EditText passwordtextfeild = findViewById(R.id.passwordfield); //convert to sha256
        EditText nametextfeild = findViewById(R.id.namefield);
        EditText familyNametextfeild = findViewById(R.id.familyNamefield);

        //add radiobutton functionality for patient/employee pick (if patient radiobutton is picked, make role string = Patient, etc

       String username = usernametextfield.getText().toString();
       String email = emailtextfield.getText().toString();
       String password = passwordtextfeild.getText().toString();
       password = passwordtextfeild.getText().toString();
       String name = nametextfeild.getText().toString();
       String familyName = familyNametextfeild.getText().toString();
       boolean checked = ((RadioButton) view).isChecked();

       if(!validate(username, email, password, name, familyName, checked)){
            //make textview that says invalid password, clear all feilds and try again
       }

       String role = "";
       password = MainActivity.toSHA256(password);
        switch(view.getId()) {
            case R.id.patientButton:
                if (checked)
                    role = "Patient";
                    break;
            case R.id.employeeButton:
                if (checked)
                    role = "Employee";
                    break;
        }
       UserRef.child(username).setValue(new User(username, email, password, name, familyName, role));
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_USERNAME_REGEX = Pattern.compile("^[a-z0-9_-]{3,15}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}", Pattern.CASE_INSENSITIVE);


    public boolean validateEmail(String emailId) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailId);
        return matcher.find();
    }
    public boolean validatePassword (String password){
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return (matcher.find()) && (6 <= password.length() && 12 >= password.length());

    }
    public boolean validateUsername(String username){
        Matcher matcher = VALID_USERNAME_REGEX.matcher(username);
        return (matcher.find()) && (6 <= username.length() && 12 >= username.length());

    }

    public boolean validateName(String name){
        Matcher matcher = VALID_NAME_REGEX.matcher(name);
        return (matcher.find());

    }

    public boolean validate(String username,String email, String password, String name, String familyName, boolean checked){
        return validateEmail(email) && validatePassword(password) && validateName(name) && validateName(familyName) && validateUsername(username) && checked;
    }

}
