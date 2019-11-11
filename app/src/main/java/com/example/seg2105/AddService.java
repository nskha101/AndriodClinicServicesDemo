package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddService extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference serviceRef = database.getReference("services");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);


        EditText serviceNameInput = (EditText) findViewById(R.id.serviceName);
        EditText serviceRateInput = (EditText) findViewById(R.id.serviceRate);

        String servicename = serviceNameInput.getText().toString();
        String rate = serviceRateInput.getText().toString();

        Button button = (Button) findViewById(R.id.button);

    }

    public void onClick(View view){
        /*Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
        startActivity(intent);*/

        EditText serviceNameInput = (EditText) findViewById(R.id.serviceName);
        EditText serviceRateInput = (EditText) findViewById(R.id.serviceRate);

        String servicename = serviceNameInput.getText().toString();
        String rate = serviceRateInput.getText().toString();

        serviceRef.child(servicename).setValue(new Service(servicename,rate));
        finish();
    }
}
