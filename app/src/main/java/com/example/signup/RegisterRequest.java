package com.example.signup;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String userID, String userName, String userPassword, String userMail, int userBirthday, int userBirthday2, int userBirthday3, int userPhoneNB, String userAddress, String userGender, String userServiceID, String temp, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);

        map.put("userName", userName);
        map.put("userPassword", userPassword);
        map.put("userMail", userMail);
        map.put("userBirthday", userBirthday + "");
        map.put("userBirthday2", userBirthday2 + "");
        map.put("userBirthday3", userBirthday3 + "");
        map.put("userGender", userGender);
        map.put("userServiceID", userServiceID);
        map.put("userPhoneNB", userPhoneNB +"");
        map.put("userAddress", userAddress);
        map.put("img", temp);



    }


    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
