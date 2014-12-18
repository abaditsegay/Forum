<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>Category edit page</title>
    </head>
    <body>
        <div class="main">
            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
            <div id="registration">
        <h1>List Of Categories</h1>
        <form method="GET" action="topics">
            <select name="selectedItem">
                <c:forEach var="category" items="${categories}">
                    <option  name="category"  value="${category.id}">${category.categoryName}</option>
                </c:forEach>
            </select>
            <input type="submit" value="View Topics"/>

        </form>
         <sec:authorize access="hasRole('ROLE_ADMIN')">
        <form method="GET" action="addTopic">
            <select name="selectedItem">
                <c:forEach var="category" items="${categories}">
                    <option  name="category"  value="${category.id}">${category.categoryName}</option>
                </c:forEach>
            </select>
             <input type="submit" value="Add Topics"/> 
        </form>
         </sec:authorize>
            </div>
            <p><a href="home">Back to HOME</a></p>
        </div>
    </body>
</html>
