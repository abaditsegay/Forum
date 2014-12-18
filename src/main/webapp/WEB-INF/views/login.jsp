<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>Login Page</title>
    </head>
    <body>
        <div class="main">
            <div id="login" style="background-color: darkkhaki">
        <c:if test="${error eq true}">
            <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        </c:if>
        <form method="post" action="<c:url value='j_spring_security_check' />">
            	<fieldset>
                    <legend>Login here</legend>
                    <p>&nbsp;</p>
            Username: <input type="text" name="j_username" value='<c:if test="${not empty param.login_error}">
                                 <c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
            Password: <input type="password" name='j_password' />
            Remember me: <input type="checkbox" name="_spring_security_remember_me" /> <br />
            <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/>
            <input type="submit" value="Login"/>
            </fieldset>
        </form>
            </div>
            <p><a href="home">Back to HOME</a></p>
            </div>
    </body>
</html>
