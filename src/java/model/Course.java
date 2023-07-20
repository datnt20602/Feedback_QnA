/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jiggnguyen
 */
public class Course {

    private int CourseId, studentId, lectureId;
    private String name, image, teacher, student;

    public Course() {
    }

    public Course(int CourseId, String name) {
        this.CourseId = CourseId;
        this.name = name;
    }

    public Course(int CourseId, String name, String image) {
        this.CourseId = CourseId;
        this.name = name;
        this.image = image;
    }

    public Course(int CourseId, String name, String image, String teacher) {
        this.CourseId = CourseId;
        this.name = name;
        this.image = image;
        this.teacher = teacher;
    }

    public Course(int CourseId, int studentId, int lectureId, String name, String image, String teacher) {
        this.CourseId = CourseId;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.name = name;
        this.image = image;
        this.teacher = teacher;
    }

    public Course(int CourseId, int studentId, int lectureId, String name, String image, String teacher, String student) {
        this.CourseId = CourseId;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.name = name;
        this.image = image;
        this.teacher = teacher;
        this.student = student;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
    

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }
    
    

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
