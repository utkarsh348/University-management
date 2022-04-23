package com.mycompany.university_management_system;
import java.sql.*;
public class DBsingleton {
    private static DBsingleton jdb;

    private DBsingleton(){}

    public static DBsingleton getInstance() {    
        if (jdb==null)  
        {  
               jdb=new  DBsingleton();  
        }  
        return jdb;  
    } 

    public static Connection getConnection()throws ClassNotFoundException, SQLException  {  
                
        Connection c=null;
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://localhost:5433/postgres",
           "postgres", "postgres");
        System.out.println("Opened database successfully");
        return c;  
                
    }  
}


