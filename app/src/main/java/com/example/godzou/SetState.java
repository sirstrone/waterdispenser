package com.example.godzou;

/**
 * Created by renyangqi on 2018/2/17.
 */

public class SetState {
    private String YinShuiJiKaiGuan=null;//设置饮水机开关
    private String NowTemperayure=null;//查看当前饮水机温度
    private String SetTemperature=null;//设置饮水机温度
    private String SetDate=null;//设置日期如2017年08月04号
    private String SetTime=null;//设置时间如09：23
    private boolean StartHeating=false;

    public void SetYinShuiJiKaiGuan(String KaiOrGuan){

        this.YinShuiJiKaiGuan=KaiOrGuan;
    }
    public void  SetTemperature(String SetTemperature){

        this.SetTemperature=SetTemperature;
    }
    public void  SetDate(String SetDate){

        this.SetDate=SetDate;
    }
    public void  SetTime (String SetTime){

        this.SetTime=SetTime;
    }
    public void  StartHeating (boolean StartHeating){

        this.StartHeating=StartHeating;
    }
}
