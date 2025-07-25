

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>구구단 jstl 구현</title>
        <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body *{
                font-family: 'Jua';
            }
        </style>
    </head>
    <body>
      <h4 class="alert alert-danger">문제:table을 이용해서 2~9단 전체 구구단을 출력하시오</h4> 
      <table class="table table-bordered" style="width: 95%;">
        <thead>
        <tr align="center">
		   	<c:forEach var="dan" begin="2" end="9" step="1">
		      		<td style="background-color:pink"><b>${dan}단</b></td>
		    </c:forEach>
        </tr>
        </thead>
        <tbody>
      	<c:forEach var="su" begin="1" end="9" step="1">
      		<tr align="center">
      		<c:forEach var="dan" begin="2" end="9" step="1">
      			<td>${dan} X ${su} = ${dan*su}</td>
      		</c:forEach>
      		</tr>
	 	</c:forEach>
       	</tr>
        </tbody>
      </table>
    </body>
</html>