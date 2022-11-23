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

public class MemberFindLoginIdActivity2 extends AppCompatActivity {


    private Button buttonDoFindLoginId,backBtn;

    //데이터 받아올 member 클래스의 리스트 생성
    member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_find_login_id2);


        buttonDoFindLoginId = findViewById(R.id.buttonDoFindLoginId);
        backBtn = findViewById(R.id.backBtn);
        final EditText name  = findViewById(R.id.name);
        final EditText signmail  = findViewById(R.id.signmail);

        buttonDoFindLoginId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usermail = signmail.getText().toString();
                final String username = name.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String userID = jsonResponse.getString("userID");
                                Toast.makeText(getApplicationContext(), "회원님의 아이디는 " + userID + " 입니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MemberFindLoginIdActivity2.this, activity_mkd3.class);
                                MemberFindLoginIdActivity2.this.startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "아이디찾기 에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                idfindRequest idfindRequest = new idfindRequest(usermail,username, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MemberFindLoginIdActivity2.this);
                queue.add(idfindRequest);






            }
        });

        //뒤로가기 버튼
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberFindLoginIdActivity2.this, account.class);
                startActivity(intent);
            }
        });

    }
}
