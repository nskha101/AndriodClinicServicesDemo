package com.example.seg2105;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class WelcomeScreen extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private ListView listView;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ConstraintLayout mainLayout;
    private Handler mHandler = new Handler();




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



        mainLayout=(ConstraintLayout)findViewById(R.id.mainLayout);

        mainLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (MainActivity.getUser().getRole().equals("Admin")){
                    Intent intent = new Intent(getApplicationContext(), AdminScreen.class);
                    startActivity(intent);
                    finish();
                }
                else if (MainActivity.getUser().getRole().equals("Employee")){
                    Intent intent = new Intent(getApplicationContext(), EmployeeScreen.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), PatientScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
        });




    }

}
