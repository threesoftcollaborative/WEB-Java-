<%-- 
    Document   : AdminHome
    Created on : Nov 10, 2017, 9:36:37 PM
    Author     : Max
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title><meta charset="UTF-8" />
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
                    <h1><a href="AdminHome.jsp">Threesoft Admin</a></h1>
                </div>
                <!--close-Header-part-->

                <!--top-Header-menu-->
                <div id="user-nav" class="navbar navbar-inverse">
                    <ul class="nav">
                        <li class=""><a title="" href="logout"><i class="icon icon-share-alt"></i> <span class="text">Cerrar Sesion</span></a></li>
                    </ul>
                </div>

                <!--Menu Principal-->
                <jsp:include flush="true" page="Menu.jsp"/>
                <!--Fin menu principal-->

                <div id="content">
                    <div id="content-header">
                        <div id="breadcrumb">
                            <a href="AdminHome.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
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
                            <!--boletas-totales-->
                            <!--jsp:include flush="true" page="TotalBoletas.jsp" / -->
                            <!-- fin total boletas -->

                            <!--Listado boleta-->
                            <!--jsp:include flush="true" page="ListadoBoleta.jsp" / -->
                            <!-- fin total boletas -->

                        </div>
                    </div>

                </div>
                <c:if test="${sessionScope.boletaAnulada!=null}">
                    <div class="alert alert-success" role="alert">
                        <c:out value="${sessionScope.boletaAnulada}"></c:out>
                        <c:remove var="boletaAnulada" scope="session"/>
                    </div>
                </c:if>
                <c:if test="${sessionScope.errorAnulada!=null}">
                    <div class="alert alert-success" role="alert">
                        <c:out value="${sessionScope.errorAnulada}"></c:out>
                        <c:remove var="errorAnulada" scope="session"/>
                    </div>
                </c:if>
            </div>
        </c:when>
        <c:otherwise>
            <c:redirect url="Login.jsp"/>
        </c:otherwise>
    </c:choose> 

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
