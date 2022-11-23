package com.example.signup;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class IDCheckRequest extends StringRequest {

    //서버와 안드로이드 스튜디오가 연결할 수 있는 파일이 담긴 url선언
    final static private String URL = "http://favor531.ivyro.net/idCheck.php";
    private Map<String, String> map;

    public IDCheckRequest(String userID, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);




    }


    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
