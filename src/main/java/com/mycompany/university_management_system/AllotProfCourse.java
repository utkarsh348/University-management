package com.mycompany.university_management_system;

import java.sql.*;
public class AllotProfCourse {
    
    AllotProfCourse(){}

    public static void addCourse(String profId, String courseId, Connection c){
        //insert query to add course to prof
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT * from PROFESSOR where prof_id = "+profId;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            for(int i = 1;i<=3;i++){
                if(rs.getString("course_id"+i)==null){
                    sql = "UPDATE PROFESSOR set course_"+i+" = "+courseId+" where prof_id = "+profId;
                    System.out.println(sql);
                    stmt = c.createStatement();
                    stmt.executeUpdate(sql);
                    stmt.close();
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
