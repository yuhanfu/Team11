package webapp.health.formbean;

import javax.servlet.http.HttpServletRequest;

public class EnrollForm {
	private String firstName;
	private String lastName;
	private String policy;
	private String button;

	public EnrollForm(HttpServletRequest request) {
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		policy = request.getParameter("policy");
		button = request.getParameter("button");
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPolicy() {
		return policy;
	}

	public String getButton() {
		return button;
	}


}
