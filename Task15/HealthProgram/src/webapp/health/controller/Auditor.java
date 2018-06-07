package webapp.health.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

import webapp.health.dao.EnrolledUserDAO;
import webapp.health.databean.EnrolledUser;

@WebServlet("/Auditor")
public class Auditor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnrolledUserDAO enrolledUserDAO;

	public void init() throws ServletException {
		String jdbcDriverName = "com.mysql.jdbc.Driver";
		String jdbcURL = "jdbc:mysql:///test?useSSL=false";
		try {
			ConnectionPool cp = new ConnectionPool(jdbcDriverName, jdbcURL);
			enrolledUserDAO = new EnrolledUserDAO(cp, "enrolled_customer");
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ArrayList<EnrolledUser> enrolledUsers = enrolledUserDAO.getUser();
			session.setAttribute("enrolledUsers", enrolledUsers);
		} catch (RollbackException e) {
			e.printStackTrace();
		}
		RequestDispatcher d = request.getRequestDispatcher("auditor.jsp");
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
