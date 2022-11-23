package com.example.signup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.util.Base64;

public class loginMyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_my_page);

        //선언
        TextView loginMyPageNameTv = findViewById(R.id.loginMyPageNameTv);
        TextView loginMyPageWhatTv = findViewById(R.id.loginMyPageWhatTv);
        TextView loginMyPageIDTv = findViewById(R.id.loginMyPageIDTv);
        TextView loginMyPageEmailTv = findViewById(R.id.loginMyPageEmailTv);
        TextView loginMyPagePWTv = findViewById(R.id.loginMyPagePWTv);
        TextView loginMyPageBirth1Tv = findViewById(R.id.loginMyPageBirth1Tv);
        TextView loginMyPageBirth2Tv = findViewById(R.id.loginMyPageBirth2Tv);
        TextView loginMyPageBirth3Tv = findViewById(R.id.loginMyPageBirth3Tv);
        TextView loginMyPageAddressTv = findViewById(R.id.loginMyPageAddressTv);
        TextView loginMyPagePhoneNBTv = findViewById(R.id.loginMyPagePhoneNBTv);
        TextView loginMyPageGenderTv = findViewById(R.id.loginMyPageGenderTv);
        Button loginMyPageCheck = findViewById(R.id.loginMyPageCheck);
        ImageView imgTv = findViewById(R.id.loginImg);

        //가져오기
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userServiceID = intent.getStringExtra("userServiceID");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {




                        String userID_result = jsonResponse.getString("userID");
                        String userPassword_result = jsonResponse.getString("userPassword");
                        String userName_result = jsonResponse.getString("userName");
                        String userMail_result = jsonResponse.getString("userMail");
                        String userBirthday_result = jsonResponse.getString("userBirthday");
                        String userBirthday2_result = jsonResponse.getString("userBirthday2");
                        String userBirthday3_result = jsonResponse.getString("userBirthday3");
                        String userGender_result = jsonResponse.getString("userGender");
                        String userServiceID_result = jsonResponse.getString("userServiceID");
                        String userPhoneNB_result = jsonResponse.getString("userPhoneNB");
                        String userAddress_result = jsonResponse.getString("userAddress");
                        Bitmap stringBitmap = stringToBitmap("img");



                        //각 칸에 각각의 데이터세팅
                        loginMyPageNameTv.setText(userName_result);
                        loginMyPageWhatTv.setText(userServiceID_result);
                        loginMyPageIDTv.setText(userID_result);
                        loginMyPageEmailTv.setText(userMail_result);
                        loginMyPagePWTv.setText(userPassword_result);
                        loginMyPageBirth1Tv.setText(userBirthday_result);
                        loginMyPageBirth2Tv.setText(userBirthday2_result);
                        loginMyPageBirth3Tv.setText(userBirthday3_result);
                        loginMyPageAddressTv.setText(userAddress_result);
                        loginMyPagePhoneNBTv.setText("0"+userPhoneNB_result);
                        loginMyPageGenderTv.setText(userGender_result);
                        imgTv.setImageBitmap(stringBitmap);



                    } else {
                        Toast.makeText(getApplicationContext(), "정보를 찾을수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        mypageList mypageList = new mypageList(userID, userServiceID, responseListener);
        RequestQueue queue = Volley.newRequestQueue(loginMyPage.this);
        queue.add(mypageList);





    }

    //비트맵을 스트링 형식으로 바꾸는 부분
    @RequiresApi(api = Build.VERSION_CODES.O)
    private Bitmap stringToBitmap(String imgString) {

        Bitmap bitmap = null;
        byte[] byteArray = new byte[0];
        byteArray = Base64.getDecoder().decode(imgString);

        ByteArrayInputStream stream = new ByteArrayInputStream(byteArray);
        bitmap = BitmapFactory.decodeStream(stream);
        return bitmap;
    }

}
