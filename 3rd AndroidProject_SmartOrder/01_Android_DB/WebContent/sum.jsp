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
	
	String strOnum = request.getParameter("ordernum")==null?"":request.getParameter("ordernum").trim();;
		
	int sum=0;
	
	try{
		sum= QueryBean.getSum(strOnum);	
	}catch(SQLException e){
		out.print(e.toString());
	}finally{
		QueryBean.closeConnection();
	}
	
	//ArrayList ordernum = new ArrayList();
	
	

	//json형식의 값 전달 시작
			out.println("{");
			
			if(sum==0){ //db값이 없을 경우 json 끝맺음
				out.println("}");
				
			}else{ //db값이 존재할경우 컬럼값 표시
				out.print("\"SUM\": \"" + sum+"\" ");
				out.print("} ");
				
			}
	
	
	
	/*
	//json형식의 값 전달 시작
			out.println("{");
			out.println("\"datas\":[");
			
			if(ordernum.size()==0){ //db값이 없을 경우 json 끝맺음
				out.println("]");
				out.println("}");
				
			}else{ //db값이 존재할경우 컬럼값 표시
				out.print("{ ");
				out.print("\"NUM\": \"" + (Integer)ordernum.get(0)+"\" ");
				out.print("} ");
				
				for(int i=1; i<ordernum .size(); i+=1){ //컬럼이 4개
					out.print(",");
					out.print("{ ");
					out.print("\"NUM\": \"" + (Integer)ordernum.get(i)+"\" ");
					out.print("} ");
				}
				out.println("]");
				out.println("}");
			}
			*/
			
	
		

	
	System.out.println("ordernum: "+ strOnum);
	System.out.println("sum:"+sum);
	
%>