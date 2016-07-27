<%--
  Created by IntelliJ IDEA.
  User: mingook
  Date: 2016년7월 17일 (일)
  Time: 오후 6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="color" class="com.example.web.ColorModel" scope="request"/>

Param :
<jsp:getProperty name="color" property="color"/>

${requestScope.message}

</body>
</html>
