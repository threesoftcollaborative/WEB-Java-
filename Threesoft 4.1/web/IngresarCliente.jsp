<%-- 
    Document   : IngresarCliente
    Created on : May 24, 2018, 2:52:16 PM
    Author     : Max
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Cliente</title>
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
                            <a href="#">Ingresar Cliente</a>
                        </div>
                        <h1>Ingreso de Clientes</h1>
                    </div>
                    <div class="container-fluid">
                        <jsp:useBean id="SgaComuna" class="cl.duoc.threesoft.entities.SgaComuna" scope="page"/>
                        <jsp:include flush="true" page="/cargacomuna"/>
                        <div class="row-fluid">
                            <div class="span6">
                                <div class="widget-box">
                                    <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                                        <h5>Ingresar datos del Cliente</h5>
                                    </div>
                                    <div class="widget-content nopadding">
                                        <form action="./ingresocliente" method="post" class="form-horizontal">
                                            <div class="control-group">
                                                <label class="control-label">RUT Cliente:</label>
                                                <div class="controls">
                                                    <input required="" maxlength="10" type="text" name="txtRut" class="span11" placeholder="RUT Cliente" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Nombre Cliente:</label>
                                                <div class="controls">
                                                    <input required="" type="text" name="txtNombre" class="span11" placeholder="Nombre Cliente" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Apellido Cliente:</label>
                                                <div class="controls">
                                                    <input required="" type="text" name="txtApellido" class="span11" placeholder="Apellido Cliente" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Telefono: </label>
                                                <div class="controls">
                                                    <input required="" min="1"  type="number" name="txtTelefono" class="span11" placeholder="Telefono" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Email: </label>
                                                <div class="controls">
                                                    <input required="" type="email" name="txtEmail" class="span11" placeholder="Email" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Fecha de Nacimiento: </label>
                                                <div class="controls">
                                                    <input required="" type="date" name="datePicker" class="span11" placeholder="Fecha de Nacimiento" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Direccon: </label>
                                                <div class="controls">
                                                    <input required="" type="text" name="txtDireccion" class="span11" placeholder="Direccion" />
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label">Comuna:</label>
                                                <div class="controls">     
                                                    <select required="" name="ddlComuna">
                                                        <option value=""><c:out value="--Seleccione--"/></option>
                                                        <c:forEach items="${sessionScope.comunaList}" var="SgaComuna">
                                                            <option value="${SgaComuna.idComuna}"><c:out value="${SgaComuna.comuna}"/></option> 
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
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
            <c:if test="${sessionScope.clienteExiste!=null}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${sessionScope.clienteExiste}"></c:out>
                    <c:remove var="clienteExiste" scope="session"/>
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

