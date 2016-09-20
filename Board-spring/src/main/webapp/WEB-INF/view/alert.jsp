<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<%@ include file="footer.jsp" %>
<script>
    alert("${requestScope.message}");
    history.back();
</script>