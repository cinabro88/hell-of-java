<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1 id="forms">게시판</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-1">
            <a class="btn btn-default" href="write.do" role="button">글쓰기</a>
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
</div>
<%@ include file="../footer.jsp" %>
