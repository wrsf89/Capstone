
package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class user_info2 extends AppCompatActivity {

    private EditText career, workTime, license;
    private RadioGroup location_working, info2_rating;
    private RadioButton home_work, hospital_work, info2_1rating, info2_2rating, info2_3rating, info2_4rating, info2_5rating, info2_6rating;
    private Button checkButton3 , checkButton2;
    private String signID, location_working_result, info2_rating_result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);

        //전달할 데이터 받을 intent 선언
        Intent intent=  getIntent();

        career = findViewById(R.id.career);
        workTime = findViewById(R.id.workTime);
        license = findViewById(R.id.license);
        location_working = findViewById(R.id.location_working);
        home_work = findViewById(R.id.home_work);
        hospital_work = findViewById(R.id.hospital_work);
        info2_rating = findViewById(R.id.info2_rating);
        info2_1rating = findViewById(R.id.info2_1rating);
        info2_2rating = findViewById(R.id.info2_2rating);
        info2_3rating = findViewById(R.id.info2_3rating);
        info2_4rating = findViewById(R.id.info2_4rating);
        info2_5rating = findViewById(R.id.info2_5rating);
        info2_6rating = findViewById(R.id.info2_6rating);
        checkButton3 = findViewById(R.id.checkButton3);
        checkButton2 = findViewById(R.id.checkButton2);
        //String 형식으로 전달받을 signID 저장
        signID = intent.getStringExtra("signID");

        location_working.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.home_work){
                    location_working_result = String.valueOf(home_work.getText());
                }else if(i == R.id.hospital_work){
                    location_working_result = String.valueOf(hospital_work.getText());
                }
            }
        });

        info2_rating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.info2_1rating){
                    info2_rating_result = String.valueOf(info2_1rating.getText());
                }else if(i == R.id.info2_2rating){
                   info2_rating_result = String.valueOf(info2_2rating.getText());
                }else if(i == R.id.info2_3rating){
                    info2_rating_result = String.valueOf(info2_3rating.getText());
                }
                else if(i == R.id.info2_4rating){
                    info2_rating_result = String.valueOf(info2_4rating.getText());
                }
                else if(i == R.id.info2_5rating){
                    info2_rating_result = String.valueOf(info2_5rating.getText());
                }
                else if(i == R.id.info2_6rating){
                    info2_rating_result = String.valueOf(info2_6rating.getText());
                }
            }
        });

        checkButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ucareer = career.getText().toString();
                String info_ration = info2_rating_result;
                String Ulicense = license.getText().toString();
                String lovation_work = location_working_result;
                String uworkTime = workTime.getText().toString();
                String userID = intent.getStringExtra("userID");
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                String userServiceID = intent.getStringExtra("userServiceID");
                                Toast.makeText(getApplicationContext(), "간병인 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(user_info2.this, MainPage1.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userServiceID", userServiceID);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "간병인 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                Info2Request info2Request = new Info2Request(Ucareer, info_ration, Ulicense, lovation_work, uworkTime, userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(user_info2.this);
                queue.add(info2Request);

            }
        });

        checkButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ucareer_db = career.getText().toString();
                String info_ration_db = info2_rating_result;
                String Ulicense_db = license.getText().toString();
                String lovation_work_db = location_working_result;
                String uworkTime_db = workTime.getText().toString();
                String userID_db = intent.getStringExtra("userID");

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String userServiceID = intent.getStringExtra("userServiceID");
                                Toast.makeText(getApplicationContext(), "정보가 수정되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(user_info2.this, MainPage1.class);
                                intent.putExtra("userID", userID_db);
                                intent.putExtra("userServiceID", userServiceID);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "간병인 수정 에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                userInfo2Update userInfo2Update = new userInfo2Update(userID_db, Ucareer_db, info_ration_db, Ulicense_db, lovation_work_db, uworkTime_db, responseListener);
                RequestQueue queue = Volley.newRequestQueue(user_info2.this);
                queue.add(userInfo2Update);

            }
        });
    }

}