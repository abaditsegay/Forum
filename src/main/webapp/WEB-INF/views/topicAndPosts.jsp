<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>Topic and Post</title>
    </head>
    <body>
        <div class="main">
            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
            <div id="registration">
                <h1>${topic.title}</h1>
                <c:forEach var="post" items="${topic.posts}">
                    <div class="post">
                        <textarea id="styled" readonly="true">${post.postContent}</textarea>        
                        <p>Name: <span style="font-weight: bold">${post.user.firstName}</span></p>
                        Date: ${post.postedDate}        
                    </div>
                </c:forEach>

            </div>
            <p><a href="home">Back to HOME</a></p>
        </div>
    </body>
</html>
