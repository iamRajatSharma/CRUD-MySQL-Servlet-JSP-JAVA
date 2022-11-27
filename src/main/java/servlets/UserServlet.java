package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import dao.StudentDao;
import entity.Student;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/saveUser")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		
		
		Student stu = new Student(name, email, password, gender);
		StudentDao dao = new StudentDao();
		boolean resp = dao.insertInDatabase(stu);
		
		HttpSession session = req.getSession();
		if(resp) {
			session.setAttribute("success", "Data Saved Successfully");
			res.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("error", "Something Went Wrong");
			res.sendRedirect("index.jsp");
		}
	}

}
