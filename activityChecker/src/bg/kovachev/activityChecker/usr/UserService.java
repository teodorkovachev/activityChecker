/**
 * 
 */
package bg.kovachev.activityChecker.usr;

import java.util.List;

/**
 * @author Satellite
 *
 */
public interface UserService {
	public void addUser(User p);

	public void updateUser(User p);

	public List<User> listPersons();

	public User getUserById(String id);

	public void removeUser(String id);
}
