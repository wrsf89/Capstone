package com.example.signup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class
 matchingList extends StringRequest {
    // 서버와 연동하기 위한 변수 설정
    final static private String URL = "http://favor531.ivyro.net/matchingList.php";
    private Map<String, String> map;

    public matchingList(String gender,String location,String location_work,String checkServiceID,Response.Listener<String> listener)
    {
        //post 형태로 서버에 데이터 전달
        super(Request.Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userGender",gender);
        map.put("userAddress", location);
        map.put("lovation_work", location_work);
        map.put("userServiceID",checkServiceID);
    }

    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
