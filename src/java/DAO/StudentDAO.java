/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Student;

/**
 *
 * @author dmngh
 */
public class StudentDAO extends DatabaseConnect {

    public Student getStudent(String sEmail, String sPassword) {
        try {
            String strSelect = "select * from student "
                    + "where student_email=? "
                    + "and student_password=? ";
            PreparedStatement ps = cnn.prepareStatement(strSelect);
            ps.setString(1, sEmail);
            ps.setString(2, sPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("getStudent" + e.getMessage());
        }
        return null;
    }

    public String getNameByEmail(String email) {
        try {
            String strSelect = "select * from student "
                    + "where student_email=? ";

            PreparedStatement ps = cnn.prepareStatement(strSelect);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(4);
                return name;
            }
        } catch (Exception e) {
            System.out.println("checkNameByEmailStudent" + e.getMessage());
        }
        return "";
    }
}
