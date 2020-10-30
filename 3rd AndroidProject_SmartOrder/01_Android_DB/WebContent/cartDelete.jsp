<%@ page import="db.beans.*, java.sql.*, java.util.*, java.io.*" %>
<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty name="QueryBean" property="*"/>

<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("UTF-8");
	
	//String strONum = request.getParameter("ordernum") ==null? "" : request.getParameter("ordernum").trim();
	int num = Integer.parseInt(request.getParameter("num"));
	
	//System.out.println("삭제할 ordernum "+ strONum);
	System.out.print("num"+num);
	
	QueryBean.getConnection();
	
	int res = 0;
	
	try{
		res = QueryBean.deleteCart(num);
	}catch(Exception e){
		out.print(e.toString());
	} finally{
		QueryBean.closeConnection();
	}
	
	out.print("[");
	out.print("{ ");
	out.print("\"RESULT_OK\": \"" + res + "\" ");
	out.print("} ");
	out.print("]");
	
	System.out.println("res: "+ res);
	
	%>