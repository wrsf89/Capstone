package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class account extends AppCompatActivity {

//변수가 이미지버튼이라는 선언
private ImageButton imageButton4,imageButton6,imageButton5,imageButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //버튼과 함수 매칭
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton6 = findViewById(R.id.imageButton6);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton7 = findViewById(R.id.imageButton7);


//이미지버튼4가 눌렸을때
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //데이터를 담고 다른 요소로부터 작업을 요청하는 클래스인 인텐트를 선언해주고,
                //인텐트를 이용하여 mkd3화면(로그인 화면)으로 넘어감
                Intent intent = new Intent(account.this, activity_mkd3.class);
                startActivity(intent);
            }
        });

        //이미지 버튼6이 눌렸을 때
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트 선언후 메인액티비티화면(회원가입 화면)으로 넘어감
                Intent intent = new Intent(account.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this, MemberFindLoginIdActivity2.class);
                startActivity(intent);
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Intent intent = new Intent(account.this, MemberFindLoginPwActivity2.class);
                startActivity(intent);
            }
       });




    }
}