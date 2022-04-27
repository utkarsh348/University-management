package com.mycompany.university_management_system;

import java.sql.*;
public class Admin {
    public Admin(){}
    public boolean checkFee(String studentId, Connection c){
        //select query to get fee status
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT feeStat,student_name from STUDENT where student_id = '"+studentId+"';";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            boolean feeStat=false;
            while(rs.next()){
                         feeStat = rs.getBoolean("feeStat");
                         String sname = rs.getString("student_name");
            }
            stmt.close();
            return feeStat;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return false;
    }

    public String checkAdm(String studentId,Connection c){
        //check query if admission is granted or not
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT admissionStat from STUDENT where student_id = '"+studentId+"';";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            String admissionStat="";
            while(rs.next()){
                         admissionStat = rs.getString("admissionStat");   
            }
            stmt.close();
            return admissionStat;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return "";
    }
    
    //call fee paid and check adm to grant admission
    public String admitIfFeePaid(String studentId,Connection c) {
        Statement stmt = null;
        if(checkFee(studentId, c)){
            if(checkAdm(studentId, c)=="granted"){
                try {
                    stmt = c.createStatement();
                    String sql = "UPDATE STUDENT set admissionStat = 'admitted' where student_id = '"+studentId+"';";
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                    stmt.close();
                    return "granted and entered";
                } catch (Exception e) {
                    System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                    System.exit(0);
                }
                
            }else if (checkAdm(studentId, c)=="admitted"){
                return "Admission already granted";
            }
            else{
                return "Admission not granted";
            }
        }else{
            return "Fee not paid";
        }
        return null;
    }
    
    //get student details
    public String sname(Connection c, String studentId) {

        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "SELECT student_name from STUDENT where student_id = '"+studentId+"';";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            String name="";
            while(rs.next()){
              name=rs.getString("student_name");   
            }
            stmt.close();
            return name;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return null;
        
    }

}
