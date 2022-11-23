package com.example.signup;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class mypageMatchList extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/mypageMatchList.php";
    private Map<String, String> map;

    public mypageMatchList(String userID, Response.Listener<String> listener)
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
