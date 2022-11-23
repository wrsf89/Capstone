package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Mypage extends AppCompatActivity {
    private ImageButton bottomHomeBtn, bottomBackBtn;
    private Button btn_test3 , matching_list , btn_test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userServiceID = intent.getStringExtra("userServiceID");
        Log.v("test_Mypage",userServiceID);

//매칭목록
        matching_list = findViewById(R.id.matching_list);
        matching_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mypage.this, Mkd2Activity.class);
                intent.putExtra("userID", userID);
                intent.putExtra("userServiceID", userServiceID);
                startActivity(intent);
            }
        });

        bottomHomeBtn = findViewById(R.id.bottomHomeBtn);
        bottomHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


        bottomBackBtn = findViewById(R.id.bottomBackBtn);
        bottomBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        btn_test2 = findViewById(R.id.btn_test2);
        btn_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mypage.this, loginMyPage.class);
                intent.putExtra("userID", userID);
                intent.putExtra("userServiceID", userServiceID);

                startActivity(intent);
            }
        });

        btn_test3 = findViewById(R.id.btn_test3);
        btn_test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mypage.this, apply_list.class);
                intent.putExtra("userID", userID);
                intent.putExtra("userServiceID", userServiceID);
                startActivity(intent);
            }
        });


    }}
