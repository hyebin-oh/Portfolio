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
	
	String strShop = request.getParameter("name")==null?"":request.getParameter("name").trim();
	
	try{
		resArr = QueryBean.shopList(strShop);	
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
			out.print("\"NAME\": \"" + (String)resArr.get(1)+"\", ");
			out.print("\"TEL\": \"" + (String)resArr.get(2)+"\", ");
			out.print("\"ADDR\": \"" + (String)resArr.get(3)+"\", ");
			out.print("\"FILENAME\": \""+ "http://10.100.206.47:8888/01_Android_DB/upload/" + (String)resArr.get(4)+"\" ");
			out.print("} ");
			
			for(int i=5; i<resArr.size(); i+=5){ //컬럼이 4개
				out.print(",");
				out.print("{ ");
				out.print("\"NUM\": \"" + (Integer)resArr.get(i)+"\", ");
				out.print("\"NAME\": \"" + (String)resArr.get(i+1)+"\", ");
				out.print("\"TEL\": \"" + (String)resArr.get(i+2)+"\", ");
				out.print("\"ADDR\": \"" + (String)resArr.get(i+3)+"\", ");
				out.print("\"FILENAME\": \""+ "http://10.100.206.47:8888/01_Android_DB/upload/"+ (String)resArr.get(i+4)+"\" ");
				out.print("} ");
			}
			out.println("]");
			out.println("}");
		}
	

%>