package com.example.signup;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class matchupdate extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/matchupdate.php";
    private Map<String, String> map;

    public matchupdate(String sendID, String receiveID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("sendID",sendID);
        map.put("receiveID", receiveID);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }


}
