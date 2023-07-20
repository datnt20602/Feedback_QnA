/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author jiggnguyen
 */
public class feedback {

    private int id;
    private String content;
    private Date date;
    private int StudentId;
    private String StudentEmail;
    private int LectureId;
    private String LectureEmail;
    private int CourseId;

    public feedback() {
    }

    public feedback(int id, String content, Date date, int StudentId, String StudentEmail, int LectureId, String LectureEmail, int CourseId) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.StudentId = StudentId;
        this.StudentEmail = StudentEmail;
        this.LectureId = LectureId;
        this.LectureEmail = LectureEmail;
        this.CourseId = CourseId;

    }

    public feedback(int id, String content, Date date, int StudentId, int LectureId, int CourseId) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.StudentId = StudentId;
        this.LectureId = LectureId;
        this.CourseId = CourseId;
    }

    public feedback(String content, Date date, int StudentId, int LectureId, int CourseId) {
        this.content = content;
        this.date = date;
        this.StudentId = StudentId;
        this.LectureId = LectureId;
        this.CourseId = CourseId;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String StudentEmail) {
        this.StudentEmail = StudentEmail;
    }

    public int getLectureId() {
        return LectureId;
    }

    public void setLectureId(int LectureId) {
        this.LectureId = LectureId;
    }

    public String getLectureEmail() {
        return LectureEmail;
    }

    public void setLectureEmail(String LectureEmail) {
        this.LectureEmail = LectureEmail;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

}
