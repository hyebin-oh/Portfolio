<%@ page import="db.beans.*, java.sql.*, java.util.*, java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty name="QueryBean" property="*"/>

<%

	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("UTF-8");
	
	QueryBean.getConnection();
	
	ArrayList resArr = new ArrayList();
	
	String strMenu = request.getParameter("MENU")==null?"":request.getParameter("MENU").trim();
	
	try{
		resArr = QueryBean.menuView(strMenu);	
	}catch(SQLException e){
		out.print(e.toString());
	}finally{
		QueryBean.closeConnection();
	}
	
	//json형식의 값 전달 시작

			out.print("{ ");
			out.print("\"MENU\": \"" + (String)resArr.get(0)+"\", ");
			out.print("\"TYPE\": \"" + (String)resArr.get(1)+"\", ");
			out.print("\"COST\": \"" + (String)resArr.get(2)+"\", ");
			out.print("\"PICTURE\": \"" + "http://10.100.206.47:8888/01_Android_DB/upload/"+(String)resArr.get(3)+"\" ");
			out.print("} ");
			


	

%>