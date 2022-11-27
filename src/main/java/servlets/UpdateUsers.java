package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.StudentDao;
import entity.Student;

/**
 * Servlet implementation class UpdateUsers
 */
public class UpdateUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		int id =  Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		Student stu = new Student(id, name, email, password, gender);
		
		boolean result = dao.updateRecord(stu);
		
		HttpSession session = req.getSession();
		if(result) {
			session.setAttribute("success", "Data Updated Successfully");
			res.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("error", "Something Went Wrong");
			res.sendRedirect("index.jsp");
		}
		
}

}
