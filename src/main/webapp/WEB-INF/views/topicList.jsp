<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>List Of Topics</title>
    </head>
    <body>
        <div class="main">
            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
            <div id="registration">
        <h1>List Of Topics</h1>

        <form method="GET" action="addPost">
            <select name="selectedItem">
                <c:forEach var="topic" items="${topics}">
                    <option  name="topic"  value="${topic.id}">${topic.title}</option>
                </c:forEach>
            </select>         
            <input type="submit" value="Add Post"/>     
        </form>
        

            </div>
            <p><a href="home">Back to HOME</a></p>
        </div>
    </body>
</html>
