package com.example.seg2105;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WelcomeScreen extends AppCompatActivity {

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

}
