package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference UserRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Spinner roleSpinner = findViewById(R.id.roleSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.roleChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);
        roleSpinner.setOnItemSelectedListener(this);

    }

    public void onCreateClick(View view) {
        //fields to make: String username,String email, String password, String name, String familyName
        EditText usernametextfield = findViewById(R.id.usernamefield);
        EditText emailtextfield = findViewById(R.id.emailfield);
        EditText passwordtextfeild = findViewById(R.id.passwordfield); //convert to sha256
        EditText nametextfeild = findViewById(R.id.namefield);
        EditText familyNametextfeild = findViewById(R.id.familyNamefield);
        Spinner roleSpinner = findViewById(R.id.roleSpinner);
        TextView errorView = findViewById(R.id.ErrorView);

        //add radiobutton functionality for patient/employee pick (if patient radiobutton is picked, make role string = Patient, etc

        String username = usernametextfield.getText().toString();
        String email = emailtextfield.getText().toString();
        String password;
        password = passwordtextfeild.getText().toString();
        String name = nametextfeild.getText().toString();
        String familyName = familyNametextfeild.getText().toString();
        String patientorEmployee = roleSpinner.getSelectedItem().toString();


        if (!validate(username, email, password, name, familyName)){
            usernametextfield.setText("");
            emailtextfield.setText("");
            passwordtextfeild.setText("");
            nametextfeild.setText("");
            familyNametextfeild.setText("");
            errorView.setText("Invalid Entry, please try again.");

        } else {
            password = MainActivity.toSHA256(password);
            UserRef.child(username).setValue(new User(username, email, password, name, familyName, patientorEmployee));
            finish();
        }
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_USERNAME_REGEX = Pattern.compile("^[a-z0-9_-]{3,15}$", Pattern.CASE_INSENSITIVE);


    public static boolean validateEmail(String emailId) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailId);
        return matcher.find();
    }

    public static boolean validatePassword(String password) {
        return (password.length() >= 6);

    }

    public static boolean validateUsername(String username) {
        Matcher matcher = VALID_USERNAME_REGEX.matcher(username);
        return (matcher.find()) && (6 <= username.length() && 12 >= username.length());

    }

    public static boolean validateName(String name) {
        Matcher matcher = VALID_NAME_REGEX.matcher(name);
        return (matcher.find());

    }


    public static boolean validatepatientorEmployee(String patientorEmployee) {
        return ((patientorEmployee.equals("patient")) || (patientorEmployee.equals("employee")));
    }

    public boolean validate(String username, String email, String password, String name, String familyName) {
        return validateEmail(email) && validatePassword(password) && validateName(name) && validateName(familyName) && validateUsername(username);
        // Log.d("VALIDATION", String.valueOf(validateEmail(email)));

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
