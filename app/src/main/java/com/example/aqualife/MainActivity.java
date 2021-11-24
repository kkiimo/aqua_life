package com.example.aqualife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText id, pw, ph;
    Button jo, log;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.id);
        pw = (EditText) findViewById(R.id.pw);
        ph = (EditText) findViewById(R.id.phone_number);
        jo = (Button) findViewById(R.id.join);
        log = (Button) findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String login_id = id.getText().toString().trim();
                final String login_pw = pw.getText().toString().trim();
                if (login_id.length() == 0 || login_pw.length() == 0) {
                    Toast.makeText(MainActivity.this, "아이디,비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    auth.signInWithEmailAndPassword(login_id, login_pw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(MainActivity.this,home.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        jo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, createacount.class);
                startActivity(intent);
            }
        });
    }
}