package com.example.aqualife;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class changewater_plus extends Activity {

    int hour, minute;
    ImageButton top_home, ch_top_feeding;
    Button top_ph, set;
    CalendarView calendar;
    TimePicker picker;
    String fname, str;
    TextView debug;



        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changewater_plus);

        ch_top_feeding = (ImageButton) findViewById(R.id.ch_top_feeding);
        calendar = (CalendarView) findViewById(R.id.calendar);
        top_home = (ImageButton) findViewById(R.id.top_home);
        set = (Button) findViewById(R.id.set_time);
        picker = (TimePicker) findViewById(R.id.time);
        picker.setIs24HourView(true);
        debug = (TextView) findViewById(R.id.debug);


        ch_top_feeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(changewater_plus.this, feeding.class);
                startActivity(intent);
            }
        });

        top_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(changewater_plus.this, home.class);
                startActivity(intent);
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                set.setVisibility(View.VISIBLE);
                picker.setVisibility(View.VISIBLE);

                String s = String.format("%d.%d.%d", year, month, day);
                checkday(year, month, day);
                Log.d("s", s);
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDiary(fname);
                set.setVisibility(View.GONE);
                picker.setVisibility(View.GONE);

            }
        });
    }

    void checkday(int year, int month, int day) {
        fname = "" + year + "_" + month + "_" + day + ".txt";
        FileInputStream fis = null;

        try {
            fis = openFileInput(fname);
            Log.d("X", "1");

            byte[] fileData = new byte[fis.available()];
            Log.d("X", "2");
            fis.read(fileData);
            Log.d("X", "3");
            fis.close();
            Log.d("X", "4");

            str = new String(fileData);
            Log.d("X", "5");
            Log.d("X", str);
            debug.setText(str);
            Log.d("X", "6");

        } catch (Exception e) {
            Log.d("X","X");

        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay){
        FileOutputStream fos=null;


        picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int p_hour, int p_minute) {
                hour = p_hour;
                minute = p_minute;
            }
        });
        try{
            if (hour == 0 && minute == 0) {
                Long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh : mm");
                String gettime = dateFormat.format(date);
                Log.d("T", gettime);
                String[] times = gettime.split(":");
                hour = Integer.parseInt(times[0].trim());
                Log.d("H", String.valueOf(hour));
                minute = Integer.parseInt(times[1].trim());
                Log.d("M", String.valueOf(minute));
            }
            fos=openFileOutput(readDay,MODE_NO_LOCALIZED_COLLATORS);
            String content = "" + hour + ":" + minute;
            fos.write((content).getBytes());
            fos.close();
        }catch (Exception e){
            Log.d("XX", "XX");
        }
    }



}




