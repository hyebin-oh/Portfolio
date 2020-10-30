<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
 <%@ include file="../include/userMypage.jsp" %>

<div align="left">
	<h3>${orderInfo.userid }���� �ֹ� ����</h3>
</div>

<div class="form-group">
	<label for="name">�ֹ��ڸ�</label>
	<input type="text" class="form-control" id="name" name="name" value="${orderInfo.name }"  readonly>
</div>
<div class="form-group">
	<label for="addr">����ּ�</label>
	<input type="text" class="form-control" id="addr" name="addr" value="${orderInfo.addr }" readonly>
</div>

<div class="form-group">
	<label for="phone">����ó</label>
	<input type="text" class="form-control" id="phone" name="phone" value="${orderInfo.phone }" readonly>
</div>
    
<div class="form-group">	
 	<label for="orderdate">�ֹ���</label>
	<input type="text" class="form-control" name="orderdate" id="orderdate" value="${orderInfo.orderDate }" readonly>
</div>
   
<table class="table table-hover">
   <thead>
      <tr>
        <th>��ǰ��</th>
        <th>����</th>
        <th>�ֹ� ����</th>
      </tr>
   </thead>
   <tbody>
	 <c:forEach items="${order}" var="order" varStatus="st">
      <tr>
      	<td>${order.product }</td>
      	<td>${order.count }</td>
      	<td>${order.orderState }</td>
      <tr>
     </c:forEach>
    </tbody>
</table>

<div align="center">
	<input type="button" value="�ֹ�������û�ϱ�" onclick="location='../QnA/qnaInsert.jsp'" class="btn btn-primary">
</div>
	
<div align="left">
	<input type="button" value="���" onclick="location='userOrderList.me'" class="btn btn-primary"> 
</div>
