package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateClinic extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference userRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_clinic);

        EditText clinicNameInput = (EditText) findViewById(R.id.clinicnamefield);

        String clinicename = clinicNameInput.getText().toString();

        Button button = (Button) findViewById(R.id.createbutton);
    }

    public void onClick(View view){
        //hello
        /*Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
        startActivity(intent);*/

        EditText clinicNameInput = (EditText) findViewById(R.id.clinicnamefield);

        String clinicName = clinicNameInput.getText().toString();


        System.out.println(MainActivity.getUser().getUsername());

        userRef.child(MainActivity.getUser().getUsername()).child("clinic").child(clinicName).setValue(new Clinic (clinicName));

    }
}
