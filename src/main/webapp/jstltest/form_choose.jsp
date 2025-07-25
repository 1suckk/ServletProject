<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<style>
		body *{
			font-family: 'Jua';
		}
		
		.nara1 {
			background-color: yellow;
			color: blue;
		}
		
		.nara2 {
			background-color: pink;
			color: gray;
		}
		
		.nara3 {
			background: black;
			color: yellow;
		}
		
		.nonara {
			background-color: cyan;
			color: red;
		}
	</style>
</head>
<body>
	<div style="margin: 20px">
		<form action="./form_choose.jsp" method="post">
			이름입력 : <input type="text" name="myname"><br>
			가고싶은 나라입력 : <input type="text" name="mynara"><br>
			<button type="submit">결과 확인</button>
		</form>
		
		<!-- jstl 로 폼 태그에 입력한 값을 바로 읽어오기 -->
		<c:if test="${!empty param.myname and !empty param.mynara}">
			<div style="margin: 20px;">
				<h5>이름 : ${param.myname }</h5>
				<h5>희망국가 : ${param.mynara }</h5>
				<hr>
				<c:set var="nara" value="${param.mynara }"/>
				
				<c:choose>
					<c:when test="${nara=='프랑스'}">
						<h2 class="nara1">프랑스는 에펠탑이 아름답습니다.</h2>
					</c:when>
					<c:when test="${nara=='미국'}">
						<h2 class="nara2">미국은 자유의 여신상이 아름답습니다.</h2>
					</c:when>
					<c:when test="${nara=='스위스'}">
						<h2 class="nara3">스위스는 알프스가 아름답습니다.</h2>
					</c:when>
					<c:otherwise>
						<h2 class="nonara">${nara} 은(는) 어떤 것이 아름다운가요?</h2>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		<c:if test="${empty param.myname or empty param.mynara}">
				<h5>모두 입력 요망</h5>
		</c:if>
	</div>
</body>
</html>