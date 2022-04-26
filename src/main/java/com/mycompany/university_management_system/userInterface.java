/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.university_management_system;

import java.sql.Connection;

/**
 *
 * @author mkvar
 */
public interface userInterface {
    public String[] displayDetails();
    public void updateUserData(Connection c);
    public void setPhoneNumber(String phoneNumber);
    public void setAddress(String address);
}
