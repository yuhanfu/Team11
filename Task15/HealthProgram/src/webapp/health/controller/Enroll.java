package webapp.health.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;

import webapp.health.dao.EnrolledUserDAO;
import webapp.health.databean.EnrolledUser;
import webapp.health.formbean.EnrollForm;

@WebServlet("/Enroll")
public class Enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnrolledUserDAO EnrolledUserDAO;

	public void init() throws ServletException {
		String jdbcDriverName = "com.mysql.jdbc.Driver";
		String jdbcURL = "jdbc:mysql:///test?useSSL=false";
		try {
			ConnectionPool cp = new ConnectionPool(jdbcDriverName, jdbcURL);
			EnrolledUserDAO = new EnrolledUserDAO(cp, "EnrolledCustomer");
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			RequestDispatcher d = request.getRequestDispatcher("login.jsp");
			d.forward(request, response);
			return;
		}
	
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try {
			EnrollForm form = new EnrollForm(request);
			request.setAttribute("form", form);
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				RequestDispatcher d = request.getRequestDispatcher("Enroll.jsp");
				d.forward(request, response);
				return;
			}
			if (form.getButton().equals("enroll")) {
				if (EnrolledUserDAO.read(form.getEmail()) == null) {
		    			EnrolledUser user = new EnrolledUser();
					user.setEmail(form.getEmail());
					user.setFirstName(form.getFirstName());
					user.setLastName(form.getLastName());
					user.setAddress(form.getAddress());
					user.setPhoneNumber(form.getPhoneNumber());
					try {
						EnrolledUserDAO.create(user);
						session.setAttribute("EnrolledUser", user);
						System.out.println("SUCCESS");
						return;
					} catch (DuplicateKeyException e) {
	                    return;
					}
				}
			}
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			RequestDispatcher d = request.getRequestDispatcher("error.jsp");
			d.forward(request, response);
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
