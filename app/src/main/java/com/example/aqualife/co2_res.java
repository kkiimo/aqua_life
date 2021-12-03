package com.example.aqualife;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class co2_res extends Activity {



    ImageButton top_led, top_temp;
    TimePicker picker1, picker2;
//    String fname, str;
//    int hour, minute;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co2_res);

        top_led = (ImageButton)findViewById(R.id.led_top_led5);
        top_temp = (ImageButton)findViewById(R.id.top_temp_2);

//        picker1 = (TimePicker) findViewById(R.id.time);
//        picker2 = (TimePicker) findViewById(R.id.time);
//
//        picker1.setIs24HourView(true);
//        picker2.setIs24HourView(true);


        top_led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2_res.this, led.class);
                startActivity(intent);
            }
        });

        top_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2_res.this, temparature.class);
                startActivity(intent);
            }
        });

    }

//    @SuppressLint("WrongConstant")
//    public void saveDiary (String readDay) {
//        FileOutputStream fos=null;
//
//        picker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int p_hour, int p_minute) {
//                hour = p_hour;
//                minute = p_minute;
//            }
//        });
//        try{
//            if (hour == 0 && minute == 0) {
//                Long now = System.currentTimeMillis();
//                Date date = new Date(now);
//                SimpleDateFormat dateFormat = new SimpleDateFormat("hh : mm");
//                String gettime = dateFormat.format(date);
//                Log.d("T", gettime);
//                String[] times = gettime.split(":");
//                hour = Integer.parseInt(times[0].trim());
//                Log.d("H", String.valueOf(hour));
//                minute = Integer.parseInt(times[1].trim());
//                Log.d("M", String.valueOf(minute));
//            }
//            fos=openFileOutput(readDay,MODE_NO_LOCALIZED_COLLATORS);
//            String content = "" + hour + ":" + minute;
//            fos.write((content).getBytes());
//            fos.close();
//        }catch (Exception e){
//            Log.d("XX", "XX");
//        }
//    }

}



