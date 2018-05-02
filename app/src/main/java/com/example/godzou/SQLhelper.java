package com.example.godzou;

/**
 * Created by zou on 2018/2/14.
 */
import android.util.Log;

/**
 * 数据表1 User.db
 * 键名
 * 用户名 ** 密码 ** 姓名 ** 地区 ** 学校 ** 宿舍号 ** 当前温度 ** 预设温度 ** 重量 ** 使用时间 **
 * 数据表2 Order.db
 * 键名
 * 订单号 ** 用户名 ** 订单时间 **
 */

public class SQLhelper {

    public static void onInsertSignUp(final String getSignUpUserName,final  String getSignUpUserPassWord,final String getDormitoryNumber) {

                String sql = "insert into user(user_name,pass_word,dorm_number) values" +"("   +"'" +getSignUpUserName+"'" +","+  "\""+     getSignUpUserPassWord+ "\"" + ","  +getDormitoryNumber  +  ")" ;
                UTIL.execSQL(sql);
                Log.i("onInsert", "插入");

    }



    public static boolean onCheckPassWordAndUserName(final String GetLoginUserName, final  String GetLoginPassWord) {


        String JudgePassWord = UTIL. queryLoginPassWord("select * from user where user_name= " + "'" + GetLoginUserName + "'");
        if ( GetLoginUserName != ""&&GetLoginUserName !=null&&JudgePassWord!=""&&JudgePassWord!=null) {
            if (JudgePassWord.equals(GetLoginPassWord)) {
                Log.i("login", "输入密码正确");
                    return true;

            } else {
                Log.i("login", "输入密码错误");

            }
        }
        return false;
    }

    public static String onCheckSwitch(final String GetLoginUserName) {
        String y="yes";
        String n="no";
        String JudgeSwitch= UTIL.querySwitch("select * from user where user_name= " + "'" + GetLoginUserName + "'" );
       if(JudgeSwitch!=null&&JudgeSwitch!="false"&&JudgeSwitch!=""&& !JudgeSwitch.equals("0"))
       {
           return y;
       }
       return n;
    }


    public static void onUpdateSwitchTo1(final String  GetLoginUserName) {
        Log.i("名字", GetLoginUserName);
        String sql = "update user set switch = 1 where user_name="+ "'" +GetLoginUserName+ "'" ;
        UTIL.execSQL(sql);
        Log.i("onInsert", "给你更新");

    }
    public static void onUpdateSwitchTo0(final String  GetLoginUserName) {
        Log.i("名字", GetLoginUserName);
        String sql = "update user set switch = 0 where user_name="+ "'" +GetLoginUserName+ "'" ;
        UTIL.execSQL(sql);
        Log.i("onInsert", "给你更新");

    }
    public static String onQueryTemperature(final String GetLoginUserName) {

        String GetPresetTemperature= UTIL.queryPreset_temperature("select * from user where user_name= " + "'" + GetLoginUserName + "'" );
        if(GetPresetTemperature!=null&&GetPresetTemperature!="false"&&GetPresetTemperature!=""&& !GetPresetTemperature.equals("0"))
        {
            Log.i("", "onQueryTemperature: ");
            return GetPresetTemperature;
        }
        Log.i("", "onQueryTemperature: ");
        return "什么都没有";
    }

    public static void onUpdatePresetTemperature(final String UpdateTemp,final String User_name) {
        Log.i("UpdateTemp", UpdateTemp);
        Log.i("User_name", User_name);
        String sql = "update user set Preset_temperature=" +UpdateTemp+" "+ "where user_name="+"'"+User_name+"'" ;
        UTIL.execSQL(sql);
        Log.i("跟新预设温度", "嗯");

    }





    /*-----------------------------------------------------------------------------------------------------------------------------------------------*/

    public static int onQueryYear(String name_data1) {
        int GetYear= UTIL.queryYear("select * from user where user_name= " + "'" + name_data1 + "'" );

           return GetYear;

    }

    public static int onQueryMonth(String name_data1) {
        int GetMonth= UTIL.queryMonth("select * from user where user_name= " + "'" + name_data1 + "'" );
        return GetMonth;

    }

    public static int onQueryDay(String name_data1) {
        int GetDay= UTIL.queryDay("select * from user where user_name= " + "'" + name_data1 + "'" );
            return GetDay;

    }

    public static int onQueryHour(String name_data1) {
        int GetHour= UTIL.queryHour("select * from user where user_name= " + "'" + name_data1 + "'" );
            return GetHour;

    }

    public static int onQueryMinute(String name_data1) {
        int GetMinute= UTIL.queryMinute("select * from user where user_name= " + "'" + name_data1 + "'" );

            return GetMinute;

    }


    public static String onQuerSignUser_name(String UserName) {
        String Getusername= UTIL.queryUserName("select * from user where user_name= " + "'" + UserName + "'" );
        return Getusername+"";

    }
    public static void onUpdatedate(String sendyear, String sendmonth, String sendday,String sendhour, String sendminute,  String name) {
        String sql = "update user set year=" +sendyear +","+"month="+sendmonth+","+"day="+sendday +","+"hour="+sendhour+","+"minute="+sendminute+" "+ "where user_name="+"'"+name+"'" ;
        UTIL.execSQL(sql);
        Log.i("跟新年月日", sql);

    }

    public static void onUpdatedateToNull(String name) {
        String sql = "update user set year=null,month=null,day=null,hour=null,minute=null where user_name="+"'"+name+"'" ;
        UTIL.execSQL(sql);
        Log.i("清空年月日", sql);
    }
    public static String onQueryCurrentTemp (String username) {
        String CurrentTemp= UTIL.queryCurrentTemp("select * from user where user_name= " + "'" + username + "'" );
        // Log.i("当前温度是", CurrentTemp);
        if(CurrentTemp.equals("")){
            return "常温";
        }
        else {
            return CurrentTemp;
        }


    }
    public static String onQueryCurrentWeight (String username) {
        String weight= UTIL.queryCurrentWeight("select * from user where user_name= " + "'" + username + "'" );
        // Log.i("当前温度是", CurrentTemp);
        if(weight.equals("")){
            return "常温";
        }
        else {
            return weight;
        }


    }



    //将用户信息添加至数据库

    //读取用户信息（登入）

    //读取用户信息（完整（除密码））

    //查询饮水机温度

    //查询饮水机质量

    //修改预设温度

    //查询订单号

    //查询订单时间

}
