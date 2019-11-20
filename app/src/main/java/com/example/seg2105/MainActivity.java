package com.example.seg2105;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private static User userInstance;

    public static User getUser(){
        return userInstance;
    }

    public static void setUser(User user){
        userInstance = user;
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onResume(){
        super.onResume();
        Button userButton = (Button) findViewById(R.id.userPageButton);
        TextView userTextView = (TextView) findViewById(R.id.userTag);

        if(userInstance == null){
            userTextView.setText("you are not sign in!");
        }
        else if(userInstance.getRole().equals("Admin")){
            userTextView.setText("you are sign in as a Admin");
            userButton.setText("Admin Page");
        }
        else if(userInstance.getRole().equals("Employee")){
            userTextView.setText("you are sign in as a Employee");
            userButton.setText("Employee Page");
        }
        else if(userInstance.getRole().equals("Patient")){
            userTextView.setText("you are sign in as a Patient");
            userButton.setText("Patient Page");
        }

    }

    public static String toSHA256(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return toHexString(encodedhash);
        } catch(NoSuchAlgorithmException e) {
            return null;
        }
    }


    private static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public void goToSignIn(View view){
        Intent intent = new Intent(getApplicationContext(), SignIn.class);
        startActivity(intent);

    }

    public void goToSignUp(View view){
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(intent);
    }


    public void userPage(View view){
        if(MainActivity.getUser() == null){

        }
        else if(MainActivity.getUser().getRole().equals("Admin")){
            Intent intent = new Intent(getApplicationContext(), AdminScreen.class);
            startActivity(intent);
        }
        else if(MainActivity.getUser().getRole().equals(("Employee"))){
            Intent intent = new Intent(getApplicationContext(), EmployeeScreen.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
            startActivity(intent);
        }


    }

}
