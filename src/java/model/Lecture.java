/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jiggnguyen
 */
public class Lecture {

    private int LectureId;
    private String email;
    private String password;
    private String name;
    private int courseId;

    public Lecture() {
    }

    public Lecture(int LectureId, String email, String password, String name, int courseId) {
        this.LectureId = LectureId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.courseId = courseId;
    }

    public Lecture(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getLectureId() {
        return LectureId;
    }

    public void setLectureId(int LectureId) {
        this.LectureId = LectureId;
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
