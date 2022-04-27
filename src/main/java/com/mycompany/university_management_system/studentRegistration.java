/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university_management_system;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author suhas
 */
public class studentRegistration {
    public static boolean addRegistration (String id, String name, String course_1, String course_2, String course_3, String course_4, String course_5, Connection c) {
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO student_table values('" +id+"','"+name+"','"+course_1+"','"+course_2+"','"+course_3+"','"+course_4+"','"+course_5+"');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+" :  " + e.getMessage());
            System.exit(0);
        }
        return false;
    }
}
