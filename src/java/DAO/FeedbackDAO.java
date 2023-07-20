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
import model.feedback;

/**
 *
 * @author dmngh
 */
public class FeedbackDAO extends DatabaseConnect {

    public List<feedback> getFeedback(int lid, int cid) {
        List<feedback> list = new ArrayList<>();
        try {
            String sql = "SELECT f.* FROM feedback f\n"
                    + "WHERE lecture_id = ? and course_id = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, lid);
            ps.setInt(2, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new feedback(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(6), rs.getInt(8)));
            }
        } catch (SQLException e) {
            System.out.println("getFeedbackByStudent: " + e.getMessage());
        }
        return list;
    }

    public void insert(feedback f) {
        try {
            String sql = "INSERT INTO feedback(content, date, student_id, lecture_id, course_id) VAlUES\n"
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, f.getContent());
            ps.setDate(2, f.getDate());
            ps.setInt(3, f.getStudentId());
            ps.setInt(4, f.getLectureId());
            ps.setInt(5, f.getCourseId());
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println("insert: " + e.getMessage());
        }
    }

}
