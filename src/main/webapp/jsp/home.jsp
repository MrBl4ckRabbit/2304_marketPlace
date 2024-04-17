<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page import="by.itclass.constants.JSPConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
      <jsp:include page="<%=JSPConstant.MENU_JSP %>"/>
      <c:if test="${not empty tvs}">
      <c:forEach var="tv" items="${tvs}">
        <div class="stock-item-box">
        <img class="small-image" src="/img/tv/${tv.vendor}-${tv.model}.jpg" alt="img">
        <p>Vendor ${tv.vendor}</p>
         <p>Model ${tv.model}</p>
          <p>Price ${tv.price} byn</p>
        </div>
      </c:forEach>
      </c:if>
</body>
</html>