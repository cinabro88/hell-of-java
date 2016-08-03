<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h2 id="forms">지옥 게시판</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <table class="table table-hover">
            <thead>
            <tr class="active">
                <th class="col-md-1 text-center">글번호</th>
                <th class="col-md-8 text-left">제목</th>
                <th class="col-md-1 text-center">작성자</th>
                <th class="col-md-1 text-center">작성일</th>
                <th class="col-md-1 text-center">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.boards}" var="board">
                <tr>
                    <td class="text-center">${board.index}</td>
                    <td>${board.title}</td>
                    <td class="text-center">${board.author}</td>
                    <td class="text-center">${board.updated}</td>
                    <td class="text-center">${board.hits}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-md-12 text-right">
            <a class="btn btn-default" href="writeBoard.do" role="button">글쓰기</a>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
