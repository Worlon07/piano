<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Backend piano codding exercise</title>
	<style>
<style>
  table {
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #ccc;
    padding: 2px;
    text-align: left;
  }
</style>

	</style>		
</head>
<body>
    <div id="search" align="center">
        <form method="GET">
            <input type="input" name="title" value="${title}"/>
            <input type="submit" value="search"/>
        </form>
    </div>
    <div id="content" align="center">
        <c:if test="${page>1}">
           <a href="?title=${title}&page=${page-1}">
        </c:if>
        Prior
        <c:if test="${page>1}">
           </a>
        </c:if>
        &nbsp;
        <c:if test="${questions.isHasMore()}">
           <a href="?title=${title}&page=${page+1}">
        </c:if>
        Next
        <c:if test="${questions.isHasMore()}">
           </a>
        </c:if>
		<table>
			<tr>
				<th>Title</th>
				<th>Creation Date</th>
				<th>Author</th>
			</tr>
		  <c:forEach items="${questions.items}" var="question">
            <c:choose>
                <c:when test="${question.isAnswered()}">
            <tr style="background-color:#fff">
                </c:when>
                <c:otherwise>
            <tr style="background-color: lightgrey;">
                </c:otherwise>
            </c:choose>
				<td><a href="${question.link}" title="${question.title}">${question.title}</a></td>
				<td>${question.formattedCreationDate}</td>
				<td align="center"><img src="${question.owner.profileImage}" height="50px" width="50px"/><br/>${question.owner.displayName}</td>
			</tr>
		  </c:forEach>
		</table>
    </div>
</body>
</html>