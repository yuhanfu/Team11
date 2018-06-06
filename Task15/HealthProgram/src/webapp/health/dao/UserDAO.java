package webapp.health.dao;

import java.util.ArrayList;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;

import webapp.health.databean.User;

public class UserDAO extends GenericDAO<User> {
	public UserDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(User.class, tableName, cp);
	}
    public ArrayList<User> getUser() throws RollbackException {
		User[] users = match();
		ArrayList<User> userArray = new ArrayList<User>();
		for (int i = 0; i < users.length; i++) {
			userArray.add(users[i]);
		}
	return userArray;
    }
}