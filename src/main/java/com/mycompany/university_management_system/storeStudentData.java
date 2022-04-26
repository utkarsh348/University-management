/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university_management_system;
import java.sql.*;

/**
 *
 * @author mkvar
 */
public class storeStudentData {
    student studentData;
    public static void connectDatabase(student studentData) {
        Connection c=null;
        Statement stmt=null;
        try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5433/postgres",
            "postgres", "postgres");
         System.out.println("Opened database successfully");
         stmt = c.createStatement();
         String sql = "INSERT INTO student values('"+studentData.studentId+"','"+studentData.studentName+"','"+studentData.phoneNumber+"','"+studentData.address+"');";
         System.out.println(sql);
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
    }
    storeStudentData(student studentData){
        this.studentData=studentData;
    }
}
