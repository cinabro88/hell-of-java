<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <div class="page-header">
            <h1 id="forms">로그인</h1>
        </div>
    </div>
</div>
<form class="form-horizontal" action="login.do" method="post">
    <div class="row">
        <div class="col-lg-12">
            <div class="well bs-component">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="id" class="col-lg-1 control-label">아이디</label>
                        <div class="col-lg-11">
                            <input type="text" class="form-control" id="id" name="id" placeholder="아이디">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-lg-1 control-label">비밀번호</label>
                        <div class="col-lg-11">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="비밀번호">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox">자동로그인</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-12 col-lg-offset-1">
                            <button type="reset" class="btn btn-default">취소</button>
                            <button type="submit" class="btn btn-primary" name="action" value="login">로그인</button>
                            <button type="submit" class="btn btn-danger" name="action" value="join">회원가입</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</form>

<%@ include file="../footer.jsp" %>