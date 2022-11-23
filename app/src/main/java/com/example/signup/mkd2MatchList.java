package com.example.signup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class mkd2MatchList extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/mkd2MatchList.php";
    private Map<String, String> map;

    public mkd2MatchList(String userID, Response.Listener<String> listener)
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
