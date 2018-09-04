/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DatabaseHelper {
    public static final String DRIVER_NAME="com.mysql.jdbc.Driver";
    public static final String LOCAL_HOST_PORT="jdbc:mysql://localhost:3306/";
    public static final String DATABASE_NAME="diu_routine_planner";
    public static final String DB_PASSWORD="root";
    public static final String DB_USER_NAME="root";
    
    public static final String TEACHER_TABLE_NAME="teachers";
    public static final String KEY_ID="id";
    public static final String KEY_TEACHER_ID="teacher_id";
    public static final String KEY_TEACHER_NAME="name";
    public static final String KEY_TEACHER_DESIGNATION="designation";
    public static final String KEY_TEACHER_PHONE_NUMBER="phone_number";
    public static final String KEY_TEACHER_IMAGE="image_location";
    
    
    public static final String TABLE_CREATION_TEACHER="CREATE TABLE IF NOT EXISTS "+TEACHER_TABLE_NAME+" ("+KEY_ID+
            " int(11) NOT NULL AUTO_INCREMENT  PRIMARY KEY, "+ KEY_TEACHER_NAME+" varchar(20) NOT NULL,"+
            KEY_TEACHER_ID+" varchar(20) NOT NULL,"+KEY_TEACHER_DESIGNATION+" varchar(20) NOT NULL,"+
            KEY_TEACHER_PHONE_NUMBER+" varchar(20) NOT NULL,"+KEY_TEACHER_IMAGE+" varchar(20) NOT NULL)";
  
    
    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(LOCAL_HOST_PORT, DB_USER_NAME, DB_PASSWORD);
          
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+DATABASE_NAME);
            
            
            connection=DriverManager.getConnection(LOCAL_HOST_PORT+DATABASE_NAME, DB_USER_NAME, DB_PASSWORD);
            statement=connection.createStatement();
            
            
            int done=statement.executeUpdate(TABLE_CREATION_TEACHER);
            if (done==1) {
                System.out.println("CREATED");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return connection;

    }
}
