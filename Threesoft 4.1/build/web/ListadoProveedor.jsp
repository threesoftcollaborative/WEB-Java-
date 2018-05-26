<%-- 
    Document   : ListadoProveedor.jsp
    Created on : May 17, 2018, 10:34:44 PM
    Author     : Max
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Proveedor</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/fullcalendar.css" />
        <link rel="stylesheet" href="css/awesome-style.css" />
        <link rel="stylesheet" href="css/awesome-media.css" class="skin-color" />
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.usuarioConectado!=null}">
                <!--Header-part-->
                <div id="header">
                    <h1><a href="AdminHome.html">Threesoft Admin</a></h1>
                </div>
                <!--close-Header-part-->  

                <!--top-Header-menu-->
                <div id="user-nav" class="navbar navbar-inverse">
                    <ul class="nav">
                        <li class=""><a title="" href="logout"><i class="icon icon-share-alt"></i> <span class="text">Cerrar Sesion</span></a></li>
                    </ul>
                </div>
                <!--close-top-Header-menu-->

                <!--left-menu-stats-sidebar-->
                <jsp:include flush="true" page="Menu.jsp"/>
                <!--close-left-menu-stats-sidebar-->

                <div id="content">
                    <div id="content-header">
                        <div id="breadcrumb">
                            <a href="AdminHome.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
                            <a href="#">Listado Proveedor</a>
                        </div>
                        <h1>Listado de Proveedor</h1>
                    </div>
                    <div class="container-fluid">
                        <jsp:include flush="true" page="/getallproveedor"/>
                        <jsp:useBean id="SgaProveedor" class="cl.duoc.threesoft.entities.SgaProveedor"/>
                        <div class="row-fluid">
                            <div class="span12">
                                <div class="widget-box">
                                    <div class="widget-title">
                                        <span class="icon"><i class="icon-th"></i></span> 
                                        <h5>Listado de Proveedor</h5>
                                    </div>
                                    <div class="widget-content nopadding">
                                        <table class="table table-bordered data-table">
                                            <thead>
                                                <tr>
                                                    <th>Nombre Proveedor</th>
                                                    <th>Rut</th>
                                                    <th>Telefono</th>
                                                    <th>Email</th>
                                                    <th>Direccion</th>
                                                    <th>Comuna</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${sessionScope.proveedorList}" var="SgaProveedor">
                                                    <tr class="gradeX">
                                                        <td>${SgaProveedor.nombre}</td>
                                                        <td>${SgaProveedor.rut}</td>
                                                        <td>${SgaProveedor.fono}</td>
                                                        <td>${SgaProveedor.email}</td>
                                                        <td>${SgaProveedor.direccion}</td>
                                                        <td>${SgaProveedor.idComuna.comuna}</td>
                                                        <c:url var="update" value="/updateproveedor">
                                                            <c:param name="proveedor_id" value="${SgaProveedor.idProveedor}"/>
                                                        </c:url>
                                                        <td class="center"><button class="btn btn-primary btn-mini" onclick="window.location.href = '${update}'">Modificar</button></td>
                                                        <c:url var="remove" value="/deshabilitarproveedor">
                                                            <c:param name="proveedor_id" value="${SgaProveedor.idProveedor}"/>
                                                        </c:url>
                                                        <td class="center"><button class="btn btn-danger btn-mini" onclick="window.location.href = '${remove}'">Eliminar</button></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><hr>
                </c:when>
                <c:otherwise>
                    <c:redirect url="Login.jsp"/>
                </c:otherwise>
            </c:choose>
            <c:if test="${sessionScope.exitoProveedor!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.exitoProveedor}"></c:out>
                    <c:remove var="exitoProveedor" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.errorProveedor!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.errorProveedor}"></c:out>
                    <c:remove var="errorProveedor" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.exitoProveedorUpdate!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.exitoProveedorUpdate}"></c:out>
                    <c:remove var="exitoProveedorUpdate" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.errorProveedorUpdate!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.errorProveedorUpdate}"></c:out>
                    <c:remove var="errorProveedorUpdate" scope="session"/>
                </div>
            </c:if>
            <div class="row-fluid">
                <div id="footer" class="span12"> 2017 &copy; Threesoft</div>
            </div>
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/fullcalendar.min.js"></script>
            <script src="js/awesome.js"></script>
            <script src="js/awesome.calendar.js"></script>
    </body>
</html>