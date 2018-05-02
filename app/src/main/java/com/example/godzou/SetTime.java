package com.example.godzou;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import okhttp3.Call;
import okhttp3.Response;

public class SetTime extends AppCompatActivity {
    // 定义5个记录当前时间的变量
   /*private String URL="http://10.0.2.2/get_data.json";
    private String responseData="";*/
    //private static final int msgKey1 = 1;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    private int MysqlYear1;
    private int MysqlMonth1;
    private int MysqlDay1;
    private int MysqlHour1;
    private int MysqlMinute1;
    TextView show;
  /*  private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case msgKey1:
                    long time = System.currentTimeMillis();
                    Date date = new Date(time);
                    SimpleDateFormat format = new SimpleDateFormat("现在是"+"YY年MM月dd日HH时mm分");
                    show.setText(format.format(date));
                    break;
                default:
                    break;
            }
        }
    };*/
    Button ok;
    Button cancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        setTitle("时间设置");

        Log.d("SetTime活动里的返回的year", "MLGBD");
        Intent intent = getIntent();

        MysqlYear1 = Integer.valueOf(intent.getStringExtra("MysqlYear"));
        MysqlMonth1 = Integer.valueOf(intent.getStringExtra("MysqlMonth"));
        MysqlDay1 = Integer.valueOf(intent.getStringExtra("MysqlDay"));
        MysqlHour1 = Integer.valueOf(intent.getStringExtra("MysqlHour"));
        MysqlMinute1 = Integer.valueOf(intent.getStringExtra("MysqlMinute"));
        final String name = intent.getStringExtra("user_name");

       /* Log.i("蛋疼1", MysqlYear1 + "");
        Log.i("蛋疼2", MysqlMonth1 + "");
        Log.i("蛋疼3", MysqlDay1 + "");
        Log.i("蛋疼4", MysqlHour1 + "");
        Log.i("蛋疼5", MysqlMinute1 + "");*/

        show = (TextView) findViewById(R.id.show);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        ok = (Button) findViewById(R.id.ok);
        cancle = (Button) findViewById(R.id.cancle);


       // new TimeThread().start();
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        show.setText("现在是"+(month+1)+"月"+day+"日"+"");
        //   Log.d("SetTime活动里的返回的year",x);
        //   Log.d("SetTime活动里的返回的year","  v  "+MysqlYear1);
        if(MysqlYear1!=0&&MysqlMonth1!=0&&MysqlDay1!=0)
        {
        datePicker.init(MysqlYear1, MysqlMonth1-1, MysqlDay1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                SetTime.this.year = year;
                SetTime.this.month = monthOfYear + 1;
                SetTime.this.day = dayOfMonth;
                //showDate(year,month,day,hour,minute);
             /*   Toast.makeText(SetTime.this, "您选择的日期：" + year + "年"
                        + month + "月" + day + "日", Toast.LENGTH_SHORT).show();*/


            }
        });
    }else {
            datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    SetTime.this.year = year;
                    SetTime.this.month = monthOfYear + 1;
                    SetTime.this.day = dayOfMonth;
                    //showDate(year,month,day,hour,minute);
                   /* Toast.makeText(SetTime.this, "您选择的日期：" + year + "年"
                            + month + "月" + day + "日", Toast.LENGTH_SHORT).show();*/


                }
            });
        }
        if(MysqlHour1!=0){
            timePicker.setCurrentHour(MysqlHour1);
            timePicker.setCurrentMinute(MysqlMinute1);
        }
        else {
            timePicker.setCurrentHour(hour);
            timePicker.setCurrentMinute(minute);
        }
        timePicker.setCurrentHour(MysqlHour1);
        timePicker.setCurrentMinute(MysqlMinute1);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                    SetTime.this.hour = hourOfDay;
                    SetTime.this.minute = minute;
                    // 显示当前日期、时间
                    //showDate(year, month, day, hour, minute);
                    /*Toast.makeText(SetTime.this,"您选择的时间："+hourOfDay+"时  "
                            +minute+"分", Toast.LENGTH_SHORT).show();
*/


            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                      /*  String date=""+year+":"+month+":"+day;
                        String time=""+hour+":"+minute;
                        SetState setState=new SetState();
                        setState.SetDate(date);
                        setState.SetTime(time);
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


                       String sendyear=""+ datePicker.getYear();
                       String sendmonth=1+ datePicker.getMonth()+"";
                       String sendday=""+datePicker.getDayOfMonth();

                        String sendhour=   ""+ timePicker.getCurrentHour();
                        String sendminute= ""+timePicker.getCurrentMinute();

                        SQLhelper.onUpdatedate(sendyear,sendmonth,sendday,sendhour,sendminute,name);
                        showTimeOK();
                       /* Log.i("年", sendyear);
                        Log.i("月", sendmonth);
                        Log.i("日", sendday);
                        Log.i("时", sendhour);
                        Log.i("分", sendminute);*/

                    }
                }).start();
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                    /*    SetState setState=new SetState();
                        setState.SetDate(null);
                        setState.SetTime(null);
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
                        SQLhelper.onUpdatedateToNull(name);
                        showTimeCancle();
                    }
                }).start();
            }
        });
    }

   /* private void showDate(int year,int month,int day,int hour,int minute){

        String string="您选择的日期是和时间为:"+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分";
        show.setText(string);
    }*/

/*
    public class TimeThread extends  Thread{
        @Override
        public void run() {
            super.run();
            do{
                try {
                    Thread.sleep(1);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (true);
        }
    }
*/
    public void showResponse(final String responseData){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SetTime.this, responseData, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showTimeOK(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SetTime.this, "时间设置成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showTimeCancle(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SetTime.this, "取消时间成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
