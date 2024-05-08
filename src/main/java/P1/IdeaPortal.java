package P1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdeaPortal
 */
@WebServlet("/IdeaPortal")
public class IdeaPortal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdeaPortal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("driver loaded");
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","Yash@7640");
		    System.out.println("connection established");
		    Statement st = conn.createStatement();
		    String query = "select * from ideas";
		    ResultSet res = st.executeQuery(query);
		    StringBuilder resultTextArea = new StringBuilder();
		    while (res.next()) {
		        resultTextArea.append(res.getString(1)).append("\n"); // Assuming the first column contains the data you want to display
		    }
		    

		    
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title>Display Value</title>");
	        out.println("<style>");
	        out.println("body {");
	        out.println("    font-family: Arial, sans-serif;");
	        out.println("    background-color: #f4f4f4;");
	        out.println("}");
	        out.println("h2 {");
	        out.println("    color: #007bff;");
	        out.println("}");
	        out.println("textarea {");
	        out.println("    width: 80%;");
	        out.println("    height: 300px;");
	        out.println("    margin: 20px;");
	        out.println("    padding: 10px;");
	        out.println("    border: 1px solid #ccc;");
	        out.println("    border-radius: 4px;");
	        out.println("    resize: none;");
	        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h2>Display Value</h2>");
	        out.println("<textarea readonly>" + resultTextArea.toString() + "</textarea>");
	        out.println("</body>");
	        out.println("</html>");

	        out.close();
		}
		catch(Exception e) {
			out.println(e);
		}
		}

}
