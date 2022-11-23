package com.example.signup;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Info2Request extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/Info2Request.php";
    private Map<String, String> map;

    public Info2Request(String Ucareer, String info_ration, String Ulicense, String lovation_work, String uworkTime, String userID, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("Ucareer",Ucareer);
        map.put("info_ration", info_ration);
        map.put("Ulicense", Ulicense);
        map.put("lovation_work", lovation_work);
        map.put("uworkTime", uworkTime);
        map.put("userID", userID);





    }


    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
