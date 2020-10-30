<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
 <%@ include file="../include/adminMypage.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  


 <div class="container">
 	<h2>��û ����</h2>     
  	
  	<table class="table table-hover">
		<thead>
    		<tr>
    			<th></th>
    			<th>no</th>
    			<th>�ֹ���(�̸�)</th>
   	 			<th>�ֹ���(ID)</th>
    			<th>�ֹ���</th>        
    			<th>�� �ֹ� ����</th>
    		</tr>
    	</thead>
    	
    	<tbody>
    		<c:forEach items="${order}" var="order" varStatus="st">
    			<tr>
    				<td><input type="hidden" name="ordernum" id="ordernum" value="${order.ordernum }"></td>
    				<td><a href="adminOrderView.me?ordernum=${order.ordernum }">${st.count}</a></td>
    				<td><a href="adminOrderView.me?ordernum=${order.ordernum }">${order.name }</a></td>
    				<td><a href="adminOrderView.me?ordernum=${order.ordernum }">${order.userid }</a></td>
    				<td><a href="adminOrderView.me?ordernum=${order.ordernum }">${order.orderDate }</a></td>
    				<td>${order.count }</td>
    			</tr>
			</c:forEach>
    	</tbody>
 	</table>
  
 	<div align="center">
  		<form class=table-form>
  			<select name="f">
  			    <option ${(param.f=="name")?"selected":"" } value="name">�ֹ��� �̸�</option>
  				<option ${(param.f=="userid")?"selected":"" } value="userid">�ֹ��� ID</option>
				<!-- �ٸ� ������ �� �� value���� ���̺��� �÷���� �����ϰ� �ؾ� �� -->
  			</select>
  			
  			<input type="text" name="q" value="${param.q }"/>
  			<!-- param.q�� �˻�� ���� �ִ� �� -->
  			<input type="submit" value="�˻�" class="btn btn-primary"/>  
  		</form> 
    </div>
  
 	<div align="center">
 		<c:set var="page" value="${(empty param.p)?1:param.p }"/>
  		<c:set var="startNum" value="${page-(page-1)%5 }"/>
  		<!-- ���۹�ȣ��1, ������ ������� 5 -->
  		<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"/>
  		<!-- �� �������� ��µ� ����Ʈ ���� 10�� -->
  		
  		<c:if test="${startNum>1 }">
  			<a href="?p=${startNum-1 }&f=&q=">����</a>
  		</c:if>
  		<c:if test="${startNum<=1 }">
  			<a onclick="alert('�����������������ϴ�');">����</a>
  		</c:if>

  		<c:forEach var="i" begin="0" end="4">
  			<c:if test="${(startNum+i)<= lastNum}">
  				<a href="?p=${startNum+i}&f=${param.f }&q=${param.q}">${startNum+i }</a>
  			</c:if>
  		</c:forEach>  	

  		<c:if test="${startNum+4<lastNum }">
  			<a href="?p=${startNum+5 }&f=&q=">����</a>
  		</c:if>
  		<c:if test="${startNum+4>=lastNum }">
  			<a onclick="alert('������������ �����ϴ�');">����</a>
  		</c:if>

 	</div> 
  
</div>