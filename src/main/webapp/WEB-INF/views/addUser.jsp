<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>User registration</title>
    </head>
    <body>
         <div class="main">
            <div id="registration">
        <p>New? Register Here Existing?<a href="login">Login here</a></p>
        <form method="POST" action="addUser">
            <table>
            <tr> <td>First Name: </td><td><input type="text" name="fname"/></td></tr>           
            <tr><td>Last Name: </td><td><input type="text" name="lname"/></td></tr>
            <tr><td>E-mail: </td><td><input type="text" name="email"/></td></tr>
            <tr><td>Password: </td><td><input type="password" name="password"/></td></tr>
            <tr><td><input type="submit" value="Register"/></td></tr>
            </table>
        </form>
        </div>
             <p><a href="home">Back to HOME</a></p>
</div>
    </body>
</html>
