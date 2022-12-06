package com.example.digitalclock;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AlarmClock extends AppCompatActivity {

    EditText timeHour;
    EditText timeMinutes;
    Button setTime;
    Button setAlarm;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinutes;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);

        timeHour = findViewById(R.id.ethours);
        timeMinutes = findViewById(R.id.etminutes);
        setTime = findViewById(R.id.btnTime);
        setAlarm = findViewById(R.id.btnAlarm);

        //When user tapping set time button then it will show the time picker dialog
        setTime.setOnClickListener( (v) ->
        {
            //intialize calendar
            calendar= Calendar.getInstance();
                currentHour =calendar.get(Calendar.HOUR_OF_DAY);
                currentMinutes = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(AlarmClock.this, (timePicker, hourOfDay, minute) ->
                {
                    timeHour.setText(String.format("%02d",hourOfDay));
                    timeMinutes.setText(String.format("%02d",minute));

                    //time picker  to support a 24 hours view or not
                }, currentHour, currentMinutes, false);

                timePickerDialog.show();

        });

        //when tapping set alarm button
        setAlarm.setOnClickListener(v -> {

            if (!timeHour.getText().toString().isEmpty() && !timeMinutes.getText().toString().isEmpty())
            {
                Intent intent = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(android.provider.AlarmClock.EXTRA_HOUR,Integer.parseInt(timeHour.getText().toString()));
                intent.putExtra(android.provider.AlarmClock.EXTRA_MINUTES,Integer.parseInt(timeMinutes.getText().toString()));
                intent.putExtra(android.provider.AlarmClock.EXTRA_MESSAGE, "Set alarm for wake up");

                startActivity(intent);

            } else {
                Toast.makeText(AlarmClock.this,"Please choose a time", Toast.LENGTH_SHORT).show();

            }


        });


    }
}