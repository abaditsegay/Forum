
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>Add Post</title>
    </head>
    <body>
        
        <div class="main" style="text-align: center">
            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
            <div id="registration">
        <p>Welcome: <span style="font-size: 16pt;color: blue;"> ${user.firstName}</span></p>
        <p>Please insert your comment in the box below</p>
        <form method="POST" action="addPost">
            <textarea rows="10" cols="47" name="comment"></textarea>
            <input type="hidden" id="selectedItem" name="selectedItem" value="${param.selectedItem}"/><br>
            <br>
            <input type="submit" value="Post Comment"/>
        </form>
            </div>
            <p><a href="home">Back to HOME</a></p>
       </div>
    </body>
</html>
