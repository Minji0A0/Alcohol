<%@page import="kh.semi.alcohol.member.model.dto.AlcoholPriceListDTO"%>
<%@page import="kh.semi.alcohol.member.model.dto.AlcoholDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>알콜 가격 정보</title>
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
        section{padding-left: 300px ;width: 100%; height: 2000px; background-color: rgb(255, 235, 238);float: left;}
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
                <li><a href="${pageContext.request.contextPath}/get">PRICE</a></li>
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
            <h1>주류 상세 정보</h1>
    <%--         <%= request.getAttribute("bno") %> --%>
            <%
            AlcoholPriceListDTO vo = null;
            if(request.getAttribute("bno") instanceof AlcoholPriceListDTO){
                vo = (AlcoholPriceListDTO)request.getAttribute("bno");
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