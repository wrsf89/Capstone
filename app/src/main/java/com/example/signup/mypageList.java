package com.example.signup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class mypageList extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/mypageList.php";
    private Map<String, String> map;

    public mypageList(String userID,String userServiceID, Response.Listener<String> listener)
    {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userServiceID", userServiceID);



    }


    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
