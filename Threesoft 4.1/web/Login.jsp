<%-- 
    Document   : Login
    Created on : May 3, 2018, 8:21:52 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="css/login.css"/>
        <!------ Include the above in your HEAD tag ---------->
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 text-center">
                    <div class="search-box">
                        <div class="caption">
                            <h3>Threesoft Login</h3>
                            <p>Ingrese sus datos</p>
                        </div>
                        <form action="./validaIngreso" method="post" class="loginForm" >
                            <div class="input-group">
                                <input type="text" name="txtUserName" id="name" class="form-control" placeholder="Full Name">
                                <input type="password" name="txtPass" id="pass" class="form-control" placeholder="Password">
                                <input type="submit" id="submit" class="form-control" value="Submit">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="aro-pswd_info">
                        <div id="pswd_info">
                            <h4>Password must be requirements</h4>
                            <ul>
                                <li id="letter" class="invalid">At least <strong>one letter</strong></li>
                                <li id="capital" class="invalid">At least <strong>one capital letter</strong></li>
                                <li id="number" class="invalid">At least <strong>one number</strong></li>
                                <li id="length" class="invalid">Be at least <strong>8 characters</strong></li>
                                <li id="space" class="invalid">be<strong> use [~,!,@,#,$,%,^,&,*,-,=,.,;,']</strong></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--<script src="js/login_validation.js"></script>--%>
    </body>
</html>
