package com.mycompany.university_management_system;

import java.sql.*;
public class Admin {
    public Admin(){}
    public static boolean checkFee(String studentId, Connection c){
        //select query to get fee status
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT feeStat from STUDENT where student_id = "+studentId;
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            stmt.close();
            String sname = rs.getString("student_name");
            boolean feeStat = rs.getBoolean("feeStat");
            return feeStat;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return false;
    }

    public static String checkAdm(String studentId,Connection c){
        //check query if admission is granted or not
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT admissionStat from STUDENT where student_id = "+studentId;
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
    public static String admitIfFeePaid(String studentId,Connection c) {
        Statement stmt = null;
        if(checkFee(studentId, c)){
            if(checkAdm(studentId, c)=="granted"){
                try {
                    stmt = c.createStatement();
                    String sql = "UPDATE STUDENT set admissionStat = 'admitted' where student_id = "+studentId;
                    System.out.println(sql);
                    stmt.executeQuery(sql);
                    stmt.close();
                } catch (Exception e) {
                    System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                    System.exit(0);
                }
                return "granted and entered";
            }else if (checkAdm(studentId, c)=="admitted"){
                return "Admission already granted";
            }
            else{
                return "Admission not granted";
            }
        }else{
            return "Fee not paid";
        }

    }
    
    //get student details
    public static String sname(Connection c, String studentId) {

        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT student_name from STUDENT where student_id = "+studentId;
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            String name = rs.getString("student_name");
            stmt.close();
            return name;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return null;
        
    }

}
