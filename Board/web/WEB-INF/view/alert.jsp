<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<script>
    alert("${requestScope.message}");
    history.back();
</script>
<%@ include file="footer.jsp" %>
