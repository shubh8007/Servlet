package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;


@WebServlet(value="/Register",loadOnStartup=1)
public class NewRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private UserDaoImpl userDao; 
      
      public void init(ServletConfig config) throws ServletException {
  		
  		try {
  			userDao=new UserDaoImpl();
  			
  		} catch (SQLException e) {
  			
  			throw new ServletException("error in init"+getClass(),e);
  		}
  	}
      public void destroy() {
 	     
  		try {
  			userDao.claenUp();
  		} catch (SQLException e) {
  			
  			System.out.println("err in destroy of " + getClass() + " " + e);
  		}
  	}
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 response.setContentType("text/html");
                 
                 try(PrintWriter pw=response.getWriter()){
                	 String fname=request.getParameter("fname");
                	 String lname=request.getParameter("lname");
                	 String email=request.getParameter("email");
                	 String pass=request.getParameter("pass");
                	 String dob=request.getParameter("dob");
          //System.out.println(fname+lname+email+pass+ dob);
                	
//					userDao.registerUser(fname, lname, email, pass, dob);
                	 userDao.registerUser(fname, lname, email, pass, dob);
					pw.print("success");
					
					
					
					
				
                	 
                	 
                 }catch (SQLException e) {
 					throw new ServletException("Error Occured"+getClass(),e);
 				}
                 	 
	}

}
