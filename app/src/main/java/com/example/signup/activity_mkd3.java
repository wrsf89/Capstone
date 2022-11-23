package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class activity_mkd3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkd3);
        // 입력창이라고 선언 후 변수와 요소 매칭
        final EditText signID = findViewById(R.id.signID);
        final EditText signPW = findViewById(R.id.signPW);
        final Button signUpBtn = findViewById(R.id.signUpBtn);

        //사인업 버튼이 눌렸을때
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 각각의 함수가 스트링형태라고 선언 후 텍스트 내용을 받아오고 그것을 스트링(문자열) 객체로 저장
                final String userID = signID.getText().toString();
                final String userPassword = signPW.getText().toString();

                //서버와 통신하는 부분
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //예외 처리 구문 try catch
                        try {
                            //jason타입을 객체임을 선언
                            JSONObject jsonResponse = new JSONObject(response);

                            //데이터중 값이 "success"(일치)인 것을 가져옴
                            boolean success = jsonResponse.getBoolean("success");

                            //만약 값이 "success"(일치)라면
                            if (success) {
                                // 데이터베이스에 담겨져있는 userid를 userID_result에 str 형태로 담는다
                                String userID_result = jsonResponse.getString("userID");
                                String userServiceID_result = jsonResponse.getString("userServiceID");

                                //로그인에 성공했다는 메세지를 짧게 띄운다
                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();


                                Intent intent = new Intent(activity_mkd3.this, MainPage1.class);
                                //JSON타입으로 인텐트에 있는 putExtra 함수를 호출하여 아이디랑 서비스이용 값을 이동할 수 있도록 준비
                                intent.putExtra("userID", userID_result);
                                intent.putExtra("userServiceID", userServiceID_result);

                                //
                                activity_mkd3.this.startActivity(intent);
                            } else {//아니라면
                                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            //예외 발생시
                        } catch (Exception e) {
                            //에러 출력
                            e.printStackTrace();
                        }
                    }
                };

                //로그인 리퀘스트라는 클래스를 선언해주고 id와 password를 담아서 서버와 통신하는 부분
                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(activity_mkd3.this);
                queue.add(loginRequest);

            }

        });

    }
}









