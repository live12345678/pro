package com.example.lenovo.asadali;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Lenovo on 1/18/2017.
 */
public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final EditText Un = (EditText) findViewById(R.id.txtRUser);
        final EditText pass = (EditText) findViewById(R.id.txtRPass);
        final EditText email = (EditText) findViewById(R.id.txtREmail);
        Button register = (Button) findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", 0);
                String Username = Un.getText().toString();
                String Password = pass.getText().toString();
                String EMAIL = email.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Username + Password + "data", Username + "/n" + EMAIL);
                editor.commit();

                Intent loginscreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginscreen);
            }
        });

    }
}