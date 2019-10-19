package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SignIn extends AppCompatActivity {

    //Make sure that the database reference is our database

    final ArrayList<User> users = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference();
        userRef
        userRef.child("users").addValueEventListener(new ValueEventListener() {
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

    public boolean infoChecker(final String currentUsername, final String currentPassword){

        String shaPassword = /*MainActivity.toSHA256(*/currentPassword/*)*/;
        TextView errorText = findViewById(R.id.errorText);
        errorText.setText("Working");
        errorText.setText(String.valueOf(users.size()));

        for (int i=0; i<users.size(); i++) {
            errorText.setText(users.get(i).toString());
            if(users.get(i).getUsername().equals(currentUsername)){
                errorText.setText("The login info was not correct!(Username found)");
                System.out.println("Username match");

                if(users.get(i).getPassword().equals(shaPassword)){

                    System.out.println("password match");
                    return true;

                }
                //This is false beacause the user is found but the password doesnt match
                return false;
            }

        }
        //This is false because the username was not found
        return false;

    }

    public void onClickCheck(View view){



        EditText usernameEditable = findViewById(R.id.usernameID);
        EditText passwordEditable =  findViewById(R.id.passwordID);
        String username = usernameEditable.getText().toString();
        String password = passwordEditable.getText().toString();
        boolean isUser = infoChecker(username, password);

        for (User u: users) {
            u.print();
        }

        if(isUser){
            Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
            startActivity(intent);
        }
        else{


        }

    }
}
