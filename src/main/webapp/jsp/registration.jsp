<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page import="by.itclass.constants.JSPConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
       <div class="form-box">
            <h2>Registration</h2>
            <form action="<%=AppConstant.REGISTRATION_CONTROLLER%>" method="post">
                <input name="<%=JSPConstant.NAME_PARAM%>" placeholder="Name">
                <input name="<%=JSPConstant.EMAIL_PARAM%>" placeholder="Email">
                <input name="<%=JSPConstant.LOGIN_PARAM%>" placeholder="Login">
                <input type="password" name="<%=JSPConstant.PASS_PARAM%>" placeholder="Password">
                <input type="submit" value="Register">
            </form>
            <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
            </c:if>
       </div>
</body>
</html>