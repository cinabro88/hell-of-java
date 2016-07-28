<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../template/header.jsp" %>
<div class="row">
    <div class="col-lg-1">
        <a class="btn btn-default" href="board/write.jsp" role="button">글쓰기</a>
    </div>
    <div class="col-lg-11">
        ${sessionScope.id} 님 환영합니다.
    </div>
</div>
<div class="row">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.boards}" var="board">
            <tr>
                <td>${board.index}</td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>${board.author}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="../template/footer.jsp" %>
