<%-- 
    Document   : ListadoProducto
    Created on : Nov 25, 2017, 4:36:01 AM
    Author     : Max
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Productos</title>
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
                            <a href="#">Listado Producto</a>
                        </div>
                        <h1>Listado de Producto</h1>
                    </div>
                    <div class="container-fluid">
                        <jsp:include flush="true" page="/getallproducto"/>
                        <jsp:useBean id="SgaProducto" class="cl.duoc.threesoft.entities.SgaProducto"/>
                        <div class="row-fluid">
                            <div class="span12">
                                <div class="widget-box">
                                    <div class="widget-title">
                                        <span class="icon"><i class="icon-th"></i></span> 
                                        <h5>Listado de Productos</h5>
                                    </div>
                                    <div class="widget-content nopadding">
                                        <table class="table table-bordered data-table">
                                            <thead>
                                                <tr>
                                                    <th>Nombre Poducto</th>
                                                    <th>Precio Venta</th>
                                                    <th>Precio Compra</th>
                                                    <th>Stock</th>
                                                    <th>Marca</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${sessionScope.productList}" var="SgaProducto">
                                                    <tr class="gradeX">
                                                        <td>${SgaProducto.nombre}</td>
                                                        <td>$${SgaProducto.precioVenta}</td>
                                                        <td>$${SgaProducto.precioCompra}</td>
                                                        <td>${SgaProducto.stock}</td>
                                                        <td>${SgaProducto.idMarca.marca}</td>
                                                        <c:url var="update" value="/updateproducto">
                                                            <c:param name="product_id" value="${SgaProducto.idProducto}"/>
                                                        </c:url>
                                                        <td class="center"><button class="btn btn-primary btn-mini" onclick="window.location.href = '${update}'">Modificar</button></td>
                                                        <c:url var="remove" value="/deshabilitarproducto">
                                                            <c:param name="product_id" value="${SgaProducto.idProducto}"/>
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
            <c:if test="${sessionScope.exitoProducto!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.exitoProducto}"></c:out>
                    <c:remove var="exitoProducto" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.errorProducto!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.errorProducto}"></c:out>
                    <c:remove var="errorProducto" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.exitoProductoUpdate!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.exitoProductoUpdate}"></c:out>
                    <c:remove var="exitoProductoUpdate" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.errorProductoUpdate!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.errorProductoUpdate}"></c:out>
                    <c:remove var="errorProductoUpdate" scope="session"/>
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
