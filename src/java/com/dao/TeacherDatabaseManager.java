/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class TeacherDatabaseManager {

    public static int registrationTeacher(Teacher teacher) {
        int status = 0;
        Connection connection = DatabaseHelper.getConnection();

        if (isteacherRegistered(teacher.getTeacherID())) {
            status = 2;
        } else {
            try {
                PreparedStatement statement = connection.prepareCall("INSERT INTO " + DatabaseHelper.TABLE_NAME_TEACHER
                        + " (" + DatabaseHelper.KEY_TEACHER_ID + ", " + DatabaseHelper.KEY_TEACHER_NAME + ", "
                        + DatabaseHelper.KEY_TEACHER_DESIGNATION + ", " + DatabaseHelper.KEY_TEACHER_PHONE_NUMBER
                        + ", " + DatabaseHelper.KEY_TEACHER_IMAGE + ") values(?,?,?,?,?)");
                statement.setString(1, teacher.getTeacherID());
                statement.setString(2, teacher.getName());
                statement.setString(3, teacher.getDesignation());
                statement.setString(4, teacher.getPhoneNumber());
                statement.setString(5, teacher.getImage_location());

                status = statement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(TeacherDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return status;
    }

    private static boolean isteacherRegistered(String teacherID) {
        boolean status = false;
        Connection connection = DatabaseHelper.getConnection();
        try {
            PreparedStatement statement = connection.prepareCall("SELECT * FROM "
                    + DatabaseHelper.TABLE_NAME_TEACHER + " WHERE " + DatabaseHelper.KEY_TEACHER_ID + "=?");
            
            statement.setString(1, teacherID);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;

    }

}
