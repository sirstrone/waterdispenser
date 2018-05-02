package com.example.godzou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import com.gc.materialdesign.views.ButtonRectangle;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginActivity extends AppCompatActivity {

     private String GetLoginUserName;
     private String GetLoginPassWord;
     private String CheckSwitch;
     private EditText username;
     private EditText password;

    private static final String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
    private static final String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
    private static final String USER = "mark";
    private static final String PASSWORD = "19980915ryq!";
    public Connection conn;

    public String JudgePassWord="none";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new Thread(new Runnable() {
            @Override
            public void run() {
                conn = UTIL.openConnection(URL, USER, PASSWORD);
               if(conn!=null) {
                    Log.d("LoginActivity", "连接数据库成功");
                }else {
                    Log.d("LoginActivity", "连接数据库失败");
                }
            }
        }).start();

        ButtonRectangle bt_login = (ButtonRectangle) findViewById(R.id.bt_login);
        ButtonRectangle bt_sign_up_for_login = (ButtonRectangle) findViewById(R.id.bt_sign_up_for_login);
        username=(EditText)findViewById(R.id.et_user1);
        password=(EditText)findViewById(R.id.et_password1);



        bt_sign_up_for_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Sign_upActivity.class);//intent实现链接
                startActivity(intent);
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetLoginUserName=username.getText().toString();
                GetLoginPassWord=password.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                    boolean res= SQLhelper.onCheckPassWordAndUserName(GetLoginUserName,GetLoginPassWord);
                    String now_temp=SQLhelper.onQueryCurrentTemp(GetLoginUserName);
                    String now_weight=SQLhelper.onQueryCurrentWeight(GetLoginUserName);
                        Log.i("饮水机温度", now_temp);
                        Log.i("饮水机水量", now_weight);

                    if(res){
                        Log.i("登陆活动", "密码和用户名匹配");
                        String switch_state= SQLhelper.onCheckSwitch(GetLoginUserName);
                        if(switch_state.equals("yes")){
                            Log.i("饮水机状态", "开");
                        }else {
                            Log.i("饮水机状态", "关");
                        }
                        Intent intent=new Intent(LoginActivity.this,TabhostActivity.class);
                        intent.putExtra("NOWTEMPE",now_temp);
                        intent.putExtra("NOWWEIGHT",now_weight);
                        intent.putExtra("switch_data",switch_state);
                        intent.putExtra("LoginName",GetLoginUserName);
                        startActivity(intent);
                    }else {
                        Log.i("登陆活动", "密码和用户名不匹配");


                    }
                    }
                }).start();

               /* Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);*/

            }
        });

    }
}
