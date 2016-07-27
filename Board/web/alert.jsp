<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="template/header.jsp" %>
<script>
    alert("${requestScope.message}");
    history.back();
</script>
<%@ include file="template/footer.jsp" %>
