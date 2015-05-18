/**
 * 
 */
package bg.kovachev.activityChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/**
 * @author Satellite
 *
 */
public class AuthorizationController extends AbstractController {

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String password = request.getParameter("password");
		System.out.println(password);
		
		return new ModelAndView("Login");
	}
}
