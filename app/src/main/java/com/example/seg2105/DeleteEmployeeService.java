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

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private ArrayList<TextView> textViews = new ArrayList<>();
    final DatabaseReference userRef = database.getReference("users");
    Boolean alreadySeenService = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee_service);

        getAllServices();

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
