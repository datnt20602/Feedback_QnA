/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jiggnguyen
 */
public class Student{

    private int StudentId;
    private String email;
    private String password;
    private String name;
    private int courseId;

    public Student() {
    }

    public Student(int StudentId, String email, String password, String name, int courseId) {
        this.StudentId = StudentId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.courseId = courseId;
    }

    public Student(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
}
