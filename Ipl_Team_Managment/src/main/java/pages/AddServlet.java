package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.PlayerDaoImpl;
import pojo.Player;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(value="/addplayer",loadOnStartup = 1)
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ;
       private PlayerDaoImpl playerdao;
    
	public void init(ServletConfig config) throws ServletException {
		try {
			
		playerdao=new PlayerDaoImpl();
		
		}catch (Exception e) {
		throw new ServletException("error occured"+getClass(),e);
		}
	}

	public void destroy() {
		try {
			playerdao.cleanUp();
		} catch (SQLException e) {
			System.out.println("error occured in destroy"+getClass());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String playername=request.getParameter("name");
			String date=request.getParameter("dob");
			Date d=Date.valueOf(date);
			double batting_avg=Double.parseDouble(request.getParameter("bavg"));
			int wicket=Integer.parseInt(request.getParameter("wc"));
		Player play = playerdao.authenticatePlayer(playername, date, wicket, batting_avg, wicket);
		
			HttpSession hs=request.getSession();
			hs.setAttribute("Player-Details",play );
			hs.setAttribute("player-dao", playerdao);
			
			if(play.getPlayername().equalsIgnoreCase("Mi")) {
				response.sendRedirect("MiServlet");
			}
			
		} catch (SQLException e) {
			throw new ServletException("err in do-get " + getClass(), e);
		}
		
		
		
	}

}
