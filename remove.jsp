<%@page import="Awas_Yojana.DbConnection" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <div class="container">  
     
  <%
  try{
	   Connection con=DbConnection.connect();
	   String aid = request.getParameter("id");
	   PreparedStatement ps2=con.prepareStatement("delete from adddealer where id=?");
	   ps2.setString(1, aid);
	   int i = ps2.executeUpdate();
	  if(i>0)
	  {
		  
         response.sendRedirect("Ddelete.jsp");
         System.out.println(aid);
       }
	 }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
    
  %>
  
</table>







        </div>   
</body>
</html>