<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<div class="container">
    <form role="form" action="/writeBoard.do" method="post">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력하세요.">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <input type="text" name="content" class="form-control" id="content" placeholder="내용을 입력하세요.">
        </div>
        <button type="submit" class="btn btn-default">완료</button>
    </form>
    <br/>
</div>

<%@ include file="../footer.jsp" %>
