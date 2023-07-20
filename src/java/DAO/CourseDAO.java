/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;

/**
 *
 * @author dmngh
 */
public class CourseDAO extends DatabaseConnect {

    public List<Course> getAllByStudent(int id) {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "SELECT c.course_id, s.student_id, l.lecture_id, c.name, c.image, l.name, s.name FROM course c\n"
                    + "LEFT JOIN student s ON s.course_id = c.course_id\n"
                    + "LEFT OUTER JOIN lecture l ON l.course_id = c.course_id\n"
                    + "WHERE s.student_id = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("getAllByStudent: " + e.getMessage());
        }

        return list;
    }

    public List<Course> getAllByLecture(int id) {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "SELECT c.course_id, s.student_id, l.lecture_id, c.name, c.image, l.name, s.name FROM course c\n"
                    + "LEFT JOIN student s ON s.course_id = c.course_id\n"
                    + "LEFT OUTER JOIN lecture l ON l.course_id = c.course_id\n"
                    + "WHERE l.lecture_id = ?\n"
                    + "ORDER BY c.course_id";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int courseId = 0;
            while (rs.next()) {
                if (list.size() > 0) {
                    if (courseId != rs.getInt(1)) {
                        courseId = rs.getInt(1);
                        list.add(new Course(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                    }
                } else {
                    courseId = rs.getInt(1);
                    list.add(new Course(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                }
            }
        } catch (SQLException e) {
            System.out.println("getAllByLecture: " + e.getMessage());
        }

        return list;
    }

    public Course getCourseById(int cid, int sid, int lid) {
        try {
            String sql = "SELECT c.course_id, s.student_id, l.lecture_id, c.name, c.image, l.name, s.name FROM course c\n"
                    + "LEFT JOIN lecture l ON l.course_id = c.course_id\n"
                    + "LEFT JOIN student s ON s.course_id = c.course_id\n"
                    + "WHERE c.course_id = ? AND s.student_id = ? AND l.lecture_id = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setInt(2, sid);
            ps.setInt(3, lid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Course(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("getCourseById: " + e.getMessage());
        }
        return null;
    }
}
