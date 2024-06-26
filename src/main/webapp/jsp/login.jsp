<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page import="by.itclass.constants.JSPConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JSPConstant.MENU_JSP%>"/>
    <img class="default-image" src="<%=JSPConstant.BACKGROUND_IMAGE%>" alt="img">
    <div class="form-box">
        <h2>Login</h2>
        <form action="<%=AppConstant.LOGIN_CONTROLLER%>" method="post">
            <input name="<%=JSPConstant.LOGIN_PARAM%>" placeholder="Login">
            <input type="password" name="<%=JSPConstant.PASS_PARAM%>" placeholder="Password">
            <input type="submit" value="Login">
        </form>
        <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
        </c:if>
    </div>
</body>
</html>