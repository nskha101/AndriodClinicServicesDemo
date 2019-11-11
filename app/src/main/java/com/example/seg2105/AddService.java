package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddService extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference serviceRef = database.getReference("services");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);


        EditText serviceNameInput = (EditText) findViewById(R.id.serviceName);
        EditText serviceRateInput = (EditText) findViewById(R.id.serviceRate);
        EditText serviceType = (EditText) findViewById(R.id.serviceType);

        String servicename = serviceNameInput.getText().toString();
        String rate = serviceRateInput.getText().toString();
        String type = serviceType.getText().toString();

        Button button = (Button) findViewById(R.id.button);

    }

    public void onClick(View view){
        //hello
        /*Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
        startActivity(intent);*/

        EditText serviceNameInput = (EditText) findViewById(R.id.serviceName);
        EditText serviceRateInput = (EditText) findViewById(R.id.serviceRate);
        EditText serviceTypeInput = (EditText) findViewById(R.id.serviceType);

        String servicename = serviceNameInput.getText().toString();
        String rate = serviceRateInput.getText().toString();
        String sertype = serviceTypeInput.getText().toString();
        if(validateService(servicename) && validateRate(rate) && validateSerType(sertype)) {
            serviceRef.child(servicename).setValue(new Service(servicename, rate, sertype));
        }
        else{
            serviceNameInput.setText("");
            serviceRateInput.setText("");
            serviceTypeInput.setText("");
            Context context = getApplicationContext();

            Toast toast = Toast.makeText(context, "Invalid entry", Toast.LENGTH_SHORT);
            toast.show();
        }
        finish();
    }
    public static final Pattern VALID_SERVICE_RATE = Pattern.compile("^[0-9]$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_SERTYPE = Pattern.compile("^[a-zA-Z\\s]*$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_NAME = Pattern.compile("^[a-zA-Z\\s]*$", Pattern.CASE_INSENSITIVE);

    public boolean validateService(String serviceName){
        Matcher matcher = VALID_NAME.matcher(serviceName);
        return (matcher.find());

    }
    public boolean validateSerType(String serType){
        Matcher matcher = VALID_SERTYPE.matcher(serType);
        return (matcher.find());
    }
    public boolean validateRate(String rate){
        Matcher matcher = VALID_SERVICE_RATE.matcher(rate);
        return (matcher.find());
    }
}
