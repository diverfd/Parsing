package com.myowntry.datahandler;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by box on 19.06.2014.
 */
public class TestH2 {
    public void writeToH2db(List<Map.Entry<String, Integer>> sortedWords, String parsedUrl)  {
        String createTable = "CREATE TABLE " + parsedUrl + " (`id` int(5) NOT NULL auto_increment, `title` varchar(50) default NULL)";
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/wordsHolder", "root", "");
            statement = conn.createStatement();
            statement.executeUpdate(createTable);
            System.out.println("Table <" + parsedUrl + "> has been created.");
            for(Map.Entry<String, Integer> eachWord : sortedWords){
                String writeWords = "INSERT INTO " + parsedUrl + " values (default, '" + String.valueOf(eachWord) + "')";
                statement.executeUpdate(writeWords);
            }
            System.out.println("Words have been inserted into table <" + parsedUrl + ">.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null){
                try{
                    statement.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
