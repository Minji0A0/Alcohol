<%@page import="kh.semi.alcohol.member.model.dto.AlcoholDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주류 정보리스트</title>
</head>
<body>
	<h2>주류 리스트</h2>
	<div>
		<form action="<%=request.getContextPath() %>/alcohollist"
			method="get"%>
			<input type="search" name="searchWord"> <input type="submit"
				value="찾기">
		</form>
	</div>
	<div>
	
	   <!-- 메인 내용 -->
    <section>
        <div>
            <p>바로 여기가 메인</p>
            <div class="wrap-grid">
            <c:forEach items="${singlemaltList }" var="vo">
            	<div>${vo.productName }</div>
            </c:forEach>
            </div>
        </div>
    </section>
    
    
	</div>
	<%
	List<AlcoholDTO> volist = (List<AlcoholDTO>)request.getAttribute("alcoholPriceList");
	String searchWord = (String)request.getAttribute("searchWord");
	if(searchWord != null) {
		%>
	<h3><%=searchWord %>검색결과
	</h3>
	<h5>
		<a href="<%=request.getContextPath() %>/alcohol/get">전체보기</a>
	</h5>
	<% }
		if(volist == null || volist.size() == 0){
		%>
	<h2>결과물이 없습니다.</h2>
	<%
		}else{
		%>
	<table border="1">
		<tr>
			<td>종류</td>
			<td>상품명</td>
			<td>숙성년</td>
			<td>실거래 가격</td>
			<td>용량(ml)</td>
			<td>구매기간</td>
			<td>판매처</td>
			<td>비고</td>
		</tr>
		<%
  		for(int i=0; i<volist.size(); i++){
  			AlcoholDTO vo = volist.get(i);
        %>
		<tr>
			<td><a
				href="<%=request.getContextPath()%>/alcoholGet?sno=<%=vo.getPriceBorderNo() %>"><%=vo.getPriceBorderNo() %></a></td>
			<td><a
				href="<%=request.getContextPath()%>/alcoholGet?sno=<%=vo.getProductName() %>"><%=vo.getProductName() %></a></td>
			<td><%=vo.getRipening() %></td>
			<td><%=vo.getPrice() %></td>
			<td><%=vo.getCapacity() %></td>
			<td><%=vo.getDateOfPurcharse() %></td>
			<td><%=vo.getMarket() %></td>
			<td><%=vo.getNote() %></td>
		</tr>
		<%
          }
         %>
	</table>
	<div>
		<%

int startPageNum = (Integer)request.getAttribute("startPageNum");
int endPageNum = (Integer)request.getAttribute("endPageNum");
int currentPage = (Integer)request.getAttribute("currentPage");
int totalPageNum = (Integer)request.getAttribute("totalPageNum");
if(startPageNum != 1){
	%>
		<a href="<%=request.getContextPath() %>/alcoholPriceList?pageNo=<%=startPageNum %>&searchWord=<%=searchWord %>"><span>이전</span></a>
		,
		<%
}else if (startPageNum !=1 && searchWord == null) {
	%>
		<a href="<%=request.getContextPath() %>/alcoholPriceList?pageNo=<%=startPageNum-1 %>"><span>이전</span></a>
		,
		<%
}

for(int i = startPageNum; i <= endPageNum ; i++){
	if(searchWord != null){
		%>
		<a href="<%=request.getContextPath() %>/alcoholPriceList?pageNo=<%=i %>&searchWord=<%=searchWord %>"><span><%=i %></span></a>
		,
		<%
		}else{
		%>
		<a href="<%=request.getContextPath() %>/alcoholPriceList?pageNo=<%=i %>"><span><%=i %></</span></a>
		,
		<%
	}
}
if(endPageNum < totalPageNum && searchWord != null){
	%>
		<a
			href="<%=request.getContextPath() %>/alcoholPriceList?pageNo=<%=endPageNum+1 %>&searchWord=<%=searchWord %>"><span>다음</span></a>
		,
		<% 
}else if (endPageNum < totalPageNum && searchWord == null ){
	%>
		<a href="<%=request.getContextPath() %>/alcoholPriceList?pageNo=<%= endPageNum+1 %>"><span>다음</span></a>
		,
		<% } %>
	</div>
	<% } %>
</body>
</html>