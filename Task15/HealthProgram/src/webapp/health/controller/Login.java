package webapp.health.controller;



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

import webapp.health.dao.UserDAO;
import webapp.health.databean.User;
import webapp.health.formbean.LoginForm;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public void init() throws ServletException {
		String jdbcDriverName = "com.mysql.jdbc.Driver";
		String jdbcURL = "jdbc:mysql:///test?useSSL=false";
		try {
			ConnectionPool cp = new ConnectionPool(jdbcDriverName, jdbcURL);
			userDAO = new UserDAO(cp, "user");
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			response.sendRedirect("homepage.jsp");
			return;
		}
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			LoginForm form = new LoginForm(request);
			request.setAttribute("form", form);
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				RequestDispatcher d = request.getRequestDispatcher("login.jsp");
				d.forward(request, response);
				return;
			}
			if (form.getButton().equals("Login")) {
				User user = userDAO.read(form.getEmail());
				if (user == null) {
					errors.add("No such user");
					RequestDispatcher d = request.getRequestDispatcher("login.jsp");
					d.forward(request, response);
					return;
				}
				if (!form.getPassword().equals(user.getPassword())) {
					errors.add("Incorrect password");
					RequestDispatcher d = request.getRequestDispatcher("login.jsp");
					d.forward(request, response);
					return;
				}
				session.setAttribute("user", user);
				RequestDispatcher d = request.getRequestDispatcher("homepage.jsp");
				d.forward(request, response);
				//response.sendRedirect("homepage.jsp");
			}
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			RequestDispatcher d = request.getRequestDispatcher("error.jsp");
			d.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
