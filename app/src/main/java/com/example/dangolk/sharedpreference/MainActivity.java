package com.example.dangolk.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userInput, passwordInput;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        userInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput   = (EditText) findViewById(R.id.passwordInput);

        myText = (TextView) findViewById(R.id.myText);



    }

    public void saveInfo(View view){
        SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpref.edit();

        editor.putString("username", userInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());

        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();


    }

    public void displayData(View view){

        SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        String name = sharedpref.getString("username", "");
        String password = sharedpref.getString("password","");

        myText.setText(name + " " + password);

    }

}
