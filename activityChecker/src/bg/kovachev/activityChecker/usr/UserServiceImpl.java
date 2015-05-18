/**
 * 
 */
package bg.kovachev.activityChecker.usr;

import java.util.List;

/**
 * @author Satellite
 *
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(User p) {
		userDAO.addUser(p);
	}

	@Override
	public void updateUser(User p) {
		userDAO.updateUser(p);
	}

	@Override
	public List<User> listPersons() {
		return userDAO.listPersons();
	}

	@Override
	public User getUserById(String id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void removeUser(String id) {
		userDAO.removeUser(id);
	}
}
