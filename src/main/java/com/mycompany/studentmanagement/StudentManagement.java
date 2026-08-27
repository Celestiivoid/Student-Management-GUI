/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagement;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentManagement {
    private JFrame frame;
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField searchField;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    
    private ArrayList<StudentArray> students = new ArrayList<>();
    
    public StudentManagement() {
        setupGUI();
    }
    
    private void setupGUI() {
        frame = new JFrame();
        
        frame.setTitle("Student Management System");
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel formPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        formPanel.setLayout(new GridLayout(4,2));
        mainPanel.setLayout(new GridLayout(3,1));
        
        String [] columns = {"ID","Name","Age"};
        tableModel = new DefaultTableModel(columns,0);
        studentTable = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(studentTable);
        
        JLabel idLabel = new JLabel("Student ID:");
        idField = new JTextField();
        idField.setColumns(20);
        
        JLabel nameLabel = new JLabel("Student name: ");
        nameField = new JTextField();
        nameField.setColumns(20);
        
        JLabel ageLabel = new JLabel("Student age: ");
        ageField = new JTextField();
        ageField.setColumns(20);
        
        JLabel searchLabel = new JLabel("Search student: ");
        searchField = new JTextField();
        searchField.setColumns(20);
        
        
        JButton button1 = new JButton("Add Student");
        button1.addActionListener(e -> addStudent());
        
        JButton button2 = new JButton("Delete Student");
        button2.addActionListener(e -> deleteStudents());
        
        JButton button3 = new JButton("Search Student");
        button3.addActionListener(e -> searchStudent());
        
        JButton button4 = new JButton("Update Student");
        button4.addActionListener(e -> updateStudent());
        
        formPanel.add(idLabel);
        formPanel.add(idField);
        
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        
        formPanel.add(searchLabel);
        formPanel.add(searchField);
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(scrollPane);
        
        frame.add(mainPanel);
        
        frame.setVisible(true);
    }
    
    public void updateStudent() {
        String studentID = idField.getText();
        String studentName = nameField.getText();
        String studentAge = ageField.getText();
        
        if(studentID.isEmpty() || studentName.isEmpty() || studentAge.isEmpty()) {
                JOptionPane.showMessageDialog(frame,"All fields are required to be filled out. Try Again.");
                return;
            }
        
        int selectedRow = studentTable.getSelectedRow();
        
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a student to update.");
            return;
        }
        
        try {
            int convertedID = Integer.parseInt(studentID);
            int convertedAge = Integer.parseInt(studentAge);
            
            
            StudentArray updatedStudent = new StudentArray(convertedID, studentName, convertedAge);
            students.set(selectedRow, updatedStudent);
            tableModel.setValueAt(idField.getText(), selectedRow, 0);
            tableModel.setValueAt(nameField.getText(), selectedRow, 1);
            tableModel.setValueAt(ageField.getText(), selectedRow, 2);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,"ID or Age field must be numbers.");
            return;
        }
    }
    private void addStudent() {
         String studentID = idField.getText();
            String studentName = nameField.getText();
            String studentAge = ageField.getText();
            if(studentID.isEmpty() || studentName.isEmpty() || studentAge.isEmpty()) {
                JOptionPane.showMessageDialog(frame,"All fields are required to be filled out.");
                return;
            }
            
            try {
                int convertedID = Integer.parseInt(studentID);
                int convertedAge = Integer.parseInt(studentAge);
                StudentArray student = new StudentArray(convertedID, studentName, convertedAge);
                
                students.add(student);
                
                tableModel.addRow(new Object[] {
                    student.getStudentID(),
                    student.getStudentName(),
                    student.getStudentAge()
                });

                JOptionPane.showMessageDialog(frame,"Student successfully added!"
                + "\nStudent ID: " + student.getStudentID()
                + "\nStudent name: " + student.getStudentName()
                + "\nStudent age: " + student.getStudentAge());
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(frame,"Numbers only!");
                return;
            }
    }
    
    private void deleteStudents() {
        int selectedRow = studentTable.getSelectedRow();
        students.remove(selectedRow);
        
        tableModel.removeRow(selectedRow);
    }
    
    private void searchStudent() {
        boolean isFound = false;
        String studentID = searchField.getText();
        
        if(studentID.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "ID field cannot be empty.");
            return;
        }
        
        try {
            int convertedID = Integer.parseInt(studentID);
            for(StudentArray student : students) {
                if(convertedID == student.getStudentID()) {
                    isFound = true;
                    JOptionPane.showMessageDialog(frame,"Student found!" 
                            + "\nID: " + student.getStudentID()
                            + "\nName: " + student.getStudentName()
                            + "\nAge: " + student.getStudentAge());
                    return;
                }
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(frame,"Numbers only!");
            return;
        }
        
        if(!isFound) {
            JOptionPane.showMessageDialog(frame,"Student not found!");
            return;
        }
    }
    
    public static void main(String[] args) {
        new StudentManagement();
    }
}
