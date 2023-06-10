package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/login",loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao;

	public void init() throws ServletException {
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("err occured in init" + getClass(), e);
		}

	}

	public void destroy() {
		try {
			userDao.claenUp();
		} catch (SQLException e) {
			System.out.println("Err occured in destroy"+getClass()+" "+e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//set resp content type
		response.setContentType("text/html");
		//get pw
		try(PrintWriter pw=response.getWriter()){
			String email=request.getParameter("em");
			String pwd=request.getParameter("pass");
			System.out.println(email+pwd);
			User user=userDao.authenticateUser(email, pwd);
			if(user==null) {
				pw.print("<h4>Invalid Email and password,please<a href='login.html'>retry</h4>");
				
			}
			else {
				Cookie c1=new Cookie("user-details", user.toString());
				response.addCookie(c1);
				pw.write("<h4>validate user details "+ user+" </h4>");
				if(user.getRole().equals("admin")) {
					response.sendRedirect("admin_page");
					
				}else  {
					if(user.isStatus()) {
						response.sendRedirect("logout");
						
					}else {
						response.sendRedirect("candidate_list");
					}
				}
				
			}
			
		} catch (SQLException e) {
		throw new ServletException("error occured in doget"+getClass(),e);
		}
	}

}
