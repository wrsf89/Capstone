package com.example.signup;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MemberFindLoginPwActivity2 extends AppCompatActivity {


    private Button buttonDoFindLoginPW,buttonCancel;
    private TextView signID, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_find_login_pw2);

        signID = findViewById(R.id.signID);
        name = findViewById(R.id.name);
        buttonDoFindLoginPW = findViewById(R.id.buttonDoFindLoginPW);
        buttonCancel = findViewById(R.id.buttonCancel);


        buttonDoFindLoginPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userID = signID.getText().toString();
                final String username = name.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String userPW = jsonResponse.getString("userPW");
                                Toast.makeText(getApplicationContext(), "회원님의 비밀번호는 " + userPW + " 입니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MemberFindLoginPwActivity2.this, activity_mkd3.class);
                                MemberFindLoginPwActivity2.this.startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "비밀번호 찾기에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                PWCheckRequest PWCheckRequest = new PWCheckRequest(userID,username, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MemberFindLoginPwActivity2.this);
                queue.add(PWCheckRequest);






            }
        });

        //뒤로가기 버튼
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberFindLoginPwActivity2.this, account.class);
                startActivity(intent);
            }
        });











    }
}

