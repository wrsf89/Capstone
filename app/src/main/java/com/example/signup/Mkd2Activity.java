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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mkd2Activity extends AppCompatActivity {

    private Button choiceBtn2 ,choiceBtn1 ,matching_cancel;
    private TextView cardName , cardDate , cardLocation, cardDetail ,receive_ID1;
    private static final String TAG_JSON = "result";
    private static final String json_userID = "receiveID";
    private static final String json_userName = "userName";
    private static final String json_time1 = "uworkTime";
    private static final String json_location_work1 = "lovation_work";
    private static final String json_ration1 = "info_ration";

    private static final String json_time2 = "time";
    private static final String json_location_work2 = "location_check";
    private static final String json_ration2 = "info_ration";
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkd2);

        ArrayList<mypageMatchDTO> mypageMatchList = new ArrayList<mypageMatchDTO>();
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userServiceID = intent.getStringExtra("userServiceID");

        choiceBtn2 = findViewById(R.id.choiceBtn2);
        choiceBtn1 = findViewById(R.id.choiceBtn1);
        matching_cancel = findViewById(R.id.matching_cancel);
        cardName = findViewById(R.id.cardName);
        cardDate = findViewById(R.id.cardDate);
        cardLocation = findViewById(R.id.cardLocation);
        cardDetail = findViewById(R.id.cardDetail);
        receive_ID1 = findViewById(R.id.receive_ID1);

        if (userServiceID.equals("환자")) {
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String result) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
                        mypageMatchList.clear();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject item = jsonArray.getJSONObject(i);

                            String userID = item.getString(json_userID);
                            String userName = item.getString(json_userName);
                            String time1 = item.getString(json_time1).substring(0,2);
                            String time2 = item.getString(json_time1).substring(2,4);
                            String time = time1+":"+time2;
                            String location = item.getString(json_location_work1);
                            String ration = item.getString(json_ration1);

                            mypageMatchDTO mypageMatchDTO = new mypageMatchDTO();
                            mypageMatchDTO.setUserID(userID);
                            mypageMatchDTO.setUserName(userName);
                            mypageMatchDTO.setTime(time);
                            mypageMatchDTO.setLocation_work(location);
                            mypageMatchDTO.setRation(ration);
                            mypageMatchList.add(mypageMatchDTO);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (mypageMatchList.size() > 0) {
                        cardName.setText("이름: " + mypageMatchList.get(count).getUserName());
                        cardDate.setText("시간: " + mypageMatchList.get(count).getTime());
                        cardLocation.setText("간병지: " + mypageMatchList.get(count).getLocation_work());
                        cardDetail.setText("가능등급: " + mypageMatchList.get(count).getRation());
                        receive_ID1.setText(mypageMatchList.get(count).getUserID());

                    } else {
                        Toast.makeText(getApplicationContext(), "매칭리스트가 없습니다.", Toast.LENGTH_LONG).show();
                    }
                }
            };

            mkd2MatchList mkd2MatchList = new mkd2MatchList(userID, responseListener);
            RequestQueue queue = Volley.newRequestQueue(Mkd2Activity.this);
            queue.add(mkd2MatchList);

        } else if (userServiceID.equals("간병인")) {
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String result) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
                        mypageMatchList.clear();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject item = jsonArray.getJSONObject(i);

                            String userID = item.getString(json_userID);
                            String userName = item.getString(json_userName);
                            String time1 = item.getString(json_time2).substring(0,2);
                            String time2 = item.getString(json_time2).substring(2,4);
                            String time = time1+":"+time2;
                            String location = item.getString(json_location_work2);
                            String ration = item.getString(json_ration2);

                            mypageMatchDTO mypageMatchDTO = new mypageMatchDTO();
                            mypageMatchDTO.setUserID(userID);
                            mypageMatchDTO.setUserName(userName);
                            mypageMatchDTO.setTime(time);
                            mypageMatchDTO.setLocation_work(location);
                            mypageMatchDTO.setRation(ration);
                            mypageMatchList.add(mypageMatchDTO);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (mypageMatchList.size() > 0) {
                        cardName.setText("이름: " + mypageMatchList.get(count).getUserName());
                        cardDate.setText("시간: " + mypageMatchList.get(count).getTime());
                        cardLocation.setText("간병지: " + mypageMatchList.get(count).getLocation_work());
                        cardDetail.setText("가능등급: " + mypageMatchList.get(count).getRation());
                        receive_ID1.setText(mypageMatchList.get(count).getUserID());

                    } else {
                        Toast.makeText(getApplicationContext(), "매칭리스트가 없습니다.", Toast.LENGTH_LONG).show();
                    }
                }
            };

            mkd2MatchList2 mkd2MatchList2 = new mkd2MatchList2(userID, responseListener);
            RequestQueue queue = Volley.newRequestQueue(Mkd2Activity.this);
            queue.add(mkd2MatchList2);

        }

        choiceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (userServiceID.equals("환자")) {
                    if (count == mypageMatchList.size()) {

                        Toast.makeText(getApplicationContext(), "마지막페이지입니다.", Toast.LENGTH_LONG).show();
                        count--;
                    } else {
                        cardName.setText("이름: " + mypageMatchList.get(count).getUserName());
                        cardDate.setText("시간: " + mypageMatchList.get(count).getTime());
                        cardLocation.setText("간병지: " + mypageMatchList.get(count).getLocation_work());
                        cardDetail.setText("가능등급: " + mypageMatchList.get(count).getRation());
                        receive_ID1.setText(mypageMatchList.get(count).getUserID());
                    }
                } else if (userServiceID.equals("간병인")) {
                    if (count == mypageMatchList.size()) {

                        Toast.makeText(getApplicationContext(), "마지막페이지입니다.", Toast.LENGTH_LONG).show();
                        count--;
                    } else {
                        cardName.setText("이름: " + mypageMatchList.get(count).getUserName());
                        cardDate.setText("시간: " + mypageMatchList.get(count).getTime());
                        cardLocation.setText("간병지: " + mypageMatchList.get(count).getLocation_work());
                        cardDetail.setText("환자등급: " + mypageMatchList.get(count).getRation());
                        receive_ID1.setText(mypageMatchList.get(count).getUserID());
                    }
                }
            }
        });

        choiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                if (userServiceID.equals("환자")) {
                    if (count >= 0) {
                        cardName.setText("이름: " + mypageMatchList.get(count).getUserName());
                        cardDate.setText("시간: " + mypageMatchList.get(count).getTime());
                        cardLocation.setText("간병지: " + mypageMatchList.get(count).getLocation_work());
                        cardDetail.setText("가능등급: " + mypageMatchList.get(count).getRation());
                        receive_ID1.setText(mypageMatchList.get(count).getUserID());
                    } else {
                        Toast.makeText(getApplicationContext(), " 처음페이지입니다.", Toast.LENGTH_LONG).show();
                        count = 0;
                    }
                } else if (userServiceID.equals("간병인")) {
                    if (count >= 0) {
                        cardName.setText("이름: " + mypageMatchList.get(count).getUserName());
                        cardDate.setText("시간: " + mypageMatchList.get(count).getTime());
                        cardLocation.setText("간병지: " + mypageMatchList.get(count).getLocation_work());
                        cardDetail.setText("환자등급: " + mypageMatchList.get(count).getRation());
                        receive_ID1.setText(mypageMatchList.get(count).getUserID());
                    } else {
                        Toast.makeText(getApplicationContext(), " 처음페이지입니다.", Toast.LENGTH_LONG).show();
                        count = 0;
                    }

                }
            }
        });


        matching_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendID = userID;
                String receiveID = receive_ID1.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "매칭이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Mkd2Activity.this, Mypage.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userServiceID", userServiceID);
                                Mkd2Activity.this.startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "매칭취소가 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                matchDelete matchDelete = new matchDelete(sendID, receiveID,  responseListener);
                RequestQueue queue = Volley.newRequestQueue(Mkd2Activity.this);
                queue.add(matchDelete);



            }
        });
    }
}