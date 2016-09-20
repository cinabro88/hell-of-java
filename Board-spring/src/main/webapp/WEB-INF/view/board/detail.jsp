<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h2>${board.title}</h2>
            </div>
        </div>
    </div>
    <div class="row col-md-12">
        <p><strong>작성자 : ${board.author}</strong></p>
    </div>

    <div class="jumbotron row col-md-12">
        ${board.content}
    </div>
    <div class="row col-md-12">
        <div class="text-right">
            <a href="#" class="btn btn-primary">수정</a>
            <a href="#" class="btn btn-danger">삭제</a>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
