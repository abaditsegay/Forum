<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
        <title>Edit Topic page</title>
    </head>
    <body>
        <form method="POST" action="updateTopic">
            Topic Title: <input type="text" name="name" value="${topic.title}"/><br>
            <input type="submit" value="Update"/>
        </form>

    </body>
</html>
