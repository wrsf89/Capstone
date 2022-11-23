package com.example.signup;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class idfindRequest extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/findid.php";
    private Map<String, String> map;

    public idfindRequest(String usermail,String username ,Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("usermail",usermail);
        map.put("username",username);


    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}
