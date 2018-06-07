package webapp.health.formbean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class EnrollForm {
	private String email;
	private String address;
	private String PhoneNumber;
	private String firstName;
	private String lastName;
	private String button;

	public EnrollForm(HttpServletRequest request) {
		email = request.getParameter("email");
		address = request.getParameter("address");
		PhoneNumber = request.getParameter("phoneNumber");
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		button = request.getParameter("button");
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getButton() {
		return button;
	}
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (email == null || email.length() == 0)
			errors.add("Email address is required");
		if (!email.matches(".*[@].*[\\.].*"))
			errors.add("Invalid email");
		if (button == null)
			errors.add("Button is required");
		if (errors.size() > 0)
			return errors;
		return errors;
	}
}
