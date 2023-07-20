/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CourseDAO;
import DAO.FeedbackDAO;
import DAO.QnaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import model.Course;
import model.Lecture;
import model.Student;
import model.feedback;
import model.qna;

/**
 *
 * @author dmngh
 */
public class qnaController extends HttpServlet {

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
            out.println("<title>Servlet qnaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet qnaController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("isStudent")) {
            Student s = (Student) session.getAttribute("user");
            QnaDAO qd = new QnaDAO();
            int cid = Integer.parseInt(request.getParameter("id"));
            int uid = Integer.parseInt(request.getParameter("uid"));
            List<qna> list = qd.getQna(s.getStudentId(), uid);
            request.setAttribute("listQna", list);
            request.getRequestDispatcher("showQnaStudent.jsp").forward(request, response);
        } else {
//            QnaDAO qd = new QnaDAO();
//            Lecture s = (Lecture) session.getAttribute("user");
//            int cid = Integer.parseInt(request.getParameter("cid"));
//            int uid = Integer.parseInt(request.getParameter("uid"));
//            String answer = request.getParameter("text");
//            int qid = Integer.parseInt(request.getParameter("qnaId"));
//            if (answer != null && !answer.isEmpty()) {
//                qd.answer(answer, qid);
//                response.sendRedirect("feedbackQna?id=" + cid + "&uid=" + uid);
//            }

            QnaDAO qd = new QnaDAO();
            Lecture s = (Lecture) session.getAttribute("user");
            int cid = Integer.parseInt(request.getParameter("id"));
            List<qna> list = qd.getQnaByLecture(cid, s.getLectureId());
            request.setAttribute("listQna", list);
            request.getRequestDispatcher("showQnaLecture.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        LocalDate ld = LocalDate.now();
        Date date = Date.valueOf(ld);
        if ((boolean) session.getAttribute("isStudent")) {
            QnaDAO qd = new QnaDAO();
            Student s = (Student) session.getAttribute("user");
            int cid = Integer.parseInt(request.getParameter("cid"));
            int uid = Integer.parseInt(request.getParameter("uid"));
            String question = request.getParameter("text");
            qna q = new qna(question, date, s.getStudentId(), uid, cid);
            qd.insert(q);
            List<qna> list = qd.getQna(s.getStudentId(), uid);
            request.setAttribute("listQna", list);
            request.getRequestDispatcher("showQnaStudent.jsp").forward(request, response);
        } else {
            QnaDAO qd = new QnaDAO();
            Lecture s = (Lecture) session.getAttribute("user");
            int cid = Integer.parseInt(request.getParameter("cid"));
            int uid = Integer.parseInt(request.getParameter("uid"));
            String answer = request.getParameter("text");
            int qid = Integer.parseInt(request.getParameter("qnaId"));
            if (answer != null && !answer.isEmpty()) {
                qd.answer(answer, qid);
                List<qna> list = qd.getQnaByLecture(cid, s.getLectureId());
                request.setAttribute("listQna", list);
                request.getRequestDispatcher("showQnaLecture.jsp").forward(request, response);
            }
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
