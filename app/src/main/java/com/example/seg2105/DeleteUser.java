package com.example.seg2105;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DeleteUser extends AppCompatActivity {

    EditText temp = findViewById(R.id.username);
    String userDelete = temp.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
    }
    public void delete(View view){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query nameQuery = ref.child("firebase").orderByChild("users").equalTo(userDelete); //name

        nameQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    nameSnapshot.getRef().removeValue();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
    });
    }
}