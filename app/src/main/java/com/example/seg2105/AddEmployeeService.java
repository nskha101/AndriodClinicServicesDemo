package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private Boolean alreadyUse;
    private ArrayList<Button> buttons = new ArrayList<>();
    final DatabaseReference userRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_service);

        alreadyUse = true;
        getAllServices();


    }

    public void getAllServices(){
        servicesRef.child("services").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fetch all the child of Services
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {

                    Service currentChild = child.getValue(Service.class);
                    currentChild.print();
                    services.add(currentChild);
                    System.out.println(services.size());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void seeServices(View view){

        Button newBtn;
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayoutEmployee);
        if(alreadyUse) {
            for (int i = 0; i < services.size(); i++) {
                newBtn = new Button(this);
                newBtn.setText("Name: " + services.get(i).getServiceName() + " Rate: " + services.get(i).getRate() + "$" + " Staff: " + services.get(i).getEmployee());
                newBtn.setId(i);
                System.out.println(newBtn.getId());
                newBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int buttonid = v.getId();
                        Service serviceToAdd = services.get(buttonid);
                        TextView serviceAdded = findViewById(R.id.serviceAddedTextView);
                        userRef.child(MainActivity.getUser().getUsername()).child("userServices").child(serviceToAdd.getServiceName()).setValue(new Service(serviceToAdd.getServiceName(),serviceToAdd.getRate(),serviceToAdd.getEmployee()));
                        serviceAdded.setText(serviceToAdd.getServiceName() + " has been added to your list of clinics");
                    }
                });
                buttons.add(newBtn);
                layout.addView(newBtn);
            }
            alreadyUse = false;
        }
    }



}
