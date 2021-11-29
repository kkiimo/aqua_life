package com.example.aqualife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class changewater extends Activity {

    ImageButton plus, ch_top_home, ch_top_feeding;
    Button ch_top_ph;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changewater);

        plus = (ImageButton) findViewById(R.id.plus);

        //ch_top_ph = (Button) findViewById(R.id.ch_top_ph);
        ch_top_home = (ImageButton) findViewById(R.id.ch_top_home);
        ch_top_feeding = (ImageButton) findViewById(R.id.ch_top_feeding);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(changewater.this, changewater_plus.class);
                startActivity(intent);
            }
        });

        ch_top_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(changewater.this, home.class);
                startActivity(intent);
            }
        });


        ch_top_feeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(changewater.this, feeding.class);
                startActivity(intent);
            }
        });

    }
}
