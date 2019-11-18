package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EditService extends AppCompatActivity {
    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference serviceRef = database.getReference("services");
    final ArrayList<Service> services = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_service);

        /*EditText serviceNameInput = (EditText) findViewById(R.id.editText);
        EditText newserviceRateInput = (EditText) findViewById(R.id.editText3);
        EditText newserviceEmployeeInput = (EditText) findViewById(R.id.editText5);

        String servicename = serviceNameInput.getText().toString();
        String newrate = newserviceRateInput.getText().toString();
        String newEmployee = newserviceEmployeeInput.getText().toString();*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference();

        userRef.child("services").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fet all the child of User
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {

                    Service currentChild = child.getValue(Service.class);
                    currentChild.print();
                    services.add(currentChild);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public boolean infoChecker(final String servicename){

        TextView errorText = findViewById(R.id.error);

        for (int i=0; i<services.size(); i++) {

            if(services.get(i).getServiceName().equals(servicename)){
                return true;
            }

        }

        errorText.setText("Service not found!");
        //This is false because the username was not found
        return false;

    }

    public void onClickCheck(View view){



        EditText servicenameEditable = findViewById(R.id.editText);
        EditText newrateEdit = findViewById(R.id.editText3);
        EditText newEmployeeEdit = findViewById(R.id.editText5);
        String service = servicenameEditable.getText().toString();
        String newrate = newrateEdit.getText().toString();
        String newserviceemployee = newEmployeeEdit.getText().toString();

        boolean isService = infoChecker(service);

        for (Service s: services) {
            s.print();
        }

        if(isService){

            serviceRef.child(service).setValue(new Service(service,newrate,newserviceemployee));

            Intent intent = new Intent(getApplicationContext(), AdminScreen.class);
            startActivity(intent);
            finish();
        }
        else{


        }

    }
}
