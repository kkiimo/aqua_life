package com.example.aqualife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class home extends Activity {

    ImageButton changewater, feeding, led, temparature, top_changewater;
    Button co2, ph, top_ph;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        changewater = (ImageButton) findViewById(R.id.changewater);
        feeding = (ImageButton) findViewById(R.id.feeding);
        led = (ImageButton) findViewById(R.id.led);
        temparature = (ImageButton) findViewById(R.id.temparature);
        co2 = (Button) findViewById(R.id.co2);
        ph = (Button) findViewById(R.id.ph);

        top_changewater = (ImageButton) findViewById(R.id.top_changewater);
        top_ph = (Button) findViewById(R.id.top_ph);

        // Viewpager2 vp = findViewById(R.id.)

        changewater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, changewater.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        feeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, feeding.class);
                startActivity(intent);
            }
        });
        led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, led.class);
                startActivity(intent);
            }
        });
        co2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, co2.class);
                startActivity(intent);
            }
        });
        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, ph.class);
                startActivity(intent);
            }
        });

        temparature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, temparature.class);
                startActivity(intent);
            }
        });

        top_changewater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, changewater.class);
                startActivity(intent);
            }
        });

        top_ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, ph.class);
                startActivity(intent);
            }
        });



    }
}
