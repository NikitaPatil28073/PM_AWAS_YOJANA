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
 * Servlet implementation class AddInfoBill
 */
public class AddInfoBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoBill() {
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
		
		int billid = Integer.parseInt(request.getParameter("billid"));
		String aid = request.getParameter("aid");
		String acontact = request.getParameter("acontact");
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into addbill values (?,?,?)");
			ps.setInt(1, billid);
			ps.setString(2, aid);
			ps.setString(3, acontact);
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("message.html");
			}
			else
			{
				response.sendRedirect("AddBill.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
