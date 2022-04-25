/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university_management_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 *
 * @author mkvar
 */
public class courseUpdates {
    public static boolean addCourse(String courseName,String semester,String desc,String type,Connection c){
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO courses values('"+courseName+"','"+semester+"','"+desc+"','"+type+"');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return false;
    }
        public static boolean deleteCourse(String courseName,Connection c){
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM courses where Course_name='"+courseName+"';";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return false;
    }
    public static boolean showCourse(Connection c){
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT * FROM courses;";
            System.out.println(sql);
            ResultSet r1=stmt.executeQuery("select count(*) as count from courses;");
            JFrame frame=new JFrame();
            int row=0;
            if(r1.next()){
                row=Integer.parseInt(r1.getString("count"));  
            }
            String data[][]=new String[row][4];
            int i=0;
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                data[i][0]=rs.getString("Course_name");
                data[i][1]=rs.getString("semester");
                data[i][2]=rs.getString("description");
                data[i][3]=rs.getString("type");
                i++;
                //{rs.getString("Course_name"),rs.getString("semester"),rs.getString("description"),rs.getString("type")});
            }
            String col[]={"CName","Sem","Desc","Type"};
            DefaultTableModel model = new DefaultTableModel(data, col);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("View Course Data");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 250);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return false;
    }
    courseUpdates(){}
}
