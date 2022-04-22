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
public class validateUser {
    public static void validate(String username,String password) {
        Connection c=null;
        Statement stmt=null;
        try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5433/postgres",
            "postgres", "postgres");
         System.out.println("Opened database successfully");
         stmt = c.createStatement();
         String sql = "SELECT*from login where username='"+username+"';";
         System.out.println(sql);
         ResultSet rs=stmt.executeQuery(sql);
         while(rs.next()){
             if(username.contentEquals(rs.getString("username")) && password.contentEquals(rs.getString("password"))){
                 if(rs.getString("role").contentEquals("admin")){
                             Update_Profile updateProf=new Update_Profile();
                             updateProf.setVisible(true);
                 }
                 else{
                     //do nothing for now
                 }
             }
         }
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
    }
    public static void main(String args[]){        
    }
}
