<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 메인 페이지</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style>
		body *{
			font-family: 'Jua';
		}
		
		a.pagea:hover {
			text-decoration: underline;
		}
	</style>
</head>
<body>
	<jsp:include page="../kakao/kakaologin.jsp" />
	<br><br>
	<hr>
	<div style="margin: 20px;">
		<table class="tab1 table table-bordered">
			<caption align="top">
				<b>총 ${totalCount}개의 글이 있습니다.</b>
				<button type="button" class="btn btn-sm btn-outline-secondary"
				style="float: right"
				onclick="location.href='./writeform'">글쓰기</button>
			</caption>
			<thead>
				<tr>
					<th width="50">번호</th>
					<th>제목</th>
					<th width="100">작성자</th>
					<th width="100">작성일</th>
					<th width="50">조회</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${totalCount==0}">
					<tr height="50">
						<td colspan="5" align="center" valign="middle">
							<b>등록된 게시글이 없습니다.</b>
						</td>
					</tr>
				</c:if>
				<c:if test="${totalCount>0}">
					<c:forEach var="dto" items="${list}" varStatus="i">
						<tr>
							<td align="center">${totalCount-i.index}</td>
							<td align="center">
								<!-- 제목부분 -->
								<a style="cursor:pointer;text-decoration: none; color: black;"
								href="./detail?num=${dto.num}&pageNum=${pageNum}">
									<!-- level 1당 3칸 정도 띄우기 -->
									<c:forEach begin="1" end="${dto.relevel}">
										&nbsp;&nbsp;&nbsp;
									</c:forEach>
									<!-- 답글인 경우는 앞에 리플 이미지 넣기 -->
									<c:if test="${dto.relevel>0}">
										<img src="../image/re.png">
									</c:if>
									<span>${dto.subject}</span>
								</a>
							</td>
							<td align="center">${dto.writer}</td>
							<td align="center" style="font-size: 0.9em;">
								<fmt:formatDate value="${dto.writeday}"
								pattern="yyyy.MM.dd"/>
							</td>
							<td align="center">${dto.readcount}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		
		<!-- 페이지번호 출력 -->
		<div style="text-align: center;">
			<!-- 이전; 1페이지가 시작페이지면 안나옮 -->
			<c:if test="${startPage>1}">
				<a class="pagea" href="./list?pageNum=${startPage-1}"
				style="color: black;">&lt;이전</a>&nbsp;
			</c:if>
			
			<c:forEach var="pp" begin="${startPage}" end="${endPage}">
				<c:if test="${pp==pageNum}">
					<a class="pagea" href="./list?pageNum=${pp}"
					style="color: green;">${pp}</a>&nbsp;
				</c:if>
				<c:if test="${pp!=pageNum}">
					<a class="pagea" href="./list?pageNum=${pp}"
					style="color: black;">${pp}</a>&nbsp;
				</c:if>
			</c:forEach>
			
			<!-- 다음 버튼 -->
			<c:if test="${endPage < totalPage}">
        		<a class="pagea" href="./list?pageNum=${endPage+1}"
        		style="color: green;">다음&gt;</a>&nbsp;
    		</c:if>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<form method="post" name="search" action="search.jsp">
				<table class="pull-right">
					<tr>
						<td>
							<select class="form-control" name="searchField">
								<option value="title">제목</option>
								<option value="id">작성자</option>
							</select>
						</td>
						<td>
							<input type="text" class="form-control"
							placeholder="검색어 입력" name="searchText" maxlength="100">
						</td>
						<td>
							<button type="submit" class="btn btn-success">검색</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>