<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>Add Category</title>
    </head>
    <body>
        <div class="main">
            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
            <div id="registration" style="width: 600px;">
       <form:form commandName="category" action="addCategory" method="post">
            <table>
                <tr>
                    <td>Category Name:</td>
                    <td><form:input path="categoryName"  /> </td>
                    <td><form:errors path="categoryName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Category Description:</td>
                    <td><form:input path="description" /> </td>
                    <td><form:errors path="description" cssClass="error"/> </td>
                </tr>
                <tr><td colspan="2"><input type="submit" value="Add Category"/></td><td><a href="categories">See categories</a></td></tr>
            </table>
            
        </form:form>
       <c:if test="${cat.categoryName}">
           <c:out value="${cat.categoryName} successfully added"></c:out>
       </c:if>
            </div>
            <p><a href="home">Back to HOME</a></p>
            </div>
    </body>
</html>
