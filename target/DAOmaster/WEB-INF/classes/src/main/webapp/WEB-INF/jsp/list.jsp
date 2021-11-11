<%@ page import="DAOmaster.boardVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<boardVO> list =(List<boardVO>)request.getAttribute("abc");
%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트~~</title>
    <style>
        table,tr,th{
            border: solid black 1px ;
            padding: 4px;
        }
        tr{
            margin: 10px;
        }

    </style>
</head>
<body>

<div>
    <a href="/insert">
        <input type="button" value="글쓰기">
    </a>
    <input type="button" value="숨기기/보이기"> <!--TODO:초기화 기능써서 내용숨기고 나오게-->
</div>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>작성일시</th>
        <th>내용</th>
    </tr>
    <% for(boardVO vo :list) { %>
    <tr>
        <td><%= vo.getIboard() %></td>
        <td>
            <a href="/Detail?iboard=<%= vo.getIboard() %>">
                <%= vo.getTitle() %>
            </a>
        </td>
        <td><%= vo.getWriter() %></td>
        <td><%= vo.getRdt() %></td>
        <td><%= vo.getCtnt() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
