package webapp.health.dao;

import java.util.ArrayList;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;

import webapp.health.databean.EnrolledUser;

public class EnrolledUserDAO extends GenericDAO<EnrolledUser> {
	public EnrolledUserDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(EnrolledUser.class, tableName, cp);
	}
    public ArrayList<EnrolledUser> getUser() throws RollbackException {
    	EnrolledUser[] enrolledUsers = match();
		ArrayList<EnrolledUser> userArray = new ArrayList<EnrolledUser>();
		for (int i = 0; i < enrolledUsers.length; i++) {
			userArray.add(enrolledUsers[i]);
		}
	return userArray;
    }
}