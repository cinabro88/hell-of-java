<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Hell Java</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
    <%--<link href="/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>--%>
    <style type="text/css">
        /** {*/
        /*font-family: NanumGothic, 'Malgun Gothic';*/
        /*}*/

        body {
            padding-top: 50px;
            padding-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">지옥자바</a>
        </div>
        <div class="navbar-collapse collapse">
            <c:choose>
                <c:when test="${sessionScope.id == null}">
                    <form class="navbar-form navbar-right" role="form" action="login.do" method="post">
                        <div class="form-group">
                            <input type="text" placeholder="아이디" class="form-control" name="id">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="패스워드" class="form-control" name="password">
                        </div>
                        <button type="submit" class="btn btn-success">로그인</button>
                        <a href="join.do" class="btn btn-warning">회원가입</a>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="nav navbar-nav navbar-right">
                        <a href="logout.do" class="btn btn-danger navbar-btn">로그아웃</a>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>