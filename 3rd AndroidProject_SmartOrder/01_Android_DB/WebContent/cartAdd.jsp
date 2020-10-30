<%@ page import="db.beans.*, java.sql.*, java.util.*, java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty name="QueryBean" property="*"/>

<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("UTF-8");
	
	String shop=request.getParameter("shop") ==null? "" : request.getParameter("shop").trim();

	String ordernum=request.getParameter("ordernum") ==null? "" : request.getParameter("ordernum").trim();
	String type=request.getParameter("type") ==null? "" : request.getParameter("type").trim();
	String menu=request.getParameter("menu") ==null? "" : request.getParameter("menu").trim();
	String cost=request.getParameter("cost") ==null? "" : request.getParameter("cost").trim();
	String count=request.getParameter("count") ==null? "" : request.getParameter("count").trim();
	String total=request.getParameter("total") ==null? "" : request.getParameter("total").trim(); 
	String temp = request.getParameter("temp") == null?"":request.getParameter("temp").trim();
	
	QueryBean.getConnection();
	
	int res=0;
	
	try{
		res=QueryBean.addCart(shop, ordernum, type, menu, cost, count, total, temp);
	}catch(Exception e){
		out.print(e.toString());
	}finally{
		QueryBean.closeConnection();
	}

	out.print("[");
	out.print("{ ");
	out.print("\"RESULT_OK\": \"" + res + "\" ");
	out.print("} ");
	out.print("]");
	
	System.out.println("res: "+ res);


%>