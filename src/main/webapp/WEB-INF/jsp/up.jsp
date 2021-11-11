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

<form action="/up" method="post" id="fom">
    <input type="hidden" name ="iboard" value="<%= vo1.getIboard() %>">
    <div><input type="text" name="title" value="<%=vo1.getTitle()%>"></div>
    <div><textarea name="ctnt"><%=vo1.getCtnt()%></textarea></div>
    <div><input type="text" name="writer" value="<%=vo1.getWriter()%>"></div>
    <div>
        <input type="submit" value="저장">
        <input type="reset" value="수정하기전으로">
        <input type="button" value="초기화" onclick="clean()";>
        <a href="/List">
            <input type="button" value="그냥 리스트로 갈래">
        </a>

    </div>

</form>
<script>
    function clean(){
    var fom = document.querySelector('#fom');
    if(fom){ //name으로 접근해서 value값 바꾸기
        fom.title.value='';
        fom.ctnt.value='';
        fom.writer.value='';
    }
    }

</script>



</body>
</html>