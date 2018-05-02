package com.example.godzou;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class SetTemperature extends AppCompatActivity {
    private String URL="http://10.0.2.2/get_data.json";
    private String responseData="";

    private TextView nowTemperatureIs;//现在温度是
    private EditText setTempetature;
    private Button SetTemp;//开始加热
    private Button HeatOrCancle;//停止加热
    private String getStringFromEditText;//获取输入的温度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_temperature);
        setTitle("温度设置");

        Intent PresetTemperatureIntent=getIntent();

        String PresetTemperatureFromHomeActivity=PresetTemperatureIntent.getStringExtra("PresetTemperature");
        final String UserNameFromHomeActivity=PresetTemperatureIntent.getStringExtra("user_name");
        Log.d("从home活动返回的温度为",PresetTemperatureFromHomeActivity);
        Log.d("从home活动返回的名字为",UserNameFromHomeActivity);

        nowTemperatureIs=(TextView)findViewById(R.id.nowTemperature);
        setTempetature=(EditText)findViewById(R.id.setTemperature);
        SetTemp=(Button)findViewById(R.id.startHeat);
        HeatOrCancle=(Button)findViewById(R.id.stopHeat);

        if(!PresetTemperatureFromHomeActivity.equals("什么都没有")) {
            setTempetature.setText(PresetTemperatureFromHomeActivity);
        }
        else {
            setTempetature.setText("请输入预设温度");
        }

        SetTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        /*getStringFromEditText=setTempetature.getText().toString();
                        SetState setState=new SetState();
                        setState.SetTemperature(getStringFromEditText);
                        setState.StartHeating(true);
                        Gson gson=new Gson();
                        final String json=gson.toJson(setState);
                         //建立一个开关对象 设置信息
                        HttpUtil.sendOkHttpRequest(json,URL,new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if (!response.isSuccessful())
                                    throw new IOException("Unexpected code " + "出错了");
                                //服务器返回的信息在responseData
                                responseData=response.body().string();
                                ParseJSON.parseJSONWithJSONObject(responseData);
                                showResponse(json);
                                //showResponse(responseData);
                            }
                        });*/
                        getStringFromEditText=setTempetature.getText().toString();
                        SQLhelper.onUpdatePresetTemperature(getStringFromEditText,UserNameFromHomeActivity);


                    }
                }).start();
            }
        });

        HeatOrCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       /* getStringFromEditText=setTempetature.getText().toString();
                        SetState setState=new SetState();
                        setState.SetTemperature(getStringFromEditText);
                        setState.StartHeating(false);
                        Gson gson=new Gson();
                        final String json=gson.toJson(setState);
                        //建立一个开关对象 设置信息
                        HttpUtil.sendOkHttpRequest(json,URL,new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if (!response.isSuccessful())
                                    throw new IOException("Unexpected code " + "出错了");
                                //服务器返回的信息在responseData
                                responseData=response.body().string();
                                ParseJSON.parseJSONWithJSONObject(responseData);
                                showResponse(json);
                                //  showResponse(responseData);
                            }
                        });
                    */}








                }).start();
            }
        });


    }

    public void showResponse(final String responseData){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SetTemperature.this, responseData, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
