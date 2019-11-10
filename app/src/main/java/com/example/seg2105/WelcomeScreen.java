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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeScreen extends AppCompatActivity {

    ListView listview;
    List list = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        TextView textView = (TextView) findViewById(R.id.UserName);
        textView.setText(MainActivity.getUser().getName());
        TextView text2 = (TextView) findViewById(R.id.role);
        text2.setText(MainActivity.getUser().getRole());

       listview = (ListView)findViewById(R.id.list_view);

        list.add("hello");
        list.add("this");
        list.add("list");
        list.add("actually");
        list.add("works");

        adapter = new ArrayAdapter(WelcomeScreen.this,android.R.layout.simple_expandable_list_item_1,list);
        listview.setAdapter(adapter);
    }

    protected void onClick(View view){
        Intent intent = new Intent(getApplicationContext(), AdminScreen.class);

    }

}
