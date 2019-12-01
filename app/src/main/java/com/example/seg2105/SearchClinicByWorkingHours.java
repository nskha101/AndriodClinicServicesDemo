package com.example.seg2105;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchClinicByWorkingHours extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference Ref = database.getReference("clinics");
    final ArrayList<Clinic> clinics = new ArrayList<>();
    final ArrayList<Pair> neededClinicsIndex = new ArrayList<>();
    final ArrayList<ArrayList<Hours>> hours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clinic_by_hours);

        Spinner daySpinner = findViewById(R.id.searchDaySpinner);
        Spinner startTimeSpinner = findViewById(R.id.startingHoursSpinner);
        Spinner endTimeSpinner = findViewById(R.id.endingHoursSpinner);

        ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(this, R.array.dayOfTheWeek, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);
        daySpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> startAdapter = ArrayAdapter.createFromResource(this, R.array.timeSlot, android.R.layout.simple_spinner_item);
        startAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startTimeSpinner.setAdapter(startAdapter);
        startTimeSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> endAdapter = ArrayAdapter.createFromResource(this, R.array.timeSlot, android.R.layout.simple_spinner_item);
        endAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        endTimeSpinner.setAdapter(endAdapter);
        endTimeSpinner.setOnItemSelectedListener(this);

        getAllClinic();


    }

    public void getAllClinic(){

        Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    System.out.println("Test2");
                    Clinic currentChild = child.getValue(Clinic.class);
                    currentChild.print();
                    clinics.add(currentChild);

                }
                hours.clear();
                for(int i =0; i< clinics.size(); i++){
                    hours.add(new ArrayList<Hours>());
                    getAllhours(i);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void getAllhours(int i){


        System.out.println(clinics.get(i));
        System.out.println("number of clinic:" + hours.size());
        System.out.println(clinics.get(i).getClinicName());
        Ref.child(clinics.get(i).getClinicName()).child("hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("Test3");
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    System.out.println("Test4");
                    Hours currentChild = child.getValue(Hours.class);
                    //currentChild.print();
                    hours.get(hours.size()-1).add(currentChild);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("OnDataChange Failed!");
            }
        });


    }

    public void showClinic(){
        Spinner daySpinner = findViewById(R.id.searchDaySpinner);
        Spinner startTimeSpinner = findViewById(R.id.startingHoursSpinner);
        Spinner endTimeSpinner = findViewById(R.id.endingHoursSpinner);

        String dayString = daySpinner.getSelectedItem().toString();
        String startString = startTimeSpinner.getSelectedItem().toString();
        String endString = endTimeSpinner.getSelectedItem().toString();



        for(int i =0; i< clinics.size(); i++){
            for(int j =0; j< hours.get(i).size(); j++){
                System.out.println(hours.get(i).get(j));
                if(hours.get(i).get(j).getDay().equals(dayString)){
                    System.out.println("Test1");
                    neededClinicsIndex.add(new Pair(i,j));
                    System.out.println("Needed clinic index: " + i);
                }
            }

        }
    }

    public void onSearchClick(View view){
        Button newBtn;
        ScrollView layout = (ScrollView) findViewById(R.id.scrollLayoutSearchHours);
        ArrayList<Integer> dayIndex= new ArrayList<>();
        Spinner daySpinner = findViewById(R.id.searchDaySpinner);
        String dayString = daySpinner.getSelectedItem().toString();

        showClinic();

        /*for(int p = 0; p < neededClinicsIndex.size(); p++){
            System.out.println(clinics.get(neededClinicsIndex.get(p)));
            for(int o = 0; o< hours.get(neededClinicsIndex.get(p)).size(); o++){
                if(hours.get(neededClinicsIndex.get(p)).get(o).equals(dayString)){
                    System.out.println(hours.get(neededClinicsIndex.get(p)).get(o));
                    dayIndex.add(o);
                }
            }
        }*/

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
            });*/
            //buttons.add(newBtn);
            layout.addView(newBtn);
        }
        //alreadyUse = false;
    }

    public void onBackClick(){
        Intent intent = new Intent(getApplicationContext(), PatientScreen.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
