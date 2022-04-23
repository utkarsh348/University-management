package com.mycompany.university_management_system;

import java.sql.*;
public class Admin {
    
    public static boolean checkFee(student student, Connection c){
        //select query to get fee status
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT feeStat from STUDENT where student_id = "+student.studentId;
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            stmt.close();
            boolean feeStat = rs.getBoolean("feeStat");
            return feeStat;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return false;
    }

    public static String checkAdm(student student, Connection c){
        //check query if admission is granted or not
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT admissionStat from STUDENT where student_id = "+student.studentId;
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            stmt.close();
            String admissionStat = rs.getString("admissionStat");
            return admissionStat;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return "";
    }
    
    //call fee paid and check adm to grant admission
    public static void admitIfFeePaid(student student,Connection c) {
        Statement stmt = null;
        if(checkFee(student, c)){
            if(checkAdm(student, c)=="granted"){
                try {
                    stmt = c.createStatement();
                    String sql = "SELECT admissionStat from STUDENT where student_id = "+student.studentId;
                    System.out.println(sql);
                    ResultSet rs=stmt.executeQuery(sql);
                    stmt.close();
                } catch (Exception e) {
                    System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                    System.exit(0);
                }
            }
        }

    }
    


}
