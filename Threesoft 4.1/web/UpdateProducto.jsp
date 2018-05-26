<%-- 
    Document   : UpdateProducto.jsp
    Created on : May 24, 2018, 11:17:52 AM
    Author     : Max
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Producto</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/colorpicker.css" />
        <link rel="stylesheet" href="css/datepicker.css" />
        <link rel="stylesheet" href="css/uniform.css" />
        <link rel="stylesheet" href="css/select2.css" />
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
                            <a href="#">Update Producto</a>
                        </div>
                        <h1>Update de Producto</h1>
                    </div>
                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="span6">
                                <div class="widget-box">
                                    <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                                        <h5>Ingresar datos del Producto</h5>
                                    </div>
                                    <div class="widget-content nopadding">
                                        <form action="./updateproducto" method="post" class="form-horizontal">
                                            <div class="control-group">
                                                <label class="control-label">Nombre Producto :</label>
                                                <div class="controls">
                                                    <input required="" value="${sessionScope.productoEncontrado.nombre}" type="text" name="txtNombre" class="span11" placeholder="Nombre Producto" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Precio Compra: </label>
                                                <div class="controls">
                                                    <input required="" value="${sessionScope.productoEncontrado.precioCompra}" min="1" type="number" name="txtCompra" class="span11" placeholder="Precio Compra" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Precio Venta: </label>
                                                <div class="controls">
                                                    <input required="" min="1" value="${sessionScope.productoEncontrado.precioVenta}" type="number" name="txtVenta" class="span11" placeholder="Precio Venta" />
                                                </div>
                                            </div>
                                            <input type="hidden" value="${sessionScope.productoEncontrado.idProducto}" name="id_producto"/>
                                            <div class="form-actions">
                                                <button type="submit" class="btn btn-success">Guardar Datos</button>
                                            </div>
                                        </form>
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
            <c:if test="${sessionScope.exitoIngresoUser!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.exitoIngresoUser}"></c:out>
                    <c:remove var="exitoIngresoUser" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.errorIngresoUser!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.errorIngresoUser}"></c:out>
                    <c:remove var="errorIngresoUser" scope="session"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.userexiste!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.userexiste}"></c:out>
                    <c:remove var="userexiste" scope="session"/>
                </div>
            </c:if>
            <div class="row-fluid">
                <div id="footer" class="span12"> 2017 &copy; Threesoft</div>
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

