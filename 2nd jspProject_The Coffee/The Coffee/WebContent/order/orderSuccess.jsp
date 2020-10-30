<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>


<div class="container single_product_container">
	<br><br><br>
	<div align="center">
		<h5>주문이 완료되었습니다.</h5>
	</div>
	<br>
	<div align="center">
		<input type="button" id="btnOrderList" value="주문확인하기" onclick="location.href='../order/userOrderList.me'"  class="btn btn-primary">
		<input type="button" id="btnToHome" value="홈으로" onclick="location.href='../main/main.jsp'" class="btn btn-primary">
	</div>
</div>