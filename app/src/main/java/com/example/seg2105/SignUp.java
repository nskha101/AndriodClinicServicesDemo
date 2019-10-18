package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


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
        String password = null;
        try {
            password = MainActivity.toSHA256(passwordtextfeild.getText().toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String name = nametextfeild.getText().toString();
       String familyName = familyNametextfeild.getText().toString();
       //String role = roleText;

       UserRef.child(username).setValue(new User(username, email, password, name, familyName, role));
    }


}
