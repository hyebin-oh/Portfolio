<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
 <%@ include file="../include/userMypage.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
 

 <div class="container">
 <h2>��û ����</h2>     
  <table class="table table-hover">
    <thead>
      <tr>
      	<th>No</th>
        <th>�ֹ���ȣ</th>
        <th>�ֹ���</th>
        <th>����</th>     
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${order}" var="order" varStatus="st">
      	<tr>
      	  
      	   <td>${st.count}</td>
      	   <td><a href="orderView.me?ordernum=${order.ordernum}">${order.ordernum }</a></td>
     	   <td><a href="orderView.me?ordernum=${order.ordernum}">${order.orderDate}</a></td>
     	   <td><a href="orderView.me?ordernum=${order.ordernum}">${order.orderState }</a></td>
      	  
    	  </tr>
		</c:forEach>
    </tbody>
  </table>
  
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