package Awas_Yojana;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAwas
 */
public class AddAwas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAwas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Connection con = DbConnection.connect();
		String id = request.getParameter("Id");
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
	    String cno = request.getParameter("contact");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String location = request.getParameter("location");
		String region = request.getParameter("region");
		
		try {
			PreparedStatement stmt = con.prepareStatement("insert into addawas values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, id);
			stmt.setString(2, uname);
			stmt.setString(3, pass);
			stmt.setString(4, cno);
			stmt.setString(5, email);
			stmt.setString(6, city);
			stmt.setString(7, location);
			stmt.setString(8, region);

			
			int i=stmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("message.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
