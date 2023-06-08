package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test1")
//wc reads this only once @web app deployment time 
//WC creates map and then  populates URL map
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("indoget by:"+Thread.currentThread());
		//set response content type (aetting resp header content-type:text/html)
		resp.setContentType("text/html");
		//get printwriter to send char,buf data(resp) to client
		try(PrintWriter pw=resp.getWriter()){
			pw.print("<h3>welcome to servlet:"+getClass()+"Ts"+LocalDate.now()+"</h3>");
		}//wc:pw,flush()-->buf contents are sent-->pw.close
	}

	@Override
	public void destroy() {
		
		System.out.println("in destroy by:"+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
	
		System.out.println("in init by:"+Thread.currentThread());
	}
	

}
