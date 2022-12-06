 package com.example.digitalclock;

 import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

 public class MainActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire up the alarm button to do so stuff
        //get the button
         Button button = (Button) findViewById(R.id.SetalarmBtn);
        //set what happen when user clicks on button
        button.setOnClickListener(v -> openAlarmClock());
    }

    //create openAlarmClock method
    public void openAlarmClock()
    {
        Intent intent = new Intent(this, AlarmClock.class);
        startActivity(intent);
    }

}

