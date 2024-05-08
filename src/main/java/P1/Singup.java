package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Singup
 */
@WebServlet("/Singup")
public class Singup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Singup() {
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
		    String confirmPass = request.getParameter("confirmPassword");
		    String name = request.getParameter("name");
		    // System.out.println(userId+""+password+""+confirmPass+""+name);
		    Statement st  = conn.createStatement();
		    String query = "insert into user values ('"+userId+"','"+password+"','"+name+"')";

		    boolean s = st.execute(query);
		    out.println(s);
		    response.sendRedirect("Login.html");
		    	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
