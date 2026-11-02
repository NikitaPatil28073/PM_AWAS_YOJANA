package Awas_Yojana;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DLogin
 */
public class DLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DLogin() {
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
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(uname);
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from adddealer where email=? and pass=?");
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			System.out.println(pass);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("DaddBillLogin.html");
				System.out.println(pass);
			}
			else
			{
				response.sendRedirect("DLogin.html");
				System.out.println(uname);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
