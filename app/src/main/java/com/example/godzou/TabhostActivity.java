package com.example.godzou;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabhostActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        TabHost tabHost = getTabHost();

        Intent intentx=getIntent();
        String userName=intentx.getStringExtra("LoginName");
        String switchState=intentx.getStringExtra("switch_data");
        String NowTemp=intentx.getStringExtra("NOWTEMPE");
        String NowWeight=intentx.getStringExtra("NOWWEIGHT");
        Intent intenty=new Intent();

        intenty.putExtra("userNAME",userName);
        intenty.putExtra("siwtchSTATE",switchState);
        intenty.putExtra("NowTemp",NowTemp);
        intenty.putExtra("NowWeight",NowWeight);

        tabHost.addTab(tabHost.newTabSpec("TAB1").setIndicator("",
                getResources().getDrawable(R.drawable.icon1)).setContent(intenty.setClass(this,HomeActivity.class)));

        tabHost.addTab(tabHost.newTabSpec("TAB2").setIndicator("",
                getResources().getDrawable(R.drawable.icon2)).setContent(new Intent().setClass(this,OrderActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("TAB3").setIndicator("",
                getResources().getDrawable(R.drawable.icon3)).setContent(new Intent().setClass(this,PersonalActivity.class)));
        int i;
        for (i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
    }
}
