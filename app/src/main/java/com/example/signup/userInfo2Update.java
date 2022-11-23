package com.example.signup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class userInfo2Update extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/userInfo2Update.php";
    private Map<String, String> map;

    public userInfo2Update(String userID_db,String Ucareer_db,String info_ration_db,String Ulicense_db,String lovation_work_db,String uworkTime_db, Response.Listener<String> listener)
    {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID_db);
        map.put("Ucareer_db", Ucareer_db);
        map.put("info_ration_db", info_ration_db);
        map.put("Ulicense_db", Ulicense_db);
        map.put("lovation_work_db", lovation_work_db);
        map.put("uworkTime_db", uworkTime_db);

    }


    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }




}
