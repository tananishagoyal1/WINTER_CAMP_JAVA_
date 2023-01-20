package first;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class servelt1
 */
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		user u=new user();
			//HttpSession session=request.getSession();
		HttpSession session =request.getSession();
		
		
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			
			if(name.equalsIgnoreCase("NISHU" ) && password.contentEquals("123")) {
				u.setName(name);
				session.setAttribute("user", u);
				u.setName(password);
				session.setAttribute("user", u);
				RequestDispatcher rd = request.getRequestDispatcher("servlet2");
		    	  rd.include(request, response);
		      }
		      else {
		    	  //response.sendRedirect("index.html");
		    	  RequestDispatcher rd = request.getRequestDispatcher("login.html");
		    	  rd.include(request, response);
		    	  out.println("<br><br><br>");
		    	  out.println("<center>INVALID LOGIN CREDENTIALS!!</center>");
		    	  
		      }
	}


}
