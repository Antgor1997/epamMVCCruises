<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : en}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="$(language)">
  <head>
      <title><fmt:message key="greetings" /></title>
  </head>

  <body>
    <c:import url="views/Header.jsp" />
    <fmt:message key="test" />
    <jsp:forward page="views/Login.jsp"/>
  </body>
</html>