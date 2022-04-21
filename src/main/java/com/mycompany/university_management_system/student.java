/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university_management_system;

/**
 *
 * @author mkvar
 */
public class student {
    String studentName;
    String studentId;
    String phoneNumber;
    String address;
    String newPassword=null;
    student(String studentName,String studentId,String phoneNumber,String address,String newPassword){
        this.studentName=studentName;
        this.studentId=studentId;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.newPassword=newPassword;
    }
    public static void main(String args[]){
    }
}
