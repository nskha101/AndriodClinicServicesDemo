package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onCreateClick(View view){
        //feilds to make: String username,String email, String password, String name, String familyName
        EditText usernametextfeild = findViewById(R.id.usernamefeild);
        EditText emailtextfeild = findViewById(R.id.emailfeild);
        EditText passwordtextfeild = findViewById(R.id.passwordfeild); //convert to sha256
        EditText nametextfeild = findViewById(R.id.namefeild);
        EditText familyNametextfeild = findViewById(R.id.familyNamefeild);
        //add radiobutton functionality for patient/employee pick (if patient radiobutton is picked, make role string = Patient, etc

       String username = usernametextfeild.getText().toString();
       String email = emailtextfeild.getText().toString();
       String password = passwordtextfeild.getText().toString();
       String name = nametextfeild.getText().toString();
       String familyName = familyNametextfeild.getText().toString();
       String role = roleText;

    }

}
