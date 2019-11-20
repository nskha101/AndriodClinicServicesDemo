package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static final Pattern VALID_CLINIC_REGEX = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE);

    public void onClick(View view){
        //hello
        /*Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
        startActivity(intent);*/

        EditText clinicNameInput = (EditText) findViewById(R.id.clinicnamefield);

        String clinicName = clinicNameInput.getText().toString();


        System.out.println(MainActivity.getUser().getUsername());

        userRef.child(MainActivity.getUser().getUsername()).child("clinic").child(clinicName).setValue(new Clinic (clinicName));


            if(!validateClinc(clinicName)){
        clinicNameInput.setText("");
        Toast.makeText(CreateClinic.this, "Invalid Clinic name",
                Toast.LENGTH_LONG).show();
    }

        userRef.child(MainActivity.getUser().getUsername()).child("clinic").child(clinicName).setValue(new Clinic (clinicName));

}

    public static boolean validateClinc(String clinicname) {
        Matcher matcher = VALID_CLINIC_REGEX.matcher(clinicname);
        return matcher.find();
    }
}
