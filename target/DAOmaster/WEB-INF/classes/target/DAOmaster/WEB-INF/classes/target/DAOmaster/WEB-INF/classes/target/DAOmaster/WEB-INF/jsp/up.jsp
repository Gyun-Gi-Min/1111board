<%@ page import="DAOmaster.boardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% boardVO vo1 = (boardVO) request.getAttribute("abc");%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글수정페이지</title>
</head>
<body>

<h1>글을 수정중입니다.</h1>

<form action="/up" method="post">
    <div><input type="text" name="title" value="<%=vo1.getTitle()%>"></div>
    <div><textarea name="ctnt"><%=vo1.getCtnt()%></textarea></div>
    <div><input type="text" name="writer" value="<%=vo1.getWriter()%>"></div>
    <div>
        <input type="submit" value="저장">
        <input type="reset" value="초기화">
        <a href="/List">
            <input type="button" value="그냥 리스트로 갈래">
        </a>

    </div>

</form>

</body>
</html>