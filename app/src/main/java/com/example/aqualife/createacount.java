package com.example.aqualife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createacount extends Activity {
    EditText id, pw, pwc, pn;
    Button jo;
    FirebaseAuth auth;
    DatabaseReference user_db = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createacount);

        id = (EditText) findViewById(R.id.create_id);
        pw = (EditText) findViewById(R.id.create_pw);
        pwc = (EditText) findViewById(R.id.check_pw);
        pn = (EditText) findViewById(R.id.phone_number);
        jo = (Button) findViewById(R.id.create_join);


        auth = FirebaseAuth.getInstance();


        jo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String join_id = id.getText().toString().trim();
                final String join_pw = pw.getText().toString().trim();
                final String join_pwc = pwc.getText().toString().trim();
                final String join_pn = pn.getText().toString().trim();

                if (join_id.length() == 0 ) {
                    Toast.makeText(createacount.this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    id.requestFocus();
                    return;
                }
                if (join_pw.length() == 0) {
                    Toast.makeText(createacount.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    pw.requestFocus();
                    return;
                }
                if (join_pwc.length() == 0) {
                    Toast.makeText(createacount.this, "비밀번호확인을 입력하세요.", Toast.LENGTH_SHORT).show();
                    pwc.requestFocus();
                    return;
                }
                if (!join_pw.equals(join_pwc)) {
                    Toast.makeText(createacount.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    pwc.requestFocus();
                    return;
                }
                auth.createUserWithEmailAndPassword(join_id, join_pw).addOnCompleteListener(createacount.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            user_db.child("User").child("User1").child("ID").setValue(join_id);     // user / asd1111 / id = join_id
                            user_db.child("User").child("User1").child("PW").setValue(join_pw);
                            user_db.child("User").child("User1").child("PhoneNumber").setValue(join_pn);
                            Intent intent = new Intent(createacount.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(createacount.this, "계정생성을 실패했습니다.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });

            }
        });
    }
}
