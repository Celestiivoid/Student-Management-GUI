
package com.mycompany.studentmanagement;

/**
 *
 * @author User
 */
public class StudentArray {
    private int studentID;
    private String studentName;
    private int studentAge;
    
    StudentArray(int studentID, String studentName, int studentAge) {
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
