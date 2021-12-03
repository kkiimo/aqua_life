package com.example.aqualife;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class led extends Activity {

    ImageButton top_feeding, led_plus;
    Button top_co2, led_on, led_off;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.led);
        top_feeding = (ImageButton) findViewById(R.id.led_top_feeding);
        top_co2 = (Button) findViewById(R.id.led_top_co2);
        led_on = (Button) findViewById(R.id.led_on);
        led_off = (Button) findViewById(R.id.led_off);
        led_plus = (ImageButton) findViewById(R.id.led_plus);

        top_feeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(led.this, feeding.class);
                startActivity(intent);
            }
        });

        top_co2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(led.this, co2.class);
                startActivity(intent);
            }
        });

        led_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(led.this, led_plus.class);
                startActivity(intent);
            }
        });


    }
}
