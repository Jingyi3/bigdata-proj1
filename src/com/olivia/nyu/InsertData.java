package com.olivia.nyu;

/**
 参数说明：java -jar InsertData.jar 数据库url 表名 文件路径 是否再插入前删除
 该方法存在的问题是，读入本地数据后没必要放在二维数组中，这样会大大降低插入的效率，可以分块读入，每次读几千条，然后插入数据库，并提交。或者使用多线程，还在学习之中。
 */



import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;



public class InsertData {

    private static String url_unic = "?useUnicode=true&characterEncoding=utf8";

    //读取文本文件
    public static String[][] writeToDat(String path){
        File file = new File(path);
        List<String> list = new ArrayList<String>();
        String[][] strings = null;

        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf8");
            BufferedReader bw = new BufferedReader(isr);
            String line = null;
            while((line = bw.readLine()) != null){
                //System.out.println(line);
                list.add(line);
            }
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        strings = new String[list.size()][14];
        for(int i=0;i<list.size();i++){
            String[] st = list.get(i).split("\t");
            for(int j=0;j<st.length;j++){
                strings[i][j] = st[j];
                //System.out.println(strings[i][j]);
            }


        }
        System.out.println("load data success!");
        return strings;
    }



    //连接数据库
    public static Connection getConnection(String url,String dataBase,String user,String pwd){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url_total = url+"/"+dataBase+url_unic;
            //System.out.println(url_total);
            conn = DriverManager.getConnection(url_total,user,pwd);
            System.out.println("connection success!");
        } catch(Exception e){
            System.out.println("connection fail!");
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库连接

    public static void closeCon(Connection con){
        if(con != null){
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //插入数据
    public static boolean insertIntoTable(String url,String dataBase,String user,String pwd,String table,String[][] str){
        Connection conn = getConnection(url,dataBase,user,pwd);

        try{
            String sql = "insert into " + table + " (" + "inner_account_id,account_id,custom_id,custom_cname,account_type,is_internal,"
                    + "first_login_date,last_date,account_mode,is_special_line,account_status,custom_type_id,iwind_type,has_auxiliary"
                    + ")" + " values " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //System.out.println(sql);

            for(int i=0;i<str.length;i++){
                pstmt.setInt(1,Integer.parseInt(str[i][0]));
                //System.out.println(str[i][0]);
                for(int j=1;j<str[i].length;j++){
                    //System.out.println(str[i][j]);
                    pstmt.setString(j+1,str[i][j]);
                }
                pstmt.executeUpdate();
            }
            System.out.println("insert data success!");
            closeCon(conn);
            return true;

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("insert data fail!");
            closeCon(conn);
            return false;
        }
    }

    //删除数据库数据
    public static void dropData(String url,String dataBase,String user,String pwd,String table){
        Connection conn = getConnection(url,dataBase,user,pwd);
        try{
            String sql = "delete from "+ table;
            //System.out.println(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("delete data success!");
            closeCon(conn);

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("delete data fail!");
            closeCon(conn);
        }
    }

    public static void main(String[] args){
		/*--------调试-----------//
		String path = "C:/Users/pchen.lyndon/Desktop/file.txt";
		String[][] strings = writeToDat(path);
		for(int i=0;i<strings.length;i++){
			for(int j=0;j<strings[i].length;j++){
				System.out.print(strings[i][j]+'\t');
			}
			System.out.println();

		}
		//----------end---------*/


        String url = args[0];
        String table = args[1];
        String path = args[2];
        String deleteFlag = args[3];
        System.out.println(deleteFlag);
        String dataBase = "****";
        String user = "****";
        String pwd = "****";
        System.out.println(url);
        System.out.println(table);
        System.out.println(path);

        //将文件数据读入二维数组
        String[][] strings = writeToDat(path);


        if(deleteFlag.equals("true") | deleteFlag.equals("True")){
            dropData(url,dataBase,user,pwd,table);
        }

        //创建数据库连接,并向数据库中插入数据
        insertIntoTable(url,dataBase,user,pwd,table,strings);

    }
}