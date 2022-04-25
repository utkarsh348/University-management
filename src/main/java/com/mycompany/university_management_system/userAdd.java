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
public class userAdd {
    public static boolean addAdmin(String username,String password){
        try{
            Connection c=DBsingleton.getConnection();
            Statement stmt= c.createStatement();
            String sql="INSERT INTO login values('"+username+"','"+password+"','admin');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        return false;
    }
    userAdd(){}
}
