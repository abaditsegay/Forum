<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>Edit Category page</title>
    </head>
    <body>
        <div class="main">
            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
            <div id="registration">
        <form method="POST" action="updateCategory">
            Category Name: <input type="text" name="name" value="${category.categoryName}"/><br>
            Description: <input type="text" name="description" value="${category.description}"/><br>
            <input type="submit" value="Update"/>
        </form>
            </div>
            <p><a href="home">Back to HOME</a></p>
        </div>
    </body>
</html>
