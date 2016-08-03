<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h2>회원가입</h2>
            </div>
        </div>
    </div>

    <form class="form-horizontal" action="join.do" id="join" method="post">
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
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword" class="col-lg-1 control-label">비밀번호 확인</label>
                            <div class="col-lg-11">
                                <input type="password" class="form-control" id="confirmPassword"
                                       placeholder="비밀번호 확인">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-12 col-lg-offset-1">
                                <button type="reset" class="btn btn-default">취소</button>
                                <button type="submit" class="btn btn-primary">회원가입</button>
                            </div>
                        </div>
                    </form>
                    <div id="source-button" class="btn btn-primary btn-xs" style="display: none;">&lt; &gt;</div>
                </div>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">
    window.onload = function () {
        document.getElementById('join').onsubmit = function () {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;

            if (password != confirmPassword) {
                alert('비밀번호가 일치하지 않습니다.');
                return false;
            }
        }
    }
</script>

<%@ include file="../footer.jsp" %>
