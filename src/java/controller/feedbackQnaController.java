/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CourseDAO;
import DAO.FeedbackDAO;
import DAO.QnaDAO;
import model.feedback;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Course;
import model.Lecture;
import model.Student;
import model.qna;

/**
 *
 * @author jiggnguyen
 */
public class feedbackQnaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addFeedback</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addFeedback at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("isStudent")) {
            Student s = (Student) session.getAttribute("user");
            QnaDAO ad = new QnaDAO();
            FeedbackDAO fd = new FeedbackDAO();
            CourseDAO cd = new CourseDAO();
            Course c = cd.getCourseById(courseId, s.getStudentId(), uid);
            List<feedback> listFeedback = fd.getFeedback(uid, courseId);
            List<qna> list = ad.getQna(s.getStudentId(), uid);
            request.setAttribute("c", c);
            request.setAttribute("listQna", list);
            request.setAttribute("listFeedback", listFeedback);
            request.getRequestDispatcher("showFeedback.jsp").forward(request, response);
        } else {
            Lecture s = (Lecture) session.getAttribute("user");
            QnaDAO ad = new QnaDAO();
            FeedbackDAO fd = new FeedbackDAO();
            CourseDAO cd = new CourseDAO();
            Course c = cd.getCourseById(courseId, uid, s.getLectureId());
            List<feedback> listFeedback = fd.getFeedback(s.getLectureId(), courseId);
            List<qna> list = ad.getQna(uid, s.getLectureId());
            request.setAttribute("c", c);
            request.setAttribute("listQna", list);
            request.setAttribute("listFeedback", listFeedback);
            request.getRequestDispatcher("showFeedback.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        String student_id = request.getParameter("student_id");
        String student_email = request.getParameter("student_email");
        String lecture_id = request.getParameter("lecture_id");
        String lecture_email = request.getParameter("lecture_email");
        String course_id = request.getParameter("course_id");

        LocalDate ld = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        Date d = Date.valueOf(dtf.format(ld));

//        feedback f = new feedback(id, content, d, student_id, student_email, lecture_id, lecture_email, course_id);

        if (request.getParameter("Add") != null) {
            //add vao database

            request.getRequestDispatcher("listFeedback.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
