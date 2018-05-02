package com.example.godzou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class PersonalActivity extends AppCompatActivity {
    private ImageView iv_sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        iv_sign =(ImageView) findViewById(R.id.iv_sign);
        iv_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, LoginActivity.class);//intent实现链接
                startActivity(intent);
            }

        });
    }
}
