package servlets;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		boolean result = dao.deleteRecord(id);
		HttpSession session = req.getSession();
		if(result) {
			session.setAttribute("success", "Data Deleted Successfully");
			resp.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("error", "Something Went Wrong");
			resp.sendRedirect("index.jsp");
		}
		
	}

	
	
}
