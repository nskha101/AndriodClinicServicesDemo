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

public class DeleteUser extends AppCompatActivity {


    final ArrayList<User> users = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference usersRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);


       usersRef.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fet all the child of User
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {

                    User currentChild = child.getValue(User.class);
                    currentChild.print();
                    users.add(currentChild);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    public void delete(View view){

        boolean worked = false;
        EditText userDeleteField = findViewById(R.id.usernameDeleteService);
        String userDelete = userDeleteField.getText().toString();
        TextView errorMessageField = findViewById(R.id.errorMessageField);


        for(int i = 0; i<users.size(); i++){
            if(users.get(i).getUsername().equals(userDelete)){
                usersRef.child("users").child(users.get(i).getUsername()).removeValue();
                userDeleteField.setText(" ");
                worked = true;

            }
        }
        if(worked){
            errorMessageField.setText("User deleted!");
        }
        else{
            errorMessageField.setText("Username not found!");
        }

    }
}