package com.example.lenovo.asadali;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by Lenovo on 1/18/2017.
 */
public class Display  extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayinfo);

        SharedPreferences sharedPreferences = getSharedPreferences("MYPREF" , MODE_PRIVATE);
        String display = sharedPreferences.getString("display" , " ");

        TextView displayinfo = (TextView) findViewById(R.id.txtShow);
        displayinfo.setText(display);
    }

}
