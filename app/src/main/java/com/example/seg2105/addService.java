package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addService extends AppCompatActivity {

    EditText serviceNameInput;
    EditText serviceRateInput;
    Service service;
    WelcomeScreen welcome;
    //Service[] services = new Service[10];
    //int tail= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        service = new Service();
        welcome= new WelcomeScreen();
        serviceNameInput = (EditText) findViewById(R.id.serviceName);
        serviceRateInput = (EditText) findViewById(R.id.serviceRate);

        service.setServiceName(serviceNameInput.toString());
        service.setRate(serviceRateInput.toString());
        welcome.addService(service);

    }

    public void onClick(View view){
        Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
        startActivity(intent);
    }
}
