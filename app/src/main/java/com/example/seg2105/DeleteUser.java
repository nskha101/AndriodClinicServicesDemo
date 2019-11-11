package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DeleteUser extends AppCompatActivity {

    /*EditText temp = findViewById(R.id.usernameDeleteUser);
    String userDelete = temp.getText().toString();*/
    final ArrayList<Service> services = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference serviceRef = database.getReference();


        serviceRef.child("services").addValueEventListener(new ValueEventListener() {
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
        });*/



    }
    /*public void delete(View view){

        for(int i = 0; i<services.size(); i++){
            if(services.get(i).getServiceName().equals(userDelete)){
                ref.child("services").child(services.get(i).getServiceName()).removeValue();
            }
        }



    }*/
}