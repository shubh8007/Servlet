package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CandidateListServlet
 */
@WebServlet(value="/candidate_list",loadOnStartup=1)
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	try(PrintWriter pw=response.getWriter()){
		pw.write("<h4>in candidate list</>");
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
		for(Cookie c:cookies) {
			if(c.getName().equals("user-details")) {
				pw.print("<h5>valid user:"+c.getValue()+"</h5>");
				break;
				
			}
		}
	}
		else{
			pw.print("<h5>Session tracking failed,no cookies</h5>");
			}
		}
	}

}
