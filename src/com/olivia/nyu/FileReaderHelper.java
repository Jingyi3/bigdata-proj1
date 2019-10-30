package com.olivia.nyu;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//String url ="jdbc:mysql://olivia-bigdata.mysql.database.azure.com:3306/{your_database}?useSSL=true&requireSSL=false"; myDbConn = DriverManager.getConnection(url, "olivia@olivia-bigdata", {your_password});

public class FileReaderHelper {
    private static final String FILE_NAME = "/Users/oliz/Codes/data/a.txt";
    private static final String USER_REGEX = "<user[0-9]+>(.*?)</user[0-9]+>";
    private static final String TWEET_REGEX = "<tweet[0-9]+>(.*?)</tweet[0-9]+>";
    private static List<String> followerID = new ArrayList<>();
    private static List<String> tweets = new ArrayList<>();
    private static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        FileReaderHelper.readFileByLines(FILE_NAME);
        System.out.println("-------------------------------");
        //
        for(Object key : map.keySet()){	//只能遍历key
            System.out.println("Key = "+key);
        }

        int totalTweetts = 0;
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            System.out.println("Key = "+entry.getKey());
            List<String> list = entry.getValue();
            int i = 0;
            for (String tweet : list) {
                System.out.println("tweet " + i + ":");
                System.out.println(tweet);
                i++;
                totalTweetts++;
            }
        }

        System.out.println("list.size: " + followerID.size());
        System.out.println("map size : " + map.size());
//        System.out.println("total tweets are : " + totalTweetts);
//
//        for(Object value : map.values){  //只能遍历value
//            System.out.print("Value = "+value);
//        }
    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new java.io.FileReader(file));
            String tempString = null;
            int line = 1;
            boolean isFirst = false;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {

//                System.out.println(tempString);
                getContent(tempString, isFirst);
                // 显示行号
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
    public static void getContent(String string, boolean isFirst) {
        boolean isUser = false;
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



    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
//
//    public static void readFile(String filename) {
//        String pathname = filename; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
//        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
//        //不关闭文件会导致资源的泄露，读写文件都同理
//        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
//        try (FileReader reader = new FileReader(pathname);
//             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
//        ) {
//            String line;
//            //网友推荐更加简洁的写法
//            while ((line = br.readLine()) != null) {
//                // 一次读入一行数据
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//            String everything = sb.toString();
//        }
//    }




    public void readFileAgain(String fileName) {
        //读取文件
        BufferedReader br = null;
        StringBuffer sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GBK")); //这里可以控制编码
            sb = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String s = new String(sb); //StringBuffer ==> String
        System.out.println("addressBook.txt内容为==> " + s);
        System.out.println();
        //1、匹配子串
        String regex = "1[378][0-9]{9}";

        //2、获取匹配器
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        //3、使用匹配器的group()方法来获取:（find方法是判断是否具有匹配子串）、
        System.out.println("”" + s + "符合要求的电话号码有：");
        while (m.find()) {
            System.out.println(m.group());
        }
    }

}
