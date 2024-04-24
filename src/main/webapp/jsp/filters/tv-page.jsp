<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page import="by.itclass.constants.JSPConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>TV page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
      <jsp:include page="<%=JSPConstant.MENU_JSP %>"/>
      <jsp:include page="/jsp/filters/tv-filter.html"/>
      <c:choose>
       <c:when test="${not empty tvs}">
       <c:forEach var="tv" items="${tvs}">
               <div class="stock-item-box">
               <img class="small-image" src="/img/tv/${tv.vendor}-${tv.model}.jpg" alt="img">
               <p>Vendor ${tv.vendor}</p>
                <p>Model ${tv.model}</p>
                 <p>Price ${tv.price} byn</p>
                 <form method="post" action="<%=AppConstant.CART_CONTROLLER%>">
                   <input type="hidden" name="<%=JSPConstant.CART_ACTION_PARAM%>" value="add">
                   <input type="hidden" name="<%=JSPConstant.ITEM_TYPE_PARAM%>" value="1">
                   <input type="hidden" name="<%=JSPConstant.ITEM_ID_PARAM%>" value="${tv.id}">
                   <input type="hidden" name="<%=JSPConstant.ITEM_VENDOR_PARAM%>" value="${tv.vendor}">
                   <input type="hidden" name="<%=JSPConstant.ITEM_MODEL_PARAM%>" value="${tv.model}">
                   <input type="hidden" name="<%=JSPConstant.ITEM_PRICE_PARAM%>" value="${tv.price}">
                   <input type="hidden" name="<%=JSPConstant.ITEM_QUANTITY_PARAM%>" value="1">
                   <input type="submit" value="Add to cart">
                 </form>
               </div>
             </c:forEach>
       </c:when>
        <c:otherwise>
         <h1>Sorry ,the search have returned empty result..
        </c:otherwise>
      </c:choose>
</body>
</html>