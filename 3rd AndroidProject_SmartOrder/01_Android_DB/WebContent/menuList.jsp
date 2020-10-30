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
	
	String strType = request.getParameter("type")==null?"cafein":request.getParameter("type").trim();
	
	try{
		resArr = QueryBean.menuList(strType);	
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
			out.print("\"MENU\": \"" + (String)resArr.get(0)+"\", ");
			out.print("\"TYPE\": \"" + (String)resArr.get(1)+"\", ");
			out.print("\"COST\": \"" + (String)resArr.get(2)+"\", ");
			out.print("\"PICTURE\": \"" + "http://10.100.206.47:8888/01_Android_DB/upload/"+(String)resArr.get(3)+"\" ");
			out.print("} ");
			
			for(int i=4; i<resArr.size(); i+=4){ //컬럼이 3개
				out.print(",");
				out.print("{ ");
				out.print("\"MENU\": \"" + (String)resArr.get(i)+"\", ");
				out.print("\"TYPE\": \"" + (String)resArr.get(i+1)+"\", ");
				out.print("\"COST\": \"" + (String)resArr.get(i+2)+"\", ");
				out.print("\"PICTURE\": \"" + "http://10.100.206.47:8888/01_Android_DB/upload/"+(String)resArr.get(i+3)+"\" ");
				out.print("} ");
			}
			
			out.println("]");
			out.println("}");
		}
	

%>