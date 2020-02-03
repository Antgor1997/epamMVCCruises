<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : en}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages"/>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <c:import url="Header.jsp" />
        <form name="loginForm" method="post" action="controller">
            <input type="hidden" name="command" value="login" />
            Login:<br/>
            <input type="text" name="login" value=""/>
            <br/>Password:<br/>
            <input type="password" name="password" value=""/>
            <input type="submit" value="Log in"/>
        </form><hr/>
    </body>
</html>
