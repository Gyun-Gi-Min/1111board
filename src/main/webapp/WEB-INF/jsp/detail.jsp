<%@ page import="DAOmaster.boardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    boardVO vo = (boardVO) request.getAttribute("zzz");
    String strIboard = request.getParameter("iboard");

    // Object prevIboard = request.getAttribute("prevIboard")
    // prevIboard 는 object

    int prevIboard = (int)request.getAttribute("prevIdx");
    int nextIboard = (int)request.getAttribute("nextIdx");


%>

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

<div>
    <% if(prevIboard !=0) { %>
        <a href="/Detail?iboard=<%=prevIboard%>">이전글</a>
    <% } %>



    <% if(nextIboard !=0) { %>
        <a href="/Detail?iboard=<%=nextIboard%>">다음글</a>
    <% } %>

</div>


<div>no : <%= vo.getIboard() %></div>
<div>제목 : <%= vo.getTitle() %></div>
<div>작성자 : <%= vo.getWriter() %></div>
<div>작성일시 : <%= vo.getRdt() %></div>
<div>내용 : <%= vo.getCtnt() %></div>




<h1>↓↓↓↓ 오늘의 사진 ↓↓↓↓</h1>
<img src="https://picsum.photos/200/300?random=<%=vo.getIboard()%>" width="500px" height="500px">
<!--random=1 해도 노상관-->

</body>
</html>
