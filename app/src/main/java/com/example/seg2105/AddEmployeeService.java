package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddEmployeeService extends AppCompatActivity {

    final ArrayList<Service> services = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference servicesRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_service);

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
        Button newBtn;
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayoutEmployee);
        newBtn = new Button(this);
        newBtn.setText(String.valueOf(services.size()));
        layout.addView(newBtn);
        for(int i=0; i <services.size(); i++){
            newBtn = new Button(this);
            newBtn.setText("Name: " + services.get(i).getServiceName() + " Rate: " + services.get(i).getRate() + " Staff: " + services.get(i).getEmployee());
            layout.addView(newBtn);
        }

    }
}
