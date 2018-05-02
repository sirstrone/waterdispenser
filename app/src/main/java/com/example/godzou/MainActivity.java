package com.example.godzou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(2000); //停顿两秒
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent openCalculator=new Intent("example.godzou.TABHOST");//添加目标地址
                    startActivity(openCalculator);
                }
            }
        };
        timer.start();
    }

    @Override//下面的代码是让程序直接退出，而不是返回上一个界面
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
