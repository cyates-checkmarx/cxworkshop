import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;

public class Vulns {

	private boolean loggedIn = false;
	private Result result;
	private HttpServletResponse response;
	private HttpServletRequest req;

	// SQLi vulnerability
	public static void input (DataSource pool) {
		String email = request.getParameter ("email");
		String password = request.getParameter ("password");

		String sql = "select * from users where (email ='" + email + "' and password'" + password + "')";

		Connection connection = pool.getConnection();
		Statement statement = connection.createStatement();
		result = statement.executeQuery(sql);

		if (result.next()) {
			loggedIn = true;
			doGet(result,req,response);
		} else {
			out.println("No results");
		}
	}

	// XSS vulnerability	
	protected void doGet(Result res, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    		response.setContentType("text/html;charset=UTF-8");
      
  		PrintWriter out = response.getWriter();
  		String loc = request.getParameter("location");
		loc+=res.getString("GEO_LOC");
  
  		out.println("<h1> Location: " + loc + "<h1>");
	}
}
