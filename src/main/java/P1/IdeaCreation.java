package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdeaCreation
 */
@WebServlet("/IdeaCreation")
public class IdeaCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdeaCreation() {
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
		    String idea = request.getParameter("idea");
		    // System.out.println(userId+""+password+""+confirmPass+""+name);
		    Statement st  = conn.createStatement();
		    String query = "insert into ideas values ('"+idea+"')";
		    boolean s = st.execute(query);
		    if(s == false) {
		    response.sendRedirect("IdeaPage.html");
		    }
		    else {
		    response.sendRedirect("IdeaFile.html");
		    }
		    }
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
