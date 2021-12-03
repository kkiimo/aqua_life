package com.example.aqualife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class led_plus extends Activity {

    ImageButton led_top_feeding2;
    Button led_top_co2_2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.led_plus);

        led_top_feeding2 = (ImageButton) findViewById(R.id.led_top_feeding2);
        led_top_co2_2 = (Button) findViewById(R.id.led_top_co2_2);

        led_top_feeding2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(led_plus.this, feeding.class);
                startActivity(intent);
            }
        });

        led_top_co2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(led_plus.this, co2.class);
                startActivity(intent);
            }
        });



    }
}
