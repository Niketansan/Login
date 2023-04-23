package Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bye")
public class LoginServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
          
		String n=request.getParameter("username");  
		String p=request.getParameter("userpassword");  
          
		if(MysqlLog.validate(n, p)){  
			
			out.println("Welcome   "+n);
		}  
		else{  
			out.print("Sorry username or password error");  
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
			rd.include(request,response);  
		}  
          
	    
	     
		
		
	}  
}  