<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
</head>
<body>

<h1>글쓰는중.................</h1>

<form action="/insert" method="post">
    <div><input type="text" name="title" placeholder="제목을 입력 하세요"></div>
    <div><textarea name="ctnt" placeholder="내용을 입력 하세요"></textarea></div>
    <div><input type="text" name="writer" placeholder="작성자명을 입력 하세요"></div>
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
