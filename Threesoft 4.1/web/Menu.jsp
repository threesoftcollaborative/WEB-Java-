<%-- 
    Document   : Menu
    Created on : Nov 10, 2017, 9:54:36 PM
    Author     : Max
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/colorpicker.css" />
        <link rel="stylesheet" href="css/datepicker.css" />
        <link rel="stylesheet" href="css/uniform.css" />
        <link rel="stylesheet" href="css/select2.css" />
        <link rel="stylesheet" href="css/awesome-style.css" />
        <link rel="stylesheet" href="css/awesome-media.css" class="skin-color" />
        <title>Menu</title>
    </head>
    <body>
        <jsp:include flush="true" page="/allMenu"/>
        <jsp:useBean id="menu" class="cl.duoc.threesoft.entities.SgaMenu" scope="page"/>
        <!--left-menu-stats-sidebar-->
        <div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Home</a>
            <ul>
                <li class="active"><a href="AdminHome.jsp"><i class="icon icon-home"></i> <span>Home</span></a></li>
                    <c:forEach var="menu" items="${listadoMenu}">
                    <li > 
                        <a href="<c:out value="${menu.destino}"/>"><i class="icon icon-wrench"></i> <span><c:out value="${menu.descripcion}"/></span> 
                    </li>
                </c:forEach>
            </ul>
        </div>
        <script src="js/jquery.min.js"></script> 
        <script src="js/jquery.ui.custom.js"></script> 
        <script src="js/bootstrap.min.js"></script> 
        <script src="js/bootstrap-colorpicker.js"></script> 
        <script src="js/bootstrap-datepicker.js"></script> 
        <script src="js/jquery.uniform.js"></script> 
        <script src="js/select2.min.js"></script> 
        <script src="js/awesome.js"></script> 
        <script src="js/awesome.form_common.js"></script>
    </body>
</html>
