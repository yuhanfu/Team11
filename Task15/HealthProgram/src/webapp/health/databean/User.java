package webapp.health.databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("email")
public class User {
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String s) {
		email = s;
	}

	public void setPassword(String s) {
		password = s;
	}
}
