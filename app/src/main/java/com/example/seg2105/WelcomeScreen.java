package com.example.seg2105;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeScreen extends addService {

    private DatabaseReference mDatabase;

    private ListView listView;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        TextView textView = (TextView) findViewById(R.id.UserName);
        textView.setText(MainActivity.getUser().getName());
        TextView text2 = (TextView) findViewById(R.id.role);
        text2.setText(MainActivity.getUser().getRole());

        mDatabase = FirebaseDatabase.getInstance().getReference();

       adapter = new ArrayAdapter<String> (this, android.R.layout.simple_expandable_list_item_1, arrayList);

       listView = (ListView) findViewById(R.id.list_view);

   /* mDatabase.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            String string = dataSnapshot.getValue(String.class);
            arrayList.add(string);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

    */
    }


    public void onClick(View view){
        Intent intent = new Intent(getApplicationContext(), AdminScreen.class);
        startActivity(intent);
    }
}
