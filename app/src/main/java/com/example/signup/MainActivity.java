package com.example.signup;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private Button signupbutton, signEmailCheck, signIDCheck;
    private String gender_result, serviceId_result;
    private AlertDialog.Builder dialog;
    private boolean validate;
    private Button signImageBtn;
    private ImageView imageView;
    private static final int REQUEST_CODE = 0;
    private Bitmap img;
    private String image;
    private String temp="";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //이미지 비트맵으로 변환

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    img = BitmapFactory.decodeStream(in);
                    in.close();
                    img = resize(img);
                    imageView.setImageBitmap(img);
                } catch (Exception e) {
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signupbutton = findViewById(R.id.signupbutton);
        signEmailCheck = findViewById(R.id.signEmailCheck);
        signIDCheck = findViewById(R.id.signIDCheck);
        signImageBtn = findViewById(R.id.signImageBtn);


        final EditText signName = findViewById(R.id.signName);
        final EditText signmail = findViewById(R.id.signmail);
        final EditText signID = findViewById(R.id.signID);
        final EditText signBirth = findViewById(R.id.signBirth);//i
        final EditText signBirth2 = findViewById(R.id.signBirth2);//i
        final EditText signBirth3 = findViewById(R.id.signBirth3);//i
        final EditText signPW = findViewById(R.id.signPW);
        final RadioGroup gender = findViewById(R.id.gender);
        final RadioGroup serviceId = findViewById(R.id.serviceId);
        final RadioButton male = findViewById(R.id.male); // 남자
        final RadioButton female = findViewById(R.id.female); //여자
        final RadioButton patient = findViewById(R.id.patient); //환자
        final RadioButton caregiver = findViewById(R.id.caregiver); //간병인
        final EditText phoneNb = findViewById(R.id.phoneNb);//i
        final EditText signAddress = findViewById(R.id.signAddress);

        imageView = findViewById(R.id.signImage);


        //이미지 뷰를 누르면 갤러리가 나오는 부분
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });



        //성별 라디오 버튼 상태 값 담기
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.male) {
                    gender_result = (male.getText().toString());
                } else if (i == R.id.female) {
                    gender_result = (female.getText().toString());
                }
            }
        });
        //간병인 인지 환자인지 버튼 값 담기
        serviceId.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.patient) {
                    serviceId_result =(patient.getText().toString());
                } else if (i == R.id.caregiver) {
                    serviceId_result = (caregiver.getText().toString());
                }
            }
        });



        //회원가입 버튼
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //유효성 체크
                if (signName.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    signName.requestFocus();
                } else if (phoneNb.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "전화번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    phoneNb.requestFocus();
                } else if (signAddress.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "주소를 입력하세요!", Toast.LENGTH_SHORT).show();
                    signAddress.requestFocus();
                } else if (signmail.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "메일을 입력하세요!", Toast.LENGTH_SHORT).show();
                    signmail.requestFocus();
                } else if (signID.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력하세요!", Toast.LENGTH_SHORT).show();
                    signID.requestFocus();
                } else if (signBirth.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "년도를 입력하세요!", Toast.LENGTH_SHORT).show();
                    signBirth.requestFocus();
                } else if (signBirth2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "월을 입력하세요!", Toast.LENGTH_SHORT).show();
                    signBirth2.requestFocus();
                } else if (signBirth3.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "일을 입력하세요!", Toast.LENGTH_SHORT).show();
                    signBirth3.requestFocus();
                } else {
                    //값을 텍스트로 변환후 함수 선언
                    String userID = signID.getText().toString();
                    String userName = signName.getText().toString();
                    String userPassword = signPW.getText().toString();
                    String userMail = signmail.getText().toString();
                    int userBirthday = Integer.parseInt(signBirth.getText().toString());
                    int userBirthday2 = Integer.parseInt(signBirth2.getText().toString());
                    int userBirthday3 = Integer.parseInt(signBirth3.getText().toString());
                    String userGender = gender_result;
                    String userServiceID = serviceId_result;
                    int userPhoneNB = Integer.parseInt(phoneNb.getText().toString());
                    String userAddress= signAddress.getText().toString();

                    imgCompress(img);

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success) {
                                    Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, activity_mkd3.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "회원등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };



                    RegisterRequest registerRequest = new RegisterRequest(userID, userName, userPassword, userMail, userBirthday, userBirthday2, userBirthday3, userPhoneNB, userAddress, userGender, userServiceID, temp, responseListener);
                    Log.v("image2",temp);
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    queue.add(registerRequest);


                }


            }});

        signIDCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = signID.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디 입니다.")
                                        .setPositiveButton("확인", null);
                                dialog.show();
                                signID.setEnabled(false);
                                validate = true;
                                signID.setBackgroundColor(getResources().getColor(R.color.colorGrqy));
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                dialog = builder.setMessage("사용할 수 없는 아이디 입니다.")
                                        .setNegativeButton("확인", null);

                                dialog.show();
                            }
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }

                };
                IDCheckRequest iDCheckRequest = new IDCheckRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(iDCheckRequest);
            }
        });


    }

    //비트맵으로 인코딩
    public void imgCompress(Bitmap img){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        img.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes = baos.toByteArray();
        image = Base64.encodeToString(bytes,Base64.DEFAULT);

        try {
            temp = "&imagedevice="+ URLEncoder.encode(image,"utf-8");
            Log.v("imagedevice",temp);
        }catch(Exception e){
            Log.e("exception",e.toString());
        }

    }

    //비트맵으로 변환한 이미지 사이즈 조절
    private Bitmap resize(Bitmap img){
        Configuration config=getResources().getConfiguration();
        if(config.smallestScreenWidthDp>=800)
            img = Bitmap.createScaledBitmap(img, 400, 240, true);
        else if(config.smallestScreenWidthDp>=600)
            img = Bitmap.createScaledBitmap(img, 300, 180, true);
        else if(config.smallestScreenWidthDp>=400)
            img = Bitmap.createScaledBitmap(img, 200, 120, true);
        else if(config.smallestScreenWidthDp>=360)
            img = Bitmap.createScaledBitmap(img, 180, 108, true);
        else
            img = Bitmap.createScaledBitmap(img, 160, 96, true);
        return img;
    }
}