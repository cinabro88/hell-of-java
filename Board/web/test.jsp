<%--
  Created by IntelliJ IDEA.
  User: mingook
  Date: 2016년8월 2일 (화)
  Time: 오후 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>점보트론 템플릿</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        * {
            font-family: NanumGothic, 'Malgun Gothic';
        }

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
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">토글 네비게이션</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">점보트론</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" role="form">
                <div class="form-group">
                    <input type="text" placeholder="이메일" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="패스워드" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">로그인</button>
            </form>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container">
        <h1>안녕, 친구들!</h1>
        <p>간단한 마케팅 또는 정보 웹사이트를 위한 템플릿입니다. 중앙에 점보트론이라 부르는 큰 영역이 있고 그 아래에 작은 콘텐츠 영역 3개를 배치하였습니다. 새 웹사이트를 만들 때 시작지점으로
            활용해보세요.</p>
        <p><a class="btn btn-primary btn-lg" role="button">자세히 알아보기 &raquo;</a></p>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h2>헤딩</h2>
            <p>우리나라의 말이 중국과 달라 문자가 서로 통하지 않는데 이런 이유로 어리석은 백성이 말하고자 하는 바가 있어도 마침내 제 뜻을 능히 펴지 못하는 사람이 많으니라. 내 이를 불쌍히 여겨 새로
                스물여덟 자를 만드니 사람마다 하여금 쉽게 익혀 매일 쓰기에 편안하게 하고자 할 따름이니라.</p>
            <p><a class="btn btn-default" href="#" role="button">더보기 &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>헤딩</h2>
            <p>우리나라의 말이 중국과 달라 문자가 서로 통하지 않는데 이런 이유로 어리석은 백성이 말하고자 하는 바가 있어도 마침내 제 뜻을 능히 펴지 못하는 사람이 많으니라. 내 이를 불쌍히 여겨 새로
                스물여덟 자를 만드니 사람마다 하여금 쉽게 익혀 매일 쓰기에 편안하게 하고자 할 따름이니라.</p>
            <p><a class="btn btn-default" href="#" role="button">더보기 &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>헤딩</h2>
            <p>우리나라의 말이 중국과 달라 문자가 서로 통하지 않는데 이런 이유로 어리석은 백성이 말하고자 하는 바가 있어도 마침내 제 뜻을 능히 펴지 못하는 사람이 많으니라. 내 이를 불쌍히 여겨 새로
                스물여덟 자를 만드니 사람마다 하여금 쉽게 익혀 매일 쓰기에 편안하게 하고자 할 따름이니라.</p>
            <p><a class="btn btn-default" href="#" role="button">더보기 &raquo;</a></p>
        </div>
    </div>


</div>


<div class="container">
    <hr>
    <footer>
        <p>&copy; CINABRO</p>
    </footer>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
</body>
</html>