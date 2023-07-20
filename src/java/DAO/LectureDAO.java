/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Lecture;

/**
 *
 * @author dmngh
 */
public class LectureDAO extends DatabaseConnect{
    public Lecture getLecture(String lEmail, String lPassword) {
        try {
            String strSelect = "select * from lecture "
                    + "where lecture_email=? "
                    + "and lecture_password=? ";
            PreparedStatement ps = cnn.prepareStatement(strSelect);
            ps.setString(1, lEmail);
            ps.setString(2, lPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("getLecture" + e.getMessage());
        }
        return null;
    }
}
