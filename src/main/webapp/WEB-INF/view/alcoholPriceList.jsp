<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<title>주류 정보리스트</title>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/index.css">

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    
    <script>
    </script>

    <style>
        *{margin: 0; padding: 0;box-sizing: border-box;}
        
        /* TODO 상단 Hhader 고정  nav 고정 해야함 */
        .center{text-align: center; justify-content: center;}
        #container{width: 1200px; margin: 20px auto;}
        header{width:  100%; height: 30px%; background-color: palevioletred; padding: 5px; position: fixed;}
        section{padding-left: 200px ;width: 100%; height: 2000px; background-color: white;float: left;}
        .main_formsearch{padding-left: 200px ;}
        .main_table{border : 1px solid #ccc}
        .main_table_tr{background-color: rgb(255, 235, 238) ;}
        input[type="submit"],button[type="BUTTON"],button[type="submit"] {background-color: rgb(204, 193, 218); border:2px solid rgb(217, 150, 148); padding: 5px; border-radius: 20%;   justify-content: center; }
        .rounded-submit {display: inline-block; padding: 5px 10px; border: none; border-radius: 5px; cursor: pointer;}
        .in_main{width: 880px;}
        .in_head{height: 20px; margin: 5px ; }
        .in_nav{ height: 100px ;text-align: center; display: flex;}
        /* 광고 */
        .in_site{background-color:white; width:250px; height: 100%; position: fixed; left: 0; float: left;}
        .in_sidepanel{display: flex; justify-content: center; width:250px; height: 100%; background-color:  white; position: fixed; right: 0;}
        .in_sidep {margin: 15px;}
        .in_side_input {background-color: rgb(255, 226, 231); margin: 2px; padding: 20px; border-radius: 20px;}
        .in_add { width: 250px; height:600px; padding: 10px;}
        input[type="text"] {width: 90px; padding: 3px; margin: 5px; justify-content: right;  }
        input[type="password"] {width: 90px; padding: 3px; margin: 5px; justify-content: right;  }
        nav ul {margin:35px ;background-color: pink;  width: 100%;  list-style-type: none; display: flex; padding: 22px;position: fixed;  justify-content: center;}
        nav ul li {padding: 0 20px ;margin: 0 30px; text-transform: uppercase; font-weight: bold; color: #333;}
        footer{width: 100%; height: 100px;;background-color: pink; position: fixed; bottom: 20px;}
        .in_foott{width: 100%; height: 20px;;background-color: gray; clear: left; position: fixed; bottom: 0;}
        .foot_logo{padding: 40px 50px;}
        footer ul {list-style: none; margin: 0; padding: 0;}
        footer ul li {font-size: 12px; color: #666;}
    </style>
<!-- 경고창 띄우기 - 3 -->
<jsp:include page="/WEB-INF/view/msg.jsp"/>	
    </head>
<body>

    <div cliss="container">
    <!-- 상단 -->
    <header>
        <div class="in_head">
            <p><b>■ ALCOHOL FREE PRICE</b></p> 
        </div>
    </header>
    
    <!-- 상단 메뉴바 -->
    <nav>
        <div class="in_nav center">
            <ul>
                <li>ABOUT</li> 
                <li><a href="${pageContext.request.contextPath}/pricelist">PRICE</a></li>
                <li>Community</li>
                <li>SALE</li>
                <li>MAP</li>
            </ul>
        </div>
    </nav>

    <!-- 왼쪽 광고 -->
    <siteLink>
    <div class="in_site">
        <table>
            <tr>
                <td>
                    <img src="/resources/images/광고1.png" class="in_add">
                </td>
            </tr>
        </table>

    </div>
    </siteLink>

    <!-- 메인 내용 -->
    <section>
        <div>
          

	<h2 class="main_formsearch">주류 리스트</h2>
	<div>
		<form action="<%=request.getContextPath() %>/pricelist" method="get" class="main_formsearch">
			<input type="search" name="searchWord"> 
			<input type="submit" value="찾기">
		</form>
	</div>
	<div>
	
<!-- 메인 내용 -->
    <section>
        <div>
        
            <div class="wrap-grid">
            </div>
			</div>
			<c:if test="${not empty searchWord }">
				<h3>${searchWord } 검색결과</h3>
				<h5>
					<a href="<%=request.getContextPath() %>/pricelist">전체보기</a>
				</h5>
			</c:if>
			
			<c:choose>
			<c:when test="${empty alcoholList}">
				<h2>결과물이 없습니다.</h2>
			</c:when>
			<c:otherwise>
			<table class="main_table">
			<tr class="main_table_tr">
			<td>종류</td>
			<td>상품명</td>
			<td>숙성년</td>
			<td>실거래 가격</td>
			<td>용량(ml)</td>
			<td>구매기간</td>
			<td>판매처</td>
			<td>비고</td>
		</tr>
		<c:forEach items="${alcoholList }" var="dto">
		<tr>
			<td><a	href="<%=request.getContextPath()%>/get?bno=${dto.priceBorderNo}">${dto.borderKind}</a></td>
			<td><a	href="<%=request.getContextPath()%>/get?bno=${dto.priceBorderNo}">${dto.productName}</a></td>
			<td>${dto.ripening }</td>
			<td>${dto.price }</td>
			<td>${dto.capacity }</td>
			<td>${dto.dateOfPurcharse }</td>
			<td>${dto.market }</td>
			<td>${dto.note }</td>
		</tr>
		</c:forEach>
	</table>
</c:otherwise>
</c:choose>

<!-- 페이징처리 div -->
	<div class="wrap-paging">
	<c:if test="${startPageNum != 1}">
		<c:choose>
			<c:when test="${not empty searchWord }">
				<a href="<%=request.getContextPath() %>/pricelist?pageNo=${startPageNum-1}&searchWord=${searchWord}"><span> 이전 </span></a>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath() %>/pricelist?pageNo=${startPageNum-1}"><span> 이전 </span></a>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:forEach begin="${startPageNum}" end="${endPageNum}" step="1" var="i">
		<c:choose>
			<c:when test="${not empty searchWord }">
				<a href="<%=request.getContextPath() %>/pricelist?pageNo=${i}&searchWord=${searchWord}"><span> ${i } </span></a>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath() %>/pricelist?pageNo=${i}"><span> ${i } </span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum < totalPageNum}">
		<c:choose>
			<c:when test="${not empty searchWord }">
				<a href="<%=request.getContextPath() %>/pricelist?pageNo=${endPageNum+1}&searchWord=${searchWord}"><span> 다음 </span></a>
			</c:when>
			<c:otherwise>
				<a href="<%=request.getContextPath() %>/pricelist?pageNo=${endPageNum+1}"><span>  다음  </span></a>
			</c:otherwise>
		</c:choose>
	</c:if>
	</div>
    </section>
    
	</div>



        </div>
    </section>
    
    
    
    <!-- 오른쪽 로그인 및 회원 정보 -->
    <sidepanel class="in_sidepanel">
        <div class="in_sidep">
<c:choose>
<c:when test="${empty loginedInfo }">
        <form action = "${pageContext.request.contextPath}/login" method="post">
            <div class="in_side_input">
                <p style="text-align: right;">ID <input type="text" name="userId"></p>
                <p style="text-align: right;">PW <input type="password" name="userPw"></p>
                <button type="submit" class="rounded-button" style="text-align: right;">LOGIN</button>
                <a href="${pageContext.request.contextPath}/join"> <button type="button" class="rounded-button" style="text-align: right;">JOIN</button></a>
            </div>
        </form>
</c:when>
<c:otherwise>
            <div class="in_side_input">
				<form action = "${pageContext.request.contextPath}/logout" method="post">
                <button type="submit" class="rounded-button" style="text-align: right;">LOGOUT</button>
    	    	</form>
	            <button type="button" class="rounded-button" style="text-align: right;">MYPAGE</button>
            </div>
</c:otherwise>
</c:choose>
        </div>
    </sidepanel>
    
    
    <!-- 하단 -->
    <footer>
        <div>
            <table >
                <tr>
                    <td class="foot_logo"> 여기 로고 </td>
                    <td>
                        <ul>
                            <li>회사소개	이용약관	개인정보처리방침	청소년보호정책		회원탈퇴	고객센터	제휴문의</li>
                            <li>Alcohol Free Price㈜ | 대표이사 : 관리자 | 소재지 : 서울특별시 강남구 강남대로7길 15 여기빌딩 123동 1234-2호 (강남대로, 요기조기회관)</li>
                            <li>사업자등록번호 : 118-81-22301 | 통신판매업신고 : 강남 제 07-1232-3432호</li>
                            <li>개인정보보호책임자 : 관리자 (admin@alcoholfree.com) | 호스팅 제공 : mycom㈜</li>
                        </ul>
                        <ul>
                            <li>Copyright ⓒ Alcohol Free Price Corp. All Rights Reserved.</li>
                        </ul>
                    </td>
                </tr>
            </table>
        </div>
    </footer>

    <div class="in_foott">

    </div>

</div>


</body>
</html>