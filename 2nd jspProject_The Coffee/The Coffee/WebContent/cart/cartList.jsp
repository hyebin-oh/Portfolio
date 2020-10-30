<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<div class="container single_product_container">
	<br>
	<h3>장바구니</h3>
	<hr>

	 <div class="container">
	 	<!-- 장바구니에 담긴 상품이 없을 때 -->
		 <c:if test="${count==0 }">
 			<div align="center">
 				<p>상품이 존재하지 않습니다</p>
 			</div>
 		</c:if>
 		
 		<!-- 장바구니에 상품이 존재할 때 -->
		<c:if test="${count!=0 }">
			<div align="left">
				<p>총 ${count}개의 상품이 존재합니다</p>
 			</div>
 			
			<table class="table table-hover">
				<thead>
      				<tr>
        				<th>no</th>
        				<th>타입</th>     
				        <th>상품</th>
        				<th>수량</th>
        				<th>삭제</th>
        			</tr>
    			</thead>
    			<tbody>
      				<c:forEach items="${cart}" var="cart" varStatus="st">
      					<tr>
     	    				<td>${st.count}</td>
     	    				<td>${cart.ptype }</td>
     	    				<td>${cart.product}</td>
     	    				<td>${cart.count }</td>
     	    				<td><a href="cartDelete.me?cnum=${cart.cnum }">삭제</a></td>
     	  				</tr>     	    
    				</c:forEach>
				</tbody>
			</table>
			
			<div align="center">
			<input type="button" class="btn btn-primary" value="주문하기"
					  onclick="location.href='../order/orderCheck.me?userid=${userid}'">
			</div>
			
  		</c:if>
  	</div>
 </div>
