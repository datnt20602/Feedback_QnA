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
public class qna {

    private int id;
    private String question;
    private String answer;
    private Date date;
    private int studentId;
    private int lectureId;
    private int courseId;
    private String studentName;
    private String lectureName;

    public qna() {
    }

    public qna(int id, String question, String answer, Date date, int studentId, int lectureId, int courseId) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.date = date;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.courseId = courseId;
    }

    public qna(String question, String answer, Date date, int studentId, int lectureId, int courseId) {
        this.question = question;
        this.answer = answer;
        this.date = date;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.courseId = courseId;
    }

    public qna(String question, Date date, int studentId, int lectureId, int courseId) {
        this.question = question;
        this.date = date;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.courseId = courseId;
    }

    public qna(int id, String question, String answer, Date date, int studentId, int lectureId, int courseId, String studentName, String lectureName) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.date = date;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.courseId = courseId;
        this.studentName = studentName;
        this.lectureName = lectureName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
