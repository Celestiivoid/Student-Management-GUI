/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagement;

/**
 *
 * @author User
 */
public class Student {
    private int studentID;
    private String studentName;
    private int studentAge;
    
    Student(int studentID, String studentName, int studentAge) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
    
    int getStudentID() {
        return studentID;
    }
    
    String getStudentName() {
        return studentName;
    }
    
    int getStudentAge() {
        return studentAge;
    }
}
