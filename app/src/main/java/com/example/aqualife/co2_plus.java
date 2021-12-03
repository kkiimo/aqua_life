package com.example.aqualife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class co2_plus extends Activity {

    ImageButton top_led4, top_temp3, plus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co2_plus);

        top_led4 = (ImageButton) findViewById(R.id.led_top_led4);
        top_temp3 = (ImageButton) findViewById(R.id.top_temp3);
        plus = (ImageButton) findViewById(R.id.co2_plus);

        top_led4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2_plus.this, led.class);
                startActivity(intent);
            }
        });

        top_temp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2_plus.this, temparature.class);
                startActivity(intent);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(co2_plus.this, co2_res.class);
                startActivity(intent);
            }
        });




    }
}
