package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class DeleteService extends AppCompatActivity {

    final ArrayList<Service> services = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference servicesRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_service);

        servicesRef.child("services").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fetch all the child of Services
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

    public void delete(View view){

        boolean worked = false;
        EditText serviceDeleteField = findViewById(R.id.usernameDeleteService);
        String serviceDelete = serviceDeleteField.getText().toString();
        TextView errorMessageField = findViewById(R.id.errorMessageDeleteService);


        for(int i = 0; i<services.size(); i++){
            if(services.get(i).getServiceName().equals(serviceDelete)){
                servicesRef.child("services").child(services.get(i).getServiceName()).removeValue();
                serviceDeleteField.setText(" ");
                worked = true;

            }
        }
        if(worked){
            errorMessageField.setText("Service delete!");
        }
        else{
            errorMessageField.setText("Service not find!");
        }

    }

}
