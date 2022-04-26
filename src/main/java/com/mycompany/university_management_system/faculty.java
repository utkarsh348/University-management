/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university_management_system;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author mkvar
 */
public class faculty implements userInterface{
    String facultyName;
    String facultyId;
    String phoneNumber;
    String address;
    String core;
    @Override
    public String[] displayDetails(){
        String[] val={this.facultyName,this.facultyId,this.core};
        return val;
    }
    @Override
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    @Override
    public void setAddress(String address){
        this.address=address;
    }
    @Override
    public void updateUserData(Connection c){
                Statement stmt=null;
        try{
            stmt = c.createStatement();
            String sql = "UPDATE faculty set faculty_name='"+facultyName+"',core='"+core+"',phone_num='"+phoneNumber+"',address='"+address+"' where faculty_id='"+facultyId+"';";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    faculty(String facultyName,String facultyId,String phoneNumber,String address,String core){
        this.facultyName=facultyName;
        this.facultyId=facultyId;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.core=core;
    }
}
