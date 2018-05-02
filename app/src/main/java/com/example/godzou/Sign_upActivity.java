package com.example.godzou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
import com.gc.materialdesign.views.ButtonRectangle;
public class Sign_upActivity extends AppCompatActivity {
    private Spinner sp_city;
    private Spinner sp_school;
    private EditText sign_up_user_name ;//注册名
    private EditText sign_up_user_password  ;//密码
    private EditText sign_up_user_password_check  ;//第二次输入密码
    private EditText ZenMeChengHu ;//我们怎么称呼您
    private EditText dormitory_number;//宿舍号

    private ButtonRectangle sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign_up_user_name=(EditText)findViewById(R.id.et_user);
        sign_up_user_password=(EditText)findViewById(R.id.et_password);
        sign_up_user_password_check=(EditText)findViewById(R.id.check_password);
        ZenMeChengHu=(EditText)findViewById(R.id.et_name);
        dormitory_number=(EditText)findViewById(R.id.et_room_id);

        sign_up=(ButtonRectangle)findViewById(R.id.bt_sign_up);

        sp_city =(Spinner)findViewById(R.id.sp_city);
        sp_school =(Spinner) findViewById(R.id.sp_school);

        List<String> city=new ArrayList<String>();
        city.add("昆明");

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String getSignUpUserName=sign_up_user_name.getText().toString();//读取输入的用户名
                final String getSignUpUserPassWord=sign_up_user_password.getText().toString();
                final String getSignUpUserPasswordCheck=sign_up_user_password_check.getText().toString();
                String getZenMeChengHu=ZenMeChengHu.getText().toString();
                final String getDormitoryNumber=dormitory_number.getText().toString();//读取宿舍号

                Log.d("Sign_upActivity",getSignUpUserName );;
                Log.d("Sign_upActivity",getSignUpUserPassWord );;
                Log.d("Sign_upActivity",getSignUpUserPasswordCheck);;
                Log.d("Sign_upActivity",getZenMeChengHu);;
                Log.d("Sign_upActivity",getDormitoryNumber );;


               /* if(!getSignUpUserPassWord.equals(getSignUpUserPasswordCheck))
                {
                    Toast.makeText(Sign_upActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
                else {*/
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(getSignUpUserPassWord.equals(getSignUpUserPasswordCheck)){
                            if(SQLhelper.onQuerSignUser_name(getSignUpUserName).equals("")){

                                SQLhelper.onInsertSignUp(getSignUpUserName,getSignUpUserPassWord,getDormitoryNumber );
                                showSignUpSuccess();
                                Intent intent = new Intent(Sign_upActivity.this, LoginActivity.class);//intent实现链接
                                startActivity(intent);
                            }
                            else if(!SQLhelper.onQuerSignUser_name(getSignUpUserName).equals("")) {
                                showSignUpFailure();
                            }
                        }
                        else {
                            showSignUpPassWordNoRepeat();
                        }


                       // SQLhelper.onInsertSignUp(getSignUpUserName,getSignUpUserPassWord,getDormitoryNumber );

                    }
                }).start();

                /*}*/



              /*
              Intent intent = new Intent(Sign_upActivity.this, LoginActivity.class);//intent实现链接
                startActivity(intent);
               */



            }
        });
    }
    public void showSignUpSuccess(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Sign_upActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showSignUpFailure(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Sign_upActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showSignUpPassWordNoRepeat(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Sign_upActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
