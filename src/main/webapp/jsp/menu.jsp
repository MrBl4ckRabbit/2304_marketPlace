<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page import="by.itclass.constants.JSPConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav-ul">
    <c:choose>
      <c:when test="${empty user}">
        <li class="nav-li">
          <a href="<%=JSPConstant.LOGIN_JSP%>">Login</a>
        </li>
         <li class="nav-li">
                  <a href="<%=JSPConstant.REGISTRATION_JSP%>">REGISTRATION</a>
                </li>
      </c:when>
      <c:otherwise>
         <li class="nav-li float-left">
           <a class="active" href="<%=JSPConstant.HOME_JSP%>">Home</a>
         </li>
         <li class="nav-li">
           <a href="<%=AppConstant.LOGOUT_CONTROLLER%>">Logout</a>
         </li>

         <li class="nav-li float-left">
                    <a href="<%=AppConstant.TV_STOCK%>">TV</a>
                  </li>
         <li class="nav-li float-left">
                             <a href="<%=AppConstant.LAPTOP_STOCK%>">Laptop</a>
                           </li>
      </c:otherwise>
    </c:choose>
</ul>