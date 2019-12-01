package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchClinicByService extends AppCompatActivity {

    final ArrayList<Clinic> clinics = new ArrayList<>();
    final ArrayList<Service> services = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference clinicRef = database.getReference().child("clinics");
    DatabaseReference serviceRef = database.getReference().child("services");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clinic_by_service);
    }

    private void getAllClinic(){

        clinicRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fetch all the child of Services
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {

                    Clinic currentChild = child.getValue(Clinic.class);
                    currentChild.print();
                    clinics.add(currentChild);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void getAllServices(){
        serviceRef.addValueEventListener(new ValueEventListener() {
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

    /*private void showClinic(){

        Button newBtn;
        ScrollView layout = (ScrollView) findViewById(R.id.searchByServiceScroll);
        ArrayList<Integer> dayIndex= new ArrayList<>();
        EditText serviceEditView = findViewById(R.id.SearchByServiceSearchBar);
        String serviceString = serviceEditView.getText().toString();

        for(int p = 0; p < neededClinicsIndex.size(); p++){
            System.out.println(clinics.get(neededClinicsIndex.get(p)));
            for(int o = 0; o< hours.get(neededClinicsIndex.get(p)).size(); o++){
                if(hours.get(neededClinicsIndex.get(p)).get(o).equals(dayString)){
                    System.out.println(hours.get(neededClinicsIndex.get(p)).get(o));
                    dayIndex.add(o);
                }
            }
        }

        for (int i = 0; i < neededClinicsIndex.size(); i++) {
            newBtn = new Button(this);
            newBtn.setText("Name: " + clinics.get(neededClinicsIndex.get(i).getClinicIndex()).getClinicName() + " Start Time: " + hours.get(neededClinicsIndex.get(i).getDayIndex()).get(dayIndex.get(i)).getStartTime() + "  " + " End Time: " + hours.get(neededClinicsIndex.get(i).getDayIndex()).get(dayIndex.get(i)).getEndTime());
            newBtn.setId(i);
            System.out.println(newBtn.getId());
            /*newBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int buttonid = v.getId();
                    Service serviceToAdd = services.get(buttonid);
                    TextView serviceAdded = findViewById(R.id.serviceAddedTextView);
                    userRef.child(MainActivity.getUser().getUsername()).child("userServices").child(serviceToAdd.getServiceName()).setValue(new Service(serviceToAdd.getServiceName(),serviceToAdd.getRate(),serviceToAdd.getEmployee()));

                }
            });
            //buttons.add(newBtn);
            layout.addView(newBtn);
        }

    }*/

}
