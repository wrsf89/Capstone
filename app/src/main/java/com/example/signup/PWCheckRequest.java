package com.example.signup;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PWCheckRequest extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/findpw.php";
    private Map<String, String> map;

    public PWCheckRequest(String userID,String username, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("username",username);

    }


    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
