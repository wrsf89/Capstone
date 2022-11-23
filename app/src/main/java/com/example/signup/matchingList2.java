package com.example.signup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class matchingList2 extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/matchingList2.php";
    private Map<String, String> map;

    public matchingList2(String gender, String location, String location_work, String checkServiceID, Response.Listener<String> listener)
    {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userGender",gender);
        map.put("userAddress", location);
        map.put("location_work", location_work);
        map.put("userServiceID",checkServiceID);
    }

    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
