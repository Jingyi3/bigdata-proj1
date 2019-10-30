package com.olivia.nyu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweeterHelper {
    private static String url_unic = "?useUnicode=true&characterEncoding=utf8";

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "zjy666666";
    private static Connection conn = null;
    private static final String FILE_NAME = "/Users/oliz/Codes/data/c.txt";
    private static final String USER_REGEX = "<user[0-9]+>(.*?)</user[0-9]+>";
    private static final String TWEET_REGEX = "<tweet[0-9]+>(.*?)</tweet[0-9]+>";
    private static final String TABLE_FOLLOWERS = "followers";
    private static final String TABLE_TWEETS = "tweets";

    private static List<String> followerID = new ArrayList<>();
    private static List<String> tweets = new ArrayList<>();
    private static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        TweeterHelper.readFileByLines(FILE_NAME);
        TweeterHelper tweeterHelper = new TweeterHelper();
        getConnection();
//        tweeterHelper.printerHelper();
//        tweeterHelper.readFileByLines(FILE_NAME);
//        tweeterHelper.dbHelper();


//        insertIntoFollowersTable("followers_demo1");
//        insertIntoTweetsTable("tweets_demo");

//        System.out.println("Here are first 1000 followersID of this account:");
//        showFollowerID("followers_demo1");
//
//        System.out.println("You can see tweets of a follower by entering his/her id:");
//        Scanner scan = new Scanner(System.in);
//        String enteredID = "";
//        if (scan.hasNextLine()) {
//            enteredID = scan.nextLine();
//            System.out.println("FollowersID you typed in is：" + enteredID);
//        }
//        scan.close();
//
//        if (!enteredID.equals("")) {
//            showTweetFromID("tweets_demo", enteredID);
//        }
        createFollowersTableIfNotExist(TABLE_FOLLOWERS);
        createTweetsTableIfNotExist(TABLE_TWEETS);

    }


    //read raw data from txt
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            boolean isFirst = false;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                getContent(tempString, isFirst);
//                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    //store content userid to followerID, map followerID and tweets to map
    public static void getContent(String string, boolean isFirst) {
        StringBuilder content = new StringBuilder("");
        Pattern userPattern = Pattern.compile(USER_REGEX);
        Matcher userMatcher = userPattern.matcher(string);
        Pattern tweetPattern = Pattern.compile(TWEET_REGEX);
        Matcher tweetMatcher = tweetPattern.matcher(string);
        if (userMatcher.find()) {
            content.append(userMatcher.group(1));
            followerID.add(content.toString());
            if (!isFirst) {
                map.put(followerID.get(followerID.size() - 1), tweets);
                tweets = new ArrayList<>();
            }
        }
        if (tweetMatcher.find()) {
            content.append(tweetMatcher.group(1));
            tweets.add(content.toString());
        }

    }

    //print followerID and tweets map
    public void printerHelper() {
        for (String id : followerID) {
            System.out.println("id:" + id);

        }
        System.out.println("-------------------------------");
        for (Object key : map.keySet()) {    //只能遍历key
            System.out.print("Key = " + key);
        }

        int totalTweets = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey());
            List<String> list = entry.getValue();
            int i = 0;
            for (String tweet : list) {
                System.out.println("tweet " + i + ":");
                System.out.println(tweet);
                i++;
                totalTweets++;
            }
        }

        System.out.println("list.size: " + followerID.size());
        System.out.println("map size : " + map.size());
        System.out.println("total tweets are : " + totalTweets);
    }


    public static boolean insertIntoFollowersTable(String table) {
        Connection conn = getConnection();

        try {
            String insertIDSQL = "insert into " + table + " (" + "twitterID" + ")" + " values " + "(?)";
            PreparedStatement pstmt = conn.prepareStatement(insertIDSQL);
//            System.out.println(insertIDSQL);
            for (String id : followerID) {
//                System.out.println("id: " + id);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
            }

            System.out.println("insert followerID data success!");
            closeCon(conn);
            pstmt.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("insert data fail!");
            closeCon(conn);
            return false;
        }
    }

    public static boolean insertIntoTweetsTable(String table) {
        Connection conn = getConnection();
        try {
            String insertIDandTweetSQL = "insert into " + table + " (" + "twitterID, tweet" + ")" + " values " + "(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(insertIDandTweetSQL);
            System.out.println(insertIDandTweetSQL);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String currID = entry.getKey();
                List<String> list = entry.getValue();
                int i = 0;
                for (String tweet : list) {
                    pstmt.setString(1, currID);
                    pstmt.setString(2, tweet);
                    pstmt.executeUpdate();
                    i++;
                }
            }
            System.out.println("insert tweet data success!");
            pstmt.close();
            closeCon(conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("insert data fail!");
            closeCon(conn);
            return false;
        }
    }


    //show all follower ID
    public static boolean showFollowerID(String table) {
        Connection conn = getConnection();
        try {
            String queryIDSQL = "select * from " + table;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryIDSQL);
            System.out.println("All followers' twitterID: ");
            int followerCounter = 0;
            while (resultSet.next()) {
                followerCounter++;
                String twitterID = resultSet.getString("twitterID");
                //print result
                System.out.println("Follower " + followerCounter + " : " + twitterID);
            }
            resultSet.close();
            statement.close();
            closeCon(conn);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("show followers' twitterID fail!");
            closeCon(conn);
            return false;
        }
    }

    //show all tweet from a follower ID
    public static boolean showTweetFromID(String table, String twitterID) {
        Connection conn = getConnection();
        try {
            //select tweet from tweets_demo where twitterID=1181277758854488064;
            String queryIDSQL = "select tweet from " + table + " where twitterID=" + twitterID;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryIDSQL);
            System.out.println("All tweets from user " + twitterID + " :");
            int tweetCounter = 0;
            while (resultSet.next()) {
                tweetCounter++;
                String tweet = resultSet.getString("tweet");
                //print result
                System.out.println("Tweet " + tweetCounter + " : ");
                System.out.println(tweet);
            }
            resultSet.close();
            statement.close();
            closeCon(conn);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("show tweets fail!");
            closeCon(conn);
            return false;
        }
    }

    public static void createFollowersTableIfNotExist(String tableName) {
        Connection conn = getConnection();
        try {
            String checkdatabase = "show databases like \"hello\"";//判断数据库是否存在
            String createdatabase = "create  database  hello";//创建数据库

            String checkTable = "show tables like \"" + tableName + "\";";
            String createTable = "create table if not exists " + tableName + " (\n" +
                    "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `twitterID` char(20) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    "  );";
            String dropTable = "drop table " + tableName + " ;";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(checkTable);
            if (resultSet.next()) {// table exists
                System.out.println(tableName + " exists");
                statement.execute(dropTable);
                System.out.println(tableName + "is droped");
            }
            statement.execute(createTable);
            System.out.println(tableName + "creates successfully");

            resultSet.close();
            statement.close();
            closeCon(conn);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("create table fail!");
            closeCon(conn);
        }
    }

    public static void createTweetsTableIfNotExist(String tableName) {
        Connection conn = getConnection();
        try {
            String checkdatabase = "show databases like \"hello\"";//判断数据库是否存在
            String createdatabase = "create  database  hello";//创建数据库

            String checkTable = "show tables like \"" + tableName + "\";";
            String createTable = "CREATE TABLE " + tableName + " (\n" +
                    "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `twitterID` char(20) NOT NULL,\n" +
                    "  `tweet` varchar(255),\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            String dropTable = "drop table " + tableName + " ;";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(checkTable);
            if (resultSet.next()) {// table exists
                System.out.println(tableName + " exists");
                statement.execute(dropTable);
                System.out.println(tableName + "is droped");
            }
            statement.execute(createTable);
            System.out.println(tableName + "creates successfully");
            resultSet.close();
            statement.close();
            closeCon(conn);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("create table fail!");
            closeCon(conn);
        }
    }

    //delete data from table
    public static void dropData(String table) {
        Connection conn = getConnection();
        try {
            String sql = "delete from " + table;
            //System.out.println(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("delete data success!");
            pstmt.close();
            closeCon(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("delete data fail!");
            closeCon(conn);
        }
    }

    //connect DB
    public static Connection getConnection() {
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connection success!");
        } catch (Exception e) {
            System.out.println("connection fail!");
            e.printStackTrace();
        }
        return conn;
    }

    //close db connection
    public static void closeCon(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
