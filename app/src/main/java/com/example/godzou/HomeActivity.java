package com.example.godzou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {
    ImageView iv_lkjs, iv_dsgn, iv_wdsz, iv_znjs;
    private static final int msgKey1 = 1;
    Switch sw_kaiguan;
    TextView current_temp;
    TextView current_weight;
    private String URL="http://10.0.2.2/get_data.json";
    private String responseData="";
    private String  threadNowTemp;
    private String  threadNowWeight;
    private String name_data1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent switch_intent=getIntent();

        String switch_data=switch_intent.getStringExtra("siwtchSTATE");
        name_data1=switch_intent.getStringExtra("userNAME");
        String mytemp=switch_intent.getStringExtra("NowTemp");
        String myweight=switch_intent.getStringExtra("NowWeight");
        Log.i("传递过来的开关状态", switch_data);
        Log.i("传递过来的名字", name_data1);
        Log.i("传递过来的温度", mytemp);
        Log.i("传递过来的水量", myweight);
        myweight=myweight+"%";
        iv_lkjs = (ImageView) findViewById(R.id.iv_lkjs);
        iv_dsgn = (ImageView) findViewById(R.id.iv_dsgn);
        iv_wdsz = (ImageView) findViewById(R.id.iv_wdsz);
        iv_znjs = (ImageView) findViewById(R.id.iv_znjs);
        sw_kaiguan = (Switch) findViewById(R.id.sw_kaiguan);
        current_temp=(TextView)findViewById(R.id.temperature);
        current_temp.setText(mytemp);
        current_weight=(TextView)findViewById(R.id.weightx);
        current_weight.setText(myweight);


        // new TimeThread().start();
        if(switch_data.equals("yes")){
            sw_kaiguan.setChecked(true);
        }else {
            sw_kaiguan.setChecked(false);
        }

        iv_lkjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(HomeActivity.this, HomeActivity.class);//intent实现链接（下同）
                startActivity(intent);*/
            }

        });

        iv_dsgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        int GetMysqlYear = SQLhelper.onQueryYear(name_data1);

                        int GetMysqlMonth = SQLhelper.onQueryMonth(name_data1);
                        int GetMysqlDay = SQLhelper.onQueryDay(name_data1);
                        int GetMysqlHour = SQLhelper.onQueryHour(name_data1);
                        int GetMysqlMinute = SQLhelper.onQueryMinute(name_data1);

                        Intent intent = new Intent(HomeActivity.this,SetTime.class);

                        intent.putExtra("MysqlYear",""+GetMysqlYear);
                        intent.putExtra("MysqlMonth",""+GetMysqlMonth);
                        intent.putExtra("MysqlDay",""+GetMysqlDay);
                        intent.putExtra("MysqlHour",""+GetMysqlHour);
                        intent.putExtra("MysqlMinute",""+GetMysqlMinute);
                        intent.putExtra("user_name",name_data1);
                        Log.d("返回的年",GetMysqlYear+"");
                        Log.d("返回的月",GetMysqlMonth+"");
                        Log.d("返回的日",GetMysqlDay+"");
                        Log.d("返回的时",GetMysqlHour+"");
                        Log.d("返回的分",GetMysqlMinute+"");
                        startActivity(intent);
                    }
                }).start();
            }

        });
        iv_wdsz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String Get = SQLhelper.onQueryTemperature(name_data1);
                        Log.d("返回的温度",Get);
                        Intent intent = new Intent(HomeActivity.this,SetTemperature.class);
                        intent.putExtra("PresetTemperature",Get);
                        intent.putExtra("user_name",name_data1);
                        startActivity(intent);
                    }
                }).start();

            }

        });
        iv_znjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);

            }

        });
        sw_kaiguan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            /*SetState kaiGuan=new SetState();
                            kaiGuan.SetYinShuiJiKaiGuan("kai");
                            Gson gson=new Gson();
                            String json=gson.toJson(kaiGuan);
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
                                   // ParseJSON.parseJSONWithJSONObject(responseData);
                                    Log.d("MainActivity",responseData);
                                    //showResponse(responseData);
                                }
                            }

                            );*/
                            SQLhelper.onUpdateSwitchTo1(name_data1);
                            Log.d("饮水机开关更新","使打开");







                        }
                    }).start();
                }
                else {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                           /* SetState kaiGuan=new SetState();
                            kaiGuan.SetYinShuiJiKaiGuan("kai");
                            Gson gson=new Gson();
                            String json=gson.toJson(kaiGuan);
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

                                    //ParseJSON.parseJSONWithJSONObject(responseData);
                                    //showResponse(responseData);
                                }
                            });*/



                            SQLhelper.onUpdateSwitchTo0(name_data1);
                            Log.d("饮水机开关更新","使打开");
                            Log.d("饮水机开关","关闭");
                        }
                    }

                    ).start();

                }
            }
        });
        new TimeThread().start();
    }
    /*时间模块*/

     public class TimeThread extends  Thread{
          @Override
          public void run() {
              super.run();
              do{
                  try {
                      Thread.sleep(10000);
                      threadNowTemp=SQLhelper.onQueryCurrentTemp(name_data1);
                      threadNowWeight=SQLhelper.onQueryCurrentWeight(name_data1)+"%";
                      Message msg = new Message();
                      msg.what = msgKey1;
                      mHandler.sendMessage(msg);

                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }while (true);
          }
      }

      private Handler mHandler = new Handler()
      {
          @Override
          public void handleMessage(Message msg) {
              super.handleMessage(msg);
              switch (msg.what){
                  case msgKey1:
                      //long time = System.currentTimeMillis();
                     // Date date = new Date(time);
                     // SimpleDateFormat format = new SimpleDateFormat("现在是"+"HH时mm分ss秒");
                  //    tv_time.setText(format.format(date));
                      current_temp.setText(threadNowTemp);
                      current_weight.setText(threadNowWeight);
                      break;
                  default:
                      break;
              }
          }
      };
    //菜单
    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main ,menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.setting_item:
                Toast.makeText(this, "暂未开通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_item:
            {
                //Toast.makeText(this, "exit soon", Toast.LENGTH_SHORT).show();
                finish();
            }
            break;
            default:

        }
        return true;
    }
    public void showResponse(final String responseData){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(HomeActivity.this, responseData, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
