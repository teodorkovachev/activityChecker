/**
 * 
 */
package bg.kovachev.activityChecker.usr;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Satellite
 *
 */
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
	}

	@Override
	public List<User> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("from User").list();
        return personsList;
	}

	@Override
	public User getUserById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, id);
		return p;
	}

	@Override
	public void removeUser(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, id);
		if (null != p) {
			session.delete(p);
		}
	}

}
