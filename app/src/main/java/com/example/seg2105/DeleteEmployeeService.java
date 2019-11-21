package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DeleteEmployeeService extends AppCompatActivity {

    final ArrayList<Service> services = new ArrayList<>();
    final ArrayList<Hours> hours = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private ArrayList<TextView> textViews = new ArrayList<>();
    final DatabaseReference userRef = database.getReference("users");
    Boolean alreadySeenService = false;

    private TextView monday = findViewById(R.id.mondayLabel);
    private TextView tuseday = findViewById(R.id.tuesdayLabel);
    private TextView wednesday = findViewById(R.id.wednesdayLabel);
    private TextView thursday = findViewById(R.id.thursdayLabel);
    private TextView friday = findViewById(R.id.fridayLabel);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee_service);

        getAllServices();
        getUserHours();


    }

    public void getAllServices(){
        userRef.child(MainActivity.getUser().getUsername()).child("userServices").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fetch all the child of Services
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for(int i =0; i<services.size(); i++){
                    services.remove(i);
                }
                for (DataSnapshot child: children) {

                    Service currentChild = child.getValue(Service.class);
                    currentChild.print();
                    services.add(currentChild);
                    System.out.println(services.size());
                }
                if(!alreadySeenService) {
                    alreadySeenService = true;
                    seeServices();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getUserHours(){
        userRef.child("users").child(MainActivity.getUser().getUsername()).child("clinic").child("hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fet all the child of User
                for(int i =0; i<hours.size(); i++){
                    hours.set(i,null);
                }
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {

                    Hours currentChild = child.getValue(Hours.class);
                    switch (currentChild.getDay()){
                        case "Monday": hours.set(0,currentChild);
                        break;
                        case "Tuseday": hours.set(1,currentChild);
                        break;
                        case "Wednesday": hours.set(2,currentChild);
                        break;
                        case "Thursday": hours.set(3,currentChild);
                        break;
                        case "Friday": hours.set(4,currentChild);
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void seeDayHours(){

    }

    public void seeServices(){
        TextView newTextView;
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayoutDeleteEmplyoee);
        for(int i =0; i<services.size(); i++){
            newTextView = new TextView(this);
            newTextView.setText("Name: " + services.get(i).getServiceName() + " Rate: " + services.get(i).getRate() + "$" + " Staff: " + services.get(i).getEmployee());
            newTextView.setId(i);
            textViews.add(newTextView);
            layout.addView(newTextView);
        }

    }

    public void onClick(View v){
        EditText serviceToDeleteEditText = (EditText) findViewById(R.id.deleteField);
        String serviceToDelete = serviceToDeleteEditText.getText().toString();
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayoutDeleteEmplyoee);
        TextView messageView = findViewById(R.id.deleteServiceEmployeeMessage);
        Boolean findService = false;

        for (int i =0; i<services.size();i++ ){
            if(serviceToDelete.equals(services.get(i).getServiceName())){
                findService = true;
                messageView.setText("Service deleted from employee account");
                int serviceToDeleteid = i;
                userRef.child(MainActivity.getUser().getUsername()).child("userServices").child(serviceToDelete).removeValue();
                layout.removeView(textViews.get(serviceToDeleteid));
                services.remove(serviceToDeleteid);
                textViews.remove(serviceToDeleteid);
                for(int j =0; j<textViews.size();j++ ){
                    textViews.get(j).setId(j);
                }
            }
        }
        if(!findService) {
            messageView.setText("No service with that name found!");
        }

    }

}
