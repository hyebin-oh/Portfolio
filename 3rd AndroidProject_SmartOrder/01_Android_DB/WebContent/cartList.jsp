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
	
	String strOnum = request.getParameter("ordernum")==null?"":request.getParameter("ordernum").trim();;
	
	try{
		resArr = QueryBean.cartList(strOnum);	
	}catch(SQLException e){
		out.print(e.toString());
	}finally{
		QueryBean.closeConnection();
	}
	
	//json형식의 값 전달 시작
		out.println("{");
		out.println("\"datas\":[");
		
		if(resArr.size()==0){ //db값이 없을 경우 json 끝맺음
			out.println("]");
			out.println("}");
			
		}else{ //db값이 존재할경우 컬럼값 표시
			out.print("{ ");
			out.print("\"NUM\": \"" + (Integer)resArr.get(0)+"\", ");
			out.print("\"SHOP\": \"" + (String)resArr.get(1)+"\", ");
			out.print("\"ORDERNUM\": \"" + (String)resArr.get(2)+"\", ");
			out.print("\"TYPE\": \"" + (String)resArr.get(3)+"\", ");
			out.print("\"MENU\": \"" + (String)resArr.get(4)+"\", ");
			out.print("\"COUNT\": \"" + (Integer)resArr.get(5)+"\", ");
			out.print("\"TOTAL\": \"" + (Integer)resArr.get(6)+"\", ");
			out.print("\"TEMP\": \"" + (String)resArr.get(7)+"\" ");
			out.print("} ");
			
			for(int i=8; i<resArr.size(); i+=8){ //컬럼이 4개
				out.print(",");
				out.print("{ ");
				out.print("\"NUM\": \"" + (Integer)resArr.get(i)+"\", ");
				out.print("\"SHOP\": \"" + (String)resArr.get(i+1)+"\", ");
				out.print("\"ORDERNUM\": \"" + (String)resArr.get(i+2)+"\", ");
				out.print("\"TYPE\": \"" + (String)resArr.get(i+3)+"\", ");
				out.print("\"MENU\": \"" + (String)resArr.get(i+4)+"\", ");
				out.print("\"COUNT\": \"" + (Integer)resArr.get(i+5)+"\", ");
				out.print("\"TOTAL\": \"" + (Integer)resArr.get(i+6)+"\", ");
				out.print("\"TEMP\": \"" + (String)resArr.get(i+7)+"\" ");
				out.print("} ");
			}
			out.println("]");
			out.println("}");
		}

	
%>