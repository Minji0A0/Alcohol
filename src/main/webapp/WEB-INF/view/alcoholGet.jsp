<%@page import="kh.semi.alcohol.member.model.dto.AlcoholPriceListDTO"%>
<%@page import="kh.semi.alcohol.member.model.dto.AlcoholDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알콜 가격 정보</title>
</head>
<body>
	<h1>주류 상세 정보</h1>
	<%= request.getAttribute("bvo") %>
	<%
	AlcoholPriceListDTO vo = null;
	if(request.getAttribute("bvo") instanceof AlcoholPriceListDTO){
		vo = (AlcoholPriceListDTO)request.getAttribute("bvo");
	}
	%>
	<% System.out.println("alcoholGet.jsp : " + vo); %>
	<table border="1">
		<tr>
			<td>No.</td>
			<td><%=vo.getPriceBorderNo() %></td>
		</tr>
		<tr>
			<td>종류</td>
			<td><%=vo.getBorderKind() %></td>
		</tr>
		<tr>
			<td>제품명</td>
			<td><%=vo.getProductName() %></td>
		</tr>
		<tr>
			<td>숙성년</td>
			<td><%=vo.getRipening() %></td>
		</tr>
		<tr>
			<td>실거래 가격</td>
			<td><%=vo.getPrice() %></td>
		</tr>
		<tr>
			<td>용량</td>
			<td><%=vo.getCapacity() %></td>
		</tr>
		<tr>
			<td>구매기간</td>
			<td><%=vo.getDateOfPurcharse() %></td>
		</tr>
		<tr>
			<td>판매처</td>
			<td><%=vo.getMarket() %></td>
		</tr>
		<tr>
			<td>비고</td>
			<td><%=vo.getNote() %></td>
		</tr>
	</table>
</body>
</html>