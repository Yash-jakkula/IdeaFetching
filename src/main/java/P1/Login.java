package P1;

import java.io.IOException;
import java.sql.Statement;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("driver loaded");
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","Yash@7640");
		    System.out.println("connection established");
		    String userId = request.getParameter("username");
		    String password = request.getParameter("password");
		    Statement st  = conn.createStatement();
		    String query = "select * from user where userid = '"+userId+"' and password = '"+password+"' ";
		    ResultSet res = st.executeQuery(query);		    
		    
		    if(res.next()){
			    response.sendRedirect("IdeasFile.html");
		    }
		    else {
		    	out.println("Please enter valid details");
		    	response.sendRedirect("Login.html");	
		    }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}

}
