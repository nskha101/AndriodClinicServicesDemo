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

public class editService extends AppCompatActivity {

    final ArrayList<Service> services = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_service);

        EditText serviceNameInput = (EditText) findViewById(R.id.editText);
        EditText newserviceNameInput = (EditText) findViewById(R.id.editText2);
        EditText newserviceRateInput = (EditText) findViewById(R.id.editText3);

        String servicename = serviceNameInput.getText().toString();
        String newservicename = newserviceNameInput.getText().toString();
        String newrate = newserviceRateInput.getText().toString();

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
        EditText newserviceName = findViewById(R.id.editText2);
        EditText newrateEdit = findViewById(R.id.editText3);
        String service = servicenameEditable.getText().toString();
        String newservice = newserviceName.getText().toString();
        String newrate = newrateEdit.getText().toString();
        String input = service + "/" + "rate";
        boolean isService = infoChecker(service);

        for (Service s: services) {
            s.print();
        }

        if(isService){

            Map<String, Object> userUpdates = new HashMap<>();
            userUpdates.put(input , newservice);
            userUpdates.put(service+ "/" + "serviceName", newrate );

            Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
            startActivity(intent);
            finish();
        }
        else{


        }

    }
}
