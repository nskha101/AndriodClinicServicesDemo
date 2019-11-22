package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

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


    public void onClick(View view) {
        //hello
        /*Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
        startActivity(intent);*/


        EditText clinicNameInput = (EditText) findViewById(R.id.clinicnamefield);

        TextView message = (TextView) findViewById(R.id.confirm);

        System.out.println(clinicNameInput.getText().toString());

        if (/*validateClinc(clinicNameInput.getText().toString()) ||*/ clinicNameInput.getText().toString().equals("")) {
            message.setText("Please enter a clinic name");
        }

        else{
            String clinicName = clinicNameInput.getText().toString();


            System.out.println(MainActivity.getUser().getUsername());

            Clinic clinic = new Clinic(clinicName,"","","","");

            MainActivity.getUser().setClinic(clinic);

            userRef.child(MainActivity.getUser().getUsername()).child("clinic").child(clinicName).setValue(new Clinic (clinicName,"","","",""));

            finish();
        }

        //child(clinicName).setValue(new Clinic(clinicName));

    }


    public static boolean validateClinc(String clinicname) {
        Matcher matcher = VALID_CLINIC_REGEX.matcher(clinicname);
        return matcher.find();
    }


}
