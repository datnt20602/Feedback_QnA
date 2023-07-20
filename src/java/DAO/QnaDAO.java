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
import model.qna;

/**
 *
 * @author dmngh
 */
public class QnaDAO extends DatabaseConnect {

    public List<qna> getQna(int sid, int lid) {

        List<qna> list = new ArrayList<>();
        try {
            String sql = "SELECT q.id, q.question, q.answer, q.date, s.student_id, l.lecture_id, q.course_id, s.name, l.name FROM qna q\n"
                    + "LEFT JOIN student s ON s.student_id = q.student_id\n"
                    + "LEFT JOIN lecture l ON l.lecture_id = q.lecture_id\n"
                    + "WHERE s.student_id = ? AND l.lecture_id = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.setInt(2, lid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new qna(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
            }
        } catch (SQLException e) {
            System.out.println("getQna: " + e.getMessage());
        }
        return list;
    }

    public List<qna> getQnaByLecture(int cid, int lid) {
        List<qna> list = new ArrayList<>();
        try {
            String sql = "SELECT q.id, q.question, q.answer, q.date, s.student_id, l.lecture_id, q.course_id, s.name, l.name FROM qna q\n"
                    + "LEFT JOIN student s ON s.student_id = q.student_id\n"
                    + "LEFT JOIN lecture l ON l.lecture_id = q.lecture_id\n"
                    + "WHERE l.course_id = ? AND l.lecture_id = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setInt(2, lid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new qna(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
            }
        } catch (SQLException e) {
            System.out.println("getQna: " + e.getMessage());
        }
        return list;
    }

    public void insert(qna q) {
        try {
            String sql = "INSERT INTO qna(question, [date], student_id, lecture_id, course_id) VALUES\n"
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, q.getQuestion());
            ps.setDate(2, q.getDate());
            ps.setInt(3, q.getStudentId());
            ps.setInt(4, q.getLectureId());
            ps.setInt(5, q.getCourseId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert: " + e.getMessage());
        }
    }

    public void answer(String answer, int qid) {
        try {
            String sql = "UPDATE qna SET answer = ? WHERE id = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, answer);
            ps.setInt(2, qid);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("answer: " + e.getMessage());
        }
    }
}
