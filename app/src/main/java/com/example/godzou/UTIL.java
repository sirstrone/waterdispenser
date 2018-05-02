package com.example.godzou;

/**
 * Created by renyangqi on 2018/4/2.
 */
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UTIL {
    final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

    public static Connection openConnection(String url, String user,
                                            String password) {
        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            conn = null;
            Log.i("Util", "数据库驱动类加载异常");
        } catch (SQLException e) {
            conn = null;
            Log.i("Util", "数据库连接失败异常");
        }
        System.out.println(conn);
        return conn;
    }


    public static String queryLoginPassWord( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        String x="";

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
           // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("pass_word");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
               x=  result.getString(nameColumnIndex);
                    //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;

    }

    public static String querySwitch( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        String x="";

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("switch");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getString(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;

    }

    public static String queryPreset_temperature( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        String x="";

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("Preset_temperature");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getString(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            
        }

        return x;

    }

    public static boolean execSQL( String sql) {
        boolean execResult = false;
         String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
         String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
         String USER = "mark";
         String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       /* if (conn == null) {
            return execResult;
        }*/
        Statement statement = null;
        try {
            statement = conn.createStatement();
            if (statement != null) {
                execResult = statement.execute(sql);
            }
        } catch (SQLException e) {
            execResult = false;
        }
        return execResult;
    }


    /*----------------------------------------------------------------------------------------------------------*/
    public static int queryYear( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        int x=0;

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("year");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getInt(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;

    }

    public static int queryMonth( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        int x=0;

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("month");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getInt(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;

    }
    public static int queryDay( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        int x=0;

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("day");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getInt(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;

    }
    public static int queryHour( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        int x=0;

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("hour");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getInt(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;

    }
    public static int queryMinute( String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        int x=0;

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("minute");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getInt(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;

    }

    public static String queryUserName(String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        String x="";

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("minute");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getString(nameColumnIndex);
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;
    }

    public static String queryCurrentTemp(String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        String x="";

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("Current_temperature");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getInt(nameColumnIndex)+"";
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;
    }
    public static String queryCurrentWeight(String sql) {
        String REMOTE_IP = "rm-wz9p51na9ghek56ej3o.mysql.rds.aliyuncs.com";
        String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
        String USER = "mark";
        String PASSWORD = "19980915ryq!";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        String x="";

        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            // System.out.println(result);
            if (result != null && result.first()) {
                //int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("weight");
                //System.out.println("id\t\t" + "name");
                /*while (!result.isAfterLast()) {*/
                x=  result.getInt(nameColumnIndex)+"";
                //System.out.println(result.getString(nameColumnIndex));
                 /*   result.next();
                }*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }

        return x;
    }
}
