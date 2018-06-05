package webapp.health.databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("email")
public class User {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String healthMembership;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String s) {
		email = s;
	}

	public void setPassword(String s) {
		password = s;
	}

	public void setFirstName(String s) {
		firstName = s;
	}

	public void setLastName(String s) {
		lastName = s;
	}

	public String getHealthMembership() {
		return healthMembership;
	}

	public void setHealthMembership(String healthMembership) {
		this.healthMembership = healthMembership;
	}

}
