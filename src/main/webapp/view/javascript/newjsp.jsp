<%-- 
    Document   : newjsp
    Created on : 6 déc. 2018, 20:57:42
    Author     : c
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenue à la gestion de votre profil</h1>
        <div>
        <select class="custom-select">
            <option selected>More details about..</option>
            <option value="1">Food</option>
            <option value="2" >Water</option>
            <option value="3">Energy</option>
            <option value="4">Health</option>
            <option value="5">Equipment</option>
            <option value="6">Maintenance</option>
        </select>
        </div>
    </body>
</html>
