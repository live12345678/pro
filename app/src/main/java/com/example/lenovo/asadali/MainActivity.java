package com.example.lenovo.asadali;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText user = (EditText) findViewById(R.id.txtUser);
        final EditText pass = (EditText) findViewById(R.id.txtPass);

        Button login= (Button) findViewById(R.id.btnLogin);
        Button register = (Button) findViewById(R.id.btnRegister);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = user.getText().toString();
                String p = pass.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", 0);
                String userdeail = sharedPreferences.getString(u + p, "Details of User Are Incorrect");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("display", userdeail);
                editor.commit();

                Intent displayScreen = new Intent(MainActivity.this, Display.class);
                startActivity(displayScreen);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, Register.class);
                startActivity(register);
            }
        });



    }
}
