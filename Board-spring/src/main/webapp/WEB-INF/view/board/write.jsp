<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h2>글쓰기</h2>
            </div>
        </div>
    </div>

    <form role="form" action="/board/write" method="post">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력하세요.">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea rows="10" name="content" class="form-control" id="content" placeholder="내용을 입력하세요."></textarea>
        </div>
        <div class="text-right">
            <button type="submit" class="btn btn-default">완료</button>
        </div>
    </form>
    <br/>
</div>
<%@ include file="../footer.jsp" %>
