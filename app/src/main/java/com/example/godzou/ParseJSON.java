package com.example.godzou;

/**
 * Created by renyangqi on 2018/2/17.
 */

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJSON {
    public static void parseJSONWithJSONObject(final String jsonData){
        try {

            JSONArray jsonArray=new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id =jsonObject.getString("id");
                String name =jsonObject.getString("name");
                String version =jsonObject.getString("version");

                Log.d("MainActivity","id is"+id);
                Log.d("MainActivity","name is"+name);
                Log.d("MainActivity","version is"+version);


            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

