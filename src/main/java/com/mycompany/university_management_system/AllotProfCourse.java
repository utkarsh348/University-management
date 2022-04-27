package com.mycompany.university_management_system;

import java.sql.*;
public class AllotProfCourse {
    
    AllotProfCourse(){}

    public void addCourse(String profId, String courseId, Connection c, String sem){
        //insert query to add course to prof
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT * from PROFESSOR where professor_id = '"+profId+"';";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            int i=1;
            while(rs.next()){
                if(rs.getString("course_"+i)==null){
                    sql = "UPDATE PROFESSOR set course_"+i+" = '"+courseId+"',set semc"+i+"='"+sem+"' where professor_id = '"+profId+"';";
                    System.out.println(sql);
                    stmt = c.createStatement();
                    stmt.executeUpdate(sql);
                    break;
                }
                i++;
            }
                      stmt.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
