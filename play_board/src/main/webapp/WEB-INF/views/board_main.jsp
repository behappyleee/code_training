<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Board Main </title>
</head>
<body>
<!-- Board Main Page -->
<div>
	<h1> Board Page 입니다. </h1>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
			<c:if test="${boardData!=null}">
				<c:forEach var="board" items="${boardData}">
					<tr>
						<td>${board.board_no}  </td>		
						<td>${board.board_title}  </td>
						<td>${board.board_writer}  </td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

</div>		
		
		
		
		
		
	


</body>
</html>