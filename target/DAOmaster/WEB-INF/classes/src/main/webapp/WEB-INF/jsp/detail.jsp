<%@ page import="DAOmaster.boardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% boardVO vo = (boardVO) request.getAttribute("zzz");%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> <%= vo.getTitle() %></title>
</head>
<body>
<a href="/Del?iboard=<%=vo.getIboard()%>">
    <input type="button" value="삭제하기">
</a>
<a href="/up?iboard=<%=vo.getIboard()%>">
    <input type="button" value="수정하기">
</a>

<!-- Todo: BUpServlet-->
<a href = "/List">
    <input type="button" value="리스트로 돌아가기">
</a>

<div>제목 : <%= vo.getTitle() %></div>
<div>작성자 : <%= vo.getWriter() %></div>
<div>작성일시 : <%= vo.getRdt() %></div>
<div>내용 : <%= vo.getCtnt() %></div>
</body>
</html>
