package webapp.health.controller;

import java.io.IOException;

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

import blog.databean.User;
import webapp.health.dao.EnrolledUserDAO;
import webapp.health.dao.UserDAO;
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
		EnrollForm form = new EnrollForm(request);
		
        if (form.getValidationErrors()) {
            return "Register.jsp";
        }
	    if (userDAO.read(form.getEmail()) == null) {
    			User user = new User();
		user.setEmail(form.getEmail());
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setPassword(form.getPassword());
		try {
			userDAO.create(user);
			session.setAttribute("user", user);
			System.out.println("SUCCESS");
			return ("home.do");
		} catch (DuplicateKeyException e) {
            form.addFieldError("userName", "A user with this name already exists");
            return "Register.jsp";
		}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
