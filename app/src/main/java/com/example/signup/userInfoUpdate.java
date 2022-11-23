package com.example.signup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class userInfoUpdate extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/userInfoUpdate.php";
    private Map<String, String> map;

    public userInfoUpdate(String userID_db,String time_db,String diseaseName_db,String location_check_db,String dementia_check_db,String info_rating_db,String note_db, Response.Listener<String> listener)
    {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID_db);
        map.put("diseaseName", diseaseName_db);
        map.put("location_check", location_check_db);
        map.put("dementia_check", dementia_check_db);
        map.put("info_ration", info_rating_db);
        map.put("note", note_db);
        map.put("time", time_db);


    }


    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
