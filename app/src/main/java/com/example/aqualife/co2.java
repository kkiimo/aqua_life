package com.example.aqualife;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class co2 extends Activity {

    ImageButton top_led, top_temp_, led_plus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co2);

        top_led = (ImageButton) findViewById(R.id.led_top_led3);
        top_temp_ = (ImageButton) findViewById(R.id.top_temp_);
        led_plus = (ImageButton) findViewById(R.id.led_plus2);


        led_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2.this, co2_plus.class);
                startActivity(intent);
            }
        });

        top_led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2.this, led.class);
                startActivity(intent);
            }
        });

        top_temp_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2.this, temparature.class);
                startActivity(intent);
            }
        });



    }
}
